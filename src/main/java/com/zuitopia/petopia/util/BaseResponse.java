package com.zuitopia.petopia.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * 통신에 사용하는 공통 컴포넌트
 * @author 최유경
 * @since 2024.06.18
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.18  	    최유경        		        최초 생성
 * </pre>
 */
@Getter
@Builder
@AllArgsConstructor
public class BaseResponse<T> {
    private boolean success;    // 비즈니스 로직 처리 성공 여부
    private T data;             // 반환할 데이터
}
