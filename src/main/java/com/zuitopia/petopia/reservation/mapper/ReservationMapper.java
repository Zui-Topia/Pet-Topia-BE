package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    
    // 예약 정보 삽입
    public int insert(ReservationVO reservationVO);
//    public ReservationVO getCurrentInfo(ReservationVO reservationVO);

    // 반려견 유모차 잔여 개수 받기
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO);
    
    // 반려견 유모차 잔여 개숫 등록
    public int insertStollerCount(ReservationConfirmVO reservationConfirmVO);
    
    //  반려견 유모차 잔여 개수 업데이트
    public int updateStollerCount(ReservationConfirmVO reservatonConfirmVO);
    

}
