package com.zuitopia.petopia.reservation;

<<<<<<< HEAD
=======
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import com.zuitopia.petopia.dto.PlaceVO;
import com.zuitopia.petopia.dto.ReservationConfirmVO;
>>>>>>> 7d5f9f8f49e921197c035eb9b1fb26863aa29713
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

<<<<<<< HEAD
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




=======

    @Test
    public void testGet1() {
        try {
            ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO();
            reservationConfirmVO.setBranchId(1);
            reservationConfirmVO.setReservationDate("2024-06-20");

            int petStrollerCnt = mapper.getStrollerCount(reservationConfirmVO);

            assertEquals(18, petStrollerCnt);
>>>>>>> 7d5f9f8f49e921197c035eb9b1fb26863aa29713
        }
        catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 7d5f9f8f49e921197c035eb9b1fb26863aa29713
}
