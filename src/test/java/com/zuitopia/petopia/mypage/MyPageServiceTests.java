package com.zuitopia.petopia.mypage;

import com.zuitopia.petopia.mypage.service.MyPageService;
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
public class MyPageServiceTests {
    @Autowired
    private MyPageService myPageService;

    @Test
    public void testDeleteReservation(){
        try{
            myPageService.deleteMyReservation(8);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }

    }
}
