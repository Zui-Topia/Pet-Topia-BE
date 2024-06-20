package com.zuitopia.petopia.reservation;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class ReservationConfirmMapperTests {
    @Autowired
    private ReservationConfirmMapper mapper;

    @Test
    public void testGetCurrentInfo() {
        try {
            ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO();

            reservationConfirmVO.setBranchId(1);
            reservationConfirmVO.setReservationDate("2024-06-20");

            int count = mapper.getResrvationCnt(reservationConfirmVO);
            log.info(count);
//            assertEquals(2, count);

        }
        catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }
}
