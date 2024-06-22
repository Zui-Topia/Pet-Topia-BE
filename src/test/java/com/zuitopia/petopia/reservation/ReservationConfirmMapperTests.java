package com.zuitopia.petopia.reservation;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.reservation.mapper.ReservationConfirmMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class ReservationConfirmMapperTests {
    @Autowired
    private ReservationConfirmMapper mapper;

    @Test
    public void testGetStrollerCnt() {

        ReservationConfirmVO reservationConfirmVO = ReservationConfirmVO.builder()
                .branchId(1)
                .reservationDate("2024-06-20")
                .build();


        Integer count = mapper.getStollerCount(reservationConfirmVO);

        if(count == null) {
            log.info("예약수 count : " + count);
        }

        assertNull(count);
    }

    @Test
    public void testUpdateReservationCnt() {
        ReservationConfirmVO reservationConfirmVO =  ReservationConfirmVO.builder()
                .branchId(1)
                .reservationDate("2024-06-20")
                .build();

        int check = mapper.updateStollerCount(reservationConfirmVO);
        assertEquals(1, check);
    }

    @Test
    public void testInseReservationCnt() {
        ReservationConfirmVO reservationConfirmVO = ReservationConfirmVO.builder()
                .branchId(1)
                .reservationDate("2024-06-20")
                .reservationCnt(1)
                .build();
        int check = mapper.insertStollerCount(reservationConfirmVO);
        assertEquals(1, check);
    }
}
