package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.dto.SampleVO;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyReservationMapper {
    ReservationVO getReservationVO(int userId); // 유저 아이디를 사용해서 예약 1건 가져오기
    PlaceDTO getReservationPlaceInfo(int branchId); // 지점 아이디를 사용해서 지점별 반려견 유모차 정보 가져오기
}
