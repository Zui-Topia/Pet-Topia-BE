package com.zuitopia.petopia.user.mapper;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserSecurityVO;
import com.zuitopia.petopia.dto.UserVO;
import org.apache.ibatis.annotations.Mapper;
import com.zuitopia.petopia.user.dto.UserRequestDTO;
@Mapper
public interface UserMapper {
    int checkEmailExists(String userEmail);
    int getUserIdByEmail(String userEmail);
    int insertUser(UserRequestDTO userRequestDTO);
    int insertUserSecurity(UserSecurityVO userSecurityVO);
    void insertPet(PetVO petVO);
    UserVO findByEmail(String email);

    UserSecurityVO getUserSecurityByUserId(int userId);
}
