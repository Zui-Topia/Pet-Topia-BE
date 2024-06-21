package com.zuitopia.petopia.user.mapper;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.SingUpRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int checkEmailExists(String userEmail);
    void insertUser(SingUpRequestDTO singUpRequestDTO);

    void insertPet(PetVO petVO);


    UserVO findByEmail( String userEmail);

}


