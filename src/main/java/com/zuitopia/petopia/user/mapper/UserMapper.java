package com.zuitopia.petopia.user.mapper;



import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper {

    int checkEmailExists(String userEmail);
}
