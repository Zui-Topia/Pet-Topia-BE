package com.zuitopia.petopia.mypage.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 예약 삭제 API 통신에 사용하는 DeleteRequestDTO 클래스
 * @author 최유경
 * @since 2024.06.22
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22  	    최유경        		        최초 생성
 * </pre>
 */
@Data
@RequiredArgsConstructor
public class DeleteRequestDTO {
    private int reservationId; // 예약 ID
}
