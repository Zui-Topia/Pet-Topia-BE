package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.dto.MyPageResponseDTO;
import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.dto.PetSizeEnum;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import com.zuitopia.petopia.mypage.mapper.MyPageInformationMapper;
import com.zuitopia.petopia.mypage.mapper.MyReservationMapper;
import com.zuitopia.petopia.reservation.mapper.ReservationMapper;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 마이페이지 서비스 구현체
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    -----------------------------------
 * 2024.06.22       최유경           최신 예약 1건, 과거 예약 내역, 예약 삭제 작성
 * 2024.06.20       최유경                   날짜, 시간, 요일 가공하기
 * 2024.06.19     	최유경        		        최초 생성
 * </pre>
 */
@Service
@AllArgsConstructor
@Log
public class MyPageServiceImpl implements MyPageService {
    private final MyPageInformationMapper myPageInformationMapper;
    private final MyReservationMapper myReservationMapper;
    private final ReservationMapper reservationMapper;

    /**
     * @param userId
     * @return MyInfoDTO
     * @throws NullPointerException 1. 등록되지 않은 사용자입니다.
     */
    @Override
    public MyPageResponseDTO getMyInformation(int userId) throws NullPointerException {
        // 사용자 정보 가져오기
        MyPageUserDTO myPageUserDTO = myPageInformationMapper.getMyPageUserDTO(userId);
        if(myPageUserDTO==null)
            throw new NullPointerException("등록되지 않은 사용자입니다.");
        log.info("myPageUserDTO : " + myPageUserDTO.toString());

        // 반려견 정보 가져오기
        MyPagePetDTO myPagePetDTO = myPageInformationMapper.getMyPagePetDTO(userId);
        myPagePetDTO.setPetSizeString(PetSizeEnum
                .findByPetBtn(myPagePetDTO.getPetSize())
                .getPetSize());
        log.info("myPagePetDTO : " + myPagePetDTO.toString());
        try{
            MyReservationDTO myReservationDTO = getMyLatestReservation(userId);
            return MyPageResponseDTO.builder()
                    .myPageUserDTO(myPageUserDTO)
                    .myPagePetDTO(myPagePetDTO)
                    .myReservationDTO(myReservationDTO)
                    .build();
        }
        catch (NullPointerException e){
            log.info("[오류] " + e.getMessage());
            return MyPageResponseDTO.builder()
                    .myPageUserDTO(myPageUserDTO)
                    .myPagePetDTO(myPagePetDTO)
                    .myReservationDTO(null)
                    .build();
        }
    }

    /**
     * @param userId
     * @return MyReservationDTO
     * @throws NullPointerException 1. 예약 내역이 존재하지 않습니다.
     *                              2. 정보 데이터가 존재하지 않습니다.
     */
    @Override
    public MyReservationDTO getMyLatestReservation(int userId) throws NullPointerException {
        // 사용자의 최신 예약 1건 가져오기
        ReservationVO reservationVO = myReservationMapper.getReservationVO(userId);
        if(reservationVO==null)
            throw new NullPointerException("예약 내역이 존재하지 않습니다.");
        log.info("reservationVO : " + reservationVO.toString());

        // 날짜 가공하기
        String reservationDate = reservationVO.getReservationDate();
        reservationVO.setReservationDate(convertToDateFormat(reservationDate));

        // 시간 가공하기
        String reservationVisitTime = reservationVO.getReservationVisitTime();
        reservationVO.setReservationVisitTime(convertToTimeFormat(reservationVisitTime));

        // 해당 예약에 대해서 반려견 유모차 정보 가져오기
        PlaceDTO placeDTO = myReservationMapper.getReservationPlaceInfo(reservationVO.getBranchId());
        if(placeDTO==null)
            throw new NullPointerException("정보 데이터가 존재하지 않습니다.");

        return MyReservationDTO.builder()
                .reservationVO(reservationVO)
                .placeDTO(placeDTO)
                .build();
    }

    /**
     * @apiNote 취소된 예약 내역까지 조회
     * @param userId
     * @return List<MyReservationDTO>
     */
    @Override
    public List<MyReservationDTO> getMyReservationHistory(int userId) {
        List<MyReservationDTO> myReservationDTOList = new ArrayList<>();
        try{
            // 사용자의 최신 예약 1건 가져오기
            List<ReservationVO> reservationVOList = myReservationMapper.getReservationVOList(userId);

            for(ReservationVO vo : reservationVOList){
                // 날짜 가공하기
                String reservationDate = vo.getReservationDate();
                vo.setReservationDate(convertToDateFormat(reservationDate));

                // 시간 가공하기
                String reservationVisitTime = vo.getReservationVisitTime();
                vo.setReservationVisitTime(convertToTimeFormat(reservationVisitTime));

                // 해당 예약에 대해서 반려견 유모차 정보 가져오기
                PlaceDTO placeDTO = myReservationMapper.getReservationPlaceInfo(vo.getBranchId());

                myReservationDTOList.add(MyReservationDTO.builder()
                                            .reservationVO(vo)
                                            .placeDTO(placeDTO)
                                            .build());
            }
            return myReservationDTOList;
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        return myReservationDTOList;
    }

    /**
     * 예약 취소하는 메서드
     * @param reservationId
     * @return int
     * @throws Exception 1. 예약 삭제가 실패하였습니다.
     * @throws NullPointerException 1. 이미 처리된 예약입니다.
     */
    @Override
    @Transactional
    public int deleteMyReservation(int reservationId) throws Exception {
        // 예약 내역 가져오기
        ReservationVO reservationVO = myReservationMapper.getReservationVOByReservationId(reservationId);
        if(reservationVO==null)
            throw new NullPointerException("이미 처리된 예약입니다.");

        // 유모차 개수 업데이트 해주기
        int deleteCount = reservationMapper.deleteStrollerCount(ReservationConfirmVO.builder()
                .branchId(reservationVO.getBranchId())
                .reservationDate(reservationVO.getReservationDate())
                .build());

        if(deleteCount!=1)
            throw new Exception("예약 삭제가 실패하였습니다.");

        // 예약 삭제하기
        int deleteResult = myReservationMapper.deleteReservation(reservationId);
        if(deleteResult!=1)
            throw new Exception("예약 삭제가 실패하였습니다.");

        return deleteResult;
    }

    /**
     * 날짜 형식을 바꾸는 메서드
     * @apiNote YYYY-MM-DD 형식을 YYYY.MM.DD 형식으로 변경
     * @param reservationDate
     * @return String
     */
    private String convertToDateFormat(String reservationDate){
        StringBuilder dateSb = new StringBuilder();

        //yyyy-mm-dd 형식에서 yyyy.mm.dd 형식으로 변경하기
        dateSb.append(reservationDate.replace("-","."));
        dateSb.append(" ");
        dateSb.append(StringWeekday(reservationDate));
        return dateSb.toString();
    }

    /**
     * 시간 형식을 바꾸는 메서드
     * @apiNote 오전과 오후까지 제공
     * @param reservationVisitTime
     * @return String
     */
    private String convertToTimeFormat(String reservationVisitTime){
        // 마지막에서 두 번째 문자까지 잘라내기
        String visitTimeOnly = reservationVisitTime
                .substring(0, reservationVisitTime.length() - 2);
        StringBuilder timeSb = new StringBuilder();

        // 오전/오후 추출하기
        timeSb.append(reservationVisitTime.contains("AM") ? "오전" : "오후");
        timeSb.append(" ");
        timeSb.append(visitTimeOnly);
        return timeSb.toString();
    }

    /**
     * 요일을 추출하는 메서드
     * @param date
     * @return String
     */
    private String StringWeekday(String date){
        LocalDate localDate = LocalDate.parse(date);

        // 한국 시간 기준으로 요일 추출하기
        String week = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        return week;
    }
}
