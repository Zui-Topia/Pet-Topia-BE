//package com.zuitopia.petopia.user;
//
//import com.zuitopia.petopia.security.service.TokenService;
//import com.zuitopia.petopia.security.UserClaimDTO;
//import com.zuitopia.petopia.user.dto.SignUpRequestDTO;
//import com.zuitopia.petopia.user.service.UserService;
//import lombok.extern.log4j.Log4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:**/*-context.xml")
//@Log4j
//public class UserServiceTests {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Test
//    public void testUserService(){
//        SignUpRequestDTO userRequestDTO = new SignUpRequestDTO();
//        userRequestDTO.setUserEmail("1234@gmail.com");
//        userRequestDTO.setPassword("1234");
//        try{
//            String token = userService.signUpUser(userRequestDTO);
//            log.info(token);
//
//            UserClaimDTO userClaimDTO = tokenService.getClaims(token);
//            log.info(userClaimDTO.getUserId());
//        }
//        catch (Exception e){
//            log.error(e.getMessage());
//        }
//
//    }
//}
