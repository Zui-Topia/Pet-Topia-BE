package com.zuitopia.petopia.user.mapper;


import com.zuitopia.petopia.dto.UserSecurityVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int checkEmailExists(String email);
    int getUserIdByEmail(String userEmail);
    int insertUser(SignUpRequestDTO signUpRequestDTO);
    int insertUserSecurity(UserSecurityVO userSecurityVO);
    int insertPet(SignUpRequestDTO signUpRequestDTO);
    UserVO findByEmail(String userEmail);
    UserSecurityVO getUserSecurityByUserId(int userId);
}