package com.zuitopia.petopia.user;

import com.zuitopia.petopia.user.dto.SignUpRequestDTO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zuitopia.petopia.dto.UserVO;
//import com.zuitopia.petopia.user.dto.UserRequestDTO;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class UserMapperTests {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void testCheckEmailExists() {

        // Given
        String existingEmail = "existing@example.com";

        // When
        int existingEmailCount = userMapper.checkEmailExists(existingEmail);

        // Then
        assertEquals("The email should exist in the database", 0, existingEmailCount);
    }

    @Test
    public void testLogin() {
        UserVO user = userMapper.findByEmail("petopia@gmail.com");
        assertEquals("petopia@gmail.com", user.getUserEmail());
    }

    @Test
    public void testInsertUser() {
        // Create a UserVO instance with dummy data
        SignUpRequestDTO userRequestDTO = new SignUpRequestDTO();
        userRequestDTO.setUserEmail("ddddd@gmail.com");

        // Insert user into the database
        int userId = userMapper.insertUser(userRequestDTO);

        assertEquals(5, userId);
    }
}


