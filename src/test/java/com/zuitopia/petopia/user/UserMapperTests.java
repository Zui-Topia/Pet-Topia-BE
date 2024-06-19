package com.zuitopia.petopia.user;

import static org.junit.Assert.assertEquals;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zuitopia.petopia.user.mapper.UserMapper;


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
}


