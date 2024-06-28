package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 예약 관련 데이터베이스 작업을 처리하는  Mapper interface
 * @apiNote 예약 정보, 개모차 잔여 개수 등의 기능을 제공
 *
 * @author 정은찬
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 *  2024.06.22      최유경           리팩토링 및 mergeStrollerCount, 예약 삭제
 *  2024.06.21      정은찬           예약 정보 생성, 개모차 잔여 등록 및 업데이트
 *  2024.06.19     	정은찬        		       최초 생성
 * </pre>
 */
@Mapper
public interface ReservationMapper {
    
    /**
     * 예약 정보를 삽입하는 메소드
     * @param reservationVO
     * @return int
     */
    public int insert(ReservationVO reservationVO);

    /**
     * 개모차 잔여 개수를 가져오는 메소드
     * @param reservationConfirmVO
     * @return Integer
     */
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO);
    
    /**
     * 개모차 개수를 등록하는 메소드
     * @param reservationConfirmVO
     * @return int
     */
    public int insertStrollerCount(ReservationConfirmVO reservationConfirmVO);
    
    /**
     * 개모차 개수를 업데이트하는 메소드
     * @param reservationConfirmVO
     * @return int
     */
    public int updateStrollerCount(ReservationConfirmVO reservationConfirmVO);

    /**
     * 개모차 예약 개수를 차감하는 메소드
     * @param reservationConfirmVO
     * @return int
     */
    public int deleteStrollerCount(ReservationConfirmVO reservationConfirmVO);

    /**
     * 개모차 개수를 삽입하는 메소드
     * @param reservationConfirmVO
     * @return int
     */
    default int mergeStrollerCount(ReservationConfirmVO reservationConfirmVO) {
        int updatedRows = updateStrollerCount(reservationConfirmVO);
        if (updatedRows == 0) {
            return insertStrollerCount(reservationConfirmVO);
        }
        return updatedRows;
    }
}
