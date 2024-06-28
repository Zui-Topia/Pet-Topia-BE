package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import java.util.List;

/**
 * 마이페이지 service interface
 *
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       최유경           최신 예약 1건, 과거 예약 내역, 예약 삭제 작성
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
public interface MyPageService {

    /**
     * 사용자 정보 조회 메소드
     *
     * @param userId
     * @return MyInfoDTO
     * @throws NullPointerException 사용자 정보 오류
     */
    MyInfoDTO getMyInformation(int userId) throws NullPointerException;

    /**
     * 사용자의 최신 예약 1건 가져오는 메소드
     *
     * @param userId
     * @return MyReservationDTO
     * @throws NullPointerException 예약 정보 오류
     */
    MyReservationDTO getMyLatestReservation(int userId) throws NullPointerException;

    /**
     * 사용자 과거 예약 내역 전체 조회하는 메소드
     *
     * @param userId
     * @return List<MyReservationDTO>
     */
    List<MyReservationDTO> getMyReservationHistory(int userId);

    /**
     * 예약 취소하는 메소드
     *
     * @param reservationId
     * @return int
     * @throws Exception 예약 취소 실패
     */
    int deleteMyReservation(int reservationId) throws Exception;
}
