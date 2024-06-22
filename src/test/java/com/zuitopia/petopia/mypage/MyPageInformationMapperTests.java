package com.zuitopia.petopia.mypage;

import static org.junit.Assert.assertEquals;

import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import com.zuitopia.petopia.mypage.mapper.MyPageInformationMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class MyPageInformationMapperTests {
    @Autowired
    private MyPageInformationMapper myPageInformationMapper;

    @Test
    public void testGetMyPageUserDTO(){
        MyPageUserDTO myPageUserDTO = myPageInformationMapper.getMyPageUserDTO(1);
        assertEquals("zuitopia@naver.com", myPageUserDTO.getUserEmail());
    }

    @Test
    public void testGetMyPagePetDTO(){
        MyPagePetDTO myPagePetDTO = myPageInformationMapper.getMyPagePetDTO(1);
        assertEquals("Buddy", myPagePetDTO.getPetName());
    }

}
