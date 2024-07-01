package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 마이페이지 유저 정보 Mapper interface
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Mapper
public interface MyPageInformationMapper {

    /**
     * 유저 정보를 조회하는 메서드
     * @param userId
     * @return MyPageUserDTO
     */
    MyPageUserDTO getMyPageUserDTO(int userId);

    /**
     * 펫 정보를 조회하는 메서드
     * @param userId
     * @return MyPagePetDTO
     */
    MyPagePetDTO getMyPagePetDTO(int userId);
}
