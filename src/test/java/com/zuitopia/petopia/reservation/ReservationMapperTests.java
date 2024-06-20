package com.zuitopia.petopia.reservation;

import com.zuitopia.petopia.reservation.mapper.ReservationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zuitopia.petopia.dto.ReservationVO;


import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class ReservationMapperTests {
    @Autowired
    private ReservationMapper mapper;

    @Test
    public void testInsert() {
        try {
            ReservationVO reservationVO = new ReservationVO();



            reservationVO.setUserId(1);
            reservationVO.setBranchId(4);
            reservationVO.setReservationToken("3333");
            reservationVO.setReservationVisitTime("11 : 30 AM");

            reservationVO.setReservationDate("2024-06-12");
            log.info(reservationVO.toString());
            mapper.insert(reservationVO);


        }
        catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }

    @Test
    public void testGetCurrentInfo() {
        try {
            ReservationVO reservationVO = new ReservationVO();



            reservationVO.setUserId(1);
            reservationVO.setBranchId(4);
            reservationVO.setReservationVisitTime("11 : 30 AM");

            reservationVO.setReservationDate("2024-06-12");
            log.info("insert: !!!!!!!!!!" + reservationVO.toString());

            log.info(mapper.getCurrentInfo(reservationVO).toString());




        }
        catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }

}
