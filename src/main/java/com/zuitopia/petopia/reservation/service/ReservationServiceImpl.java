package com.zuitopia.petopia.reservation.service;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.ReservationRequestDTO;
import com.zuitopia.petopia.reservation.mapper.ReservationMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


/**
 * 예약 관련 서비스 구현체
 * @author 정은찬
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 *  2024.06.22      최유경                        리팩토링
 *  2024.06.21      정은찬                  개모차 잔여수 업데이트하기
 *  2024.06.20      정은찬                   개모차 잔여수 가져오기
 *  2024.06.20      정은찬                 예약정보를 예약 테이블에 저장하기
 *  2024.06.19     	정은찬        		       최초 생성
 * </pre>
 */
@Log
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationMapper reservationMapper;

    /**
     * @param reservationRequestDTO
     * @return ReservationVO
     * @throws Exception 1. 예약을 실패했습니다
     */
    @Override
    public ReservationVO createReservation(ReservationRequestDTO reservationRequestDTO) throws Exception {

        // 1. ReservationVO 생성 및 ReservationDTO 정보 받아오기
        ReservationVO reservationVO = ReservationVO.builder()
                .userId(reservationRequestDTO.getUserId())
                .branchId(reservationRequestDTO.getBranchId())
                .reservationDate(reservationRequestDTO.getReservationDate())
                .reservationVisitTime(reservationRequestDTO.getReservationVisitTime())
                .build();
        
        // 2. reservationToken 생성
        String reservationToken = createRandomReservationToken(reservationRequestDTO.getUserId());
        reservationVO.setReservationToken(reservationToken);

        // 3. 예약정보 저장하기
        int isInserted = reservationMapper.insert(reservationVO);

        if (isInserted == 1) {  // 예약을 성공했을 때
            return reservationVO;
        }
        else { // 예약을 실패했을 경우
            throw new Exception("예약을 실패했습니다");
        }

    }

    /**
     * @param reservationConfirmVO
     * @return Integer
     */
    @Override
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO) {
        
        // 개모차 잔여 개수 가져오기
        Integer confirmCnt = reservationMapper.getStrollerCount(reservationConfirmVO);
        
        // null값일 때 20으로 저장
        if(confirmCnt==null){
            return 20;
        }

        return 20 - confirmCnt;
    }

    /**
     * @param strollerCnt
     * @param reservationConfirmVO
     * @return int
     * @throws Exception 1. 개모차 잔여개수 업데이트를 실패했습니다
     */
    @Override
    public int insertOrUpdateStrollerCount(Integer strollerCnt, ReservationConfirmVO reservationConfirmVO) throws Exception {
        
        // 개모차 잔여 개수 업데이트하기
        int isUpdated = reservationMapper.mergeStrollerCount(reservationConfirmVO);
        if (isUpdated != 1) {
            throw new Exception("개모차 잔여 개수 업데이트를 실패했습니다");
        }
        return isUpdated;
    }

    /**
     * @param userId
     * @return String
     */
    private String createRandomReservationToken(int userId){
        Random random = new Random();
        // 두자리수 난수
        int randomNumber = random.nextInt(90) + 10;
        String randomString = String.valueOf(randomNumber);
        // 현재 시간 여섯자리수
        LocalTime currentTime = LocalTime.now();
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HHmmss"));

        String reservationToken = randomString + formattedTime + userId;
        return reservationToken;
    }
}
