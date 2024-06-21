package com.zuitopia.petopia.reservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.mapper.ReservationMapper;
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
public class  ReservationMapperTests {
    @Autowired
    private ReservationMapper mapper;

    @Test
    public void testInsert() {
        try {
            ReservationVO reservationVO = ReservationVO.builder()
                            .userId(1)
                            .branchId(4)
                            .reservationToken("3333")
                            .reservationVisitTime("11:30 AM")
                            .reservationDate("2024-06-12")
                            .build();

            log.info(reservationVO.toString());
            mapper.insert(reservationVO);
        } catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }

//    @Test
//    public void testGetCurrentInfo() {
//        try {
//            ReservationVO reservationVO = ReservationVO.builder()
//                    .userId(1)
//                    .branchId(4)
//                    .reservationToken("3333")
//                    .reservationVisitTime("11:30 AM")
//                    .reservationDate("2024-06-12")
//                    .build();
//
//
//            log.info("insert: !!!!!!!!!!" + reservationVO.toString());
//
//            log.info(mapper.getCurrentInfo(reservationVO).toString());
//        } catch (Exception e) {
//            log.info("message : " + e.getMessage());
//            log.info(e.getStackTrace());
//        }
//    }

    @Test
    public void testGet1() {
        try {
            ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO();
            reservationConfirmVO.setBranchId(1);
            reservationConfirmVO.setReservationDate("2024-06-20");

            int petStrollerCnt = mapper.getStrollerCount(reservationConfirmVO);

            assertEquals(18, petStrollerCnt);
        } catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }

    @Test
    public void testGet2() {
        try {
            ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO();
            reservationConfirmVO.setBranchId(3);
            reservationConfirmVO.setReservationDate("2024-06-20");

            Integer petStrollerCnt = mapper.getStrollerCount(reservationConfirmVO);

            assertNull(petStrollerCnt);
        } catch (Exception e) {
            log.info("message : " + e.getMessage());
            log.info(e.getStackTrace());
        }
    }
}
