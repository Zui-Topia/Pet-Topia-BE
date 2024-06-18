package com.zuitopia.petopia.mypage;

import static org.junit.Assert.assertEquals;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.dto.SampleVO;
import com.zuitopia.petopia.mypage.mapper.MyReservationMapper;
import java.util.List;
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
public class MyReservationMapperTests {
    @Autowired
    private MyReservationMapper myReservationMapper;

    @Test
    public void testGetReservationVO() {
        try {
            ReservationVO reservationVO = myReservationMapper.getReservationVO(2l);
            assertEquals("123456", reservationVO.getReservationToken());
        }
        catch (Exception e) {
            log.error("message : " + e.getMessage());
            log.error(e.getStackTrace());
        }
    }
}
