package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

/**
 * 마이페이지 화면에 보여줄 사용자정보
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22  	    최유경        		        최초 생성
 * </pre>
 */
@Data
public class MyPageUserDTO {
    private int userId;         // 사용자 ID
    private String userEmail;   // 사용자 이메일
}
