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
    private int userId; // 유저 아이디
    private String password; // 유저 비밀번호
    private String userAccessToken; // 유저 엑세스 토큰
}
