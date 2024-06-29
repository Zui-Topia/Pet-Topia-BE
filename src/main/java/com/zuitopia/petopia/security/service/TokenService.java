package com.zuitopia.petopia.security.service;

import com.zuitopia.petopia.security.UserClaimDTO;

/**
 * TokenService 토큰 관련 클래스
 * @apiNote AccessToken 생성 및 추출
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
public interface TokenService {
    /**
     * AccessToken 생성하는 메소드
     * @param dto
     * @return String
     */
    String generateToken(UserClaimDTO dto);

    /**
     * AccessToken 에서 userId를 추출하는 메소드
     * @param token
     * @return UserClaimDTO
     * @throws NullPointerException 토큰 오류
     */
    UserClaimDTO getClaims(String token) throws NullPointerException;
}