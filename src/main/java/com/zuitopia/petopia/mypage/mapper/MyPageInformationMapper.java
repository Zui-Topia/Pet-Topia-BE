package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageInformationMapper {
    MyPageUserDTO getMyPageUserDTO(int userId);
    MyPagePetDTO getMyPagePetDTO(int userId);
}
