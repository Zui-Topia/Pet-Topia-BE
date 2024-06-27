package com.zuitopia.petopia.reservation.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;

/**
 * 예약 관련 서비스 interface 개발
 * 예약 정보 저장, 개모차 잔여 개수 가져오기 등의 기능을 제공합니다.
 * @author Eunchan Jeong
 * @since 2024.06.19
 * @version 1.0
 *
 * <pre>
 * 수정일        	수정자       				              수정내용
 * ----------  ----------------    ------------------------------------------------------------------
 *  2024.06.21      정은찬                             개모차 잔여수 업데이트하기
 *  2024.06.20      정은찬                               개모차 잔여수 가져오기
 *  2024.06.20      정은찬                             예약정보를 예약DB에 저장하기
 *  2024.06.19     	정은찬        		                     최초 생성
 * </pre>
 */
public interface ReservationService {
    /**
     * 예약정보를 예약DB에 저장하는 메소드
     * @param reservationDTO
     * @return ReservationVO
     * @throws Exception 예약 실패
     */
    public ReservationVO createReservation(ReservationInfoDTO reservationDTO) throws Exception;

    /**
     * 개모차 잔여 개수를 가져오는 메소드
     * @param reservationConfirmVO
     * @return Integer
     */
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO);

    /**
     * 개모차 잔여 개수를 업데이트하는 메소드
     * @param strollerCnt
     * @param reservationConfirmVO
     * @return int
     * @throws Exception 개모차 잔여 개수 업데이트 실패
     */
    public int insertOrUpdateStollerCount(Integer strollerCnt, ReservationConfirmVO reservationConfirmVO) throws Exception;

}
