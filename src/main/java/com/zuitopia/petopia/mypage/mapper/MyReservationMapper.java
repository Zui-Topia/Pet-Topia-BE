package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 마이페이지 예약 정보 Mapper interface
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       최유경           유저의 과거 내역, 예약 정보 조회, 예약 삭제하기 기능 추가
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Mapper
public interface MyReservationMapper {

    /**
     * 유저 아이디를 사용해서 최근 예약 1건 가져오는 메서드
     * @param userId
     * @return ReservationVO
     */
    ReservationVO getReservationVO(int userId);

    /**
     * 예약 아이디를 사용해서 예약 정보 가져오는 메서드
     * @param reservationId
     * @return ReservationVO
     */
    ReservationVO getReservationVOByReservationId(int reservationId);

    /**
     * 유저 아이디를 사용해서 전체 예약 내역 가져오는 메서드
     * @param userId
     * @return List<ReservationVO>
     */
    List<ReservationVO> getReservationVOList(int userId);

    /**
     *  지점 아이디를 사용해서 지점별 정보 가져오는 메서드
     * @param branchId
     * @return PlaceDTO
     */
    PlaceDTO getReservationPlaceInfo(int branchId);

    /**
     * 예약 아이디를 사용해서 예약 삭제하는 메서드
     * @param reservationId
     * @return int
     */
    int deleteReservation(int reservationId);
}
