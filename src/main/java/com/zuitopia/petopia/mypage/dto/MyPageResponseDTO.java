package com.zuitopia.petopia.mypage.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 마이페이지 화면에 보여줄 데이터 클래스
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Data
@Builder
public class MyPageResponseDTO {
    private MyPageUserDTO myPageUserDTO;        // 사용자 정보
    private MyPagePetDTO myPagePetDTO;          // 반려견 정보
    private MyReservationDTO myReservationDTO;  // 나의 예약 정보 1건
}
