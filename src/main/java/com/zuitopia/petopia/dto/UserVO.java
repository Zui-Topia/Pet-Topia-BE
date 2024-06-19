package com.zuitopia.petopia.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserVO {

    private int userId;
    private String password;
    private String userEmail;
    private String userAccessToken;
    private Date joinDate;
    private int joinMethod; //가입 방법
    private int petId;
    private String petName;
    private int petWeight;
    private int petSize;
    private int userId;

}
