package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 예약 관련 데이터베이스 작업을 처리하는  Mapper interface 개발
 * 예약 정보, 개모차 잔여 개수 등의 기능을 제공합니다.
 * @author Eunchan Jeong
 * @since 2024.06.19
 * @version 1.0
 *
 * <pre>
 * 수정일        	수정자       				              수정내용
 * ----------  ----------------    ------------------------------------------------------------------
 *  2024.06.22      최유경
 *  2024.06.21      정은찬          예약 정보 삽입, 반려견 유모차 잔여 개수 받기, 반려견 유모차 잔여 개수 업데이트
 *  2024.06.19     	정은찬        		                     최초 생성
 * </pre>
 */
@Mapper
public interface ReservationMapper {
    
    // 예약 정보 삽입
    public int insert(ReservationVO reservationVO);

    // 개모차 잔여 개수 받기
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO);
    
    // 개모차 개수 등록
    public int insertStollerCount(ReservationConfirmVO reservationConfirmVO);
    
    //  개모차 개수 업데이트
    public int updateStollerCount(ReservationConfirmVO reservatonConfirmVO);

    // 개모차 예약수 차감
    public int deleteStrollerCount(ReservationConfirmVO reservatonConfirmVO);

    // 개모차 개수 삽입
    default int mergeStollerCount(ReservationConfirmVO vo) {
        int updatedRows = updateStollerCount(vo);
        if (updatedRows == 0) {
            return insertStollerCount(vo);
        }
        return updatedRows;
    }
}
