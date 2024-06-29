package com.zuitopia.petopia.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * UserClaimDTO 클래스
 * @apiNote 사용자 AccessToken 에서 인코딩에 사용되는 클래스
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
@Data
@Builder
@AllArgsConstructor
public class UserClaimDTO {
    private int userId; // 사용자 ID
}
