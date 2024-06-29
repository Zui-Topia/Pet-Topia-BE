package com.zuitopia.petopia.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 유저 보안 정보를 담은 UserSecurityVO
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
public class UserSecurityVO {
    private int userId;             // 사용자 고유 ID
    private String password;        // 사용자 비밀번호
    private String userAccessToken; // 사용자 엑세스 토큰
}
