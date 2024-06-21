package com.zuitopia.petopia.mypage;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.mapper.QRAuthMapper;
import com.zuitopia.petopia.mypage.service.QRService;
import java.util.Date;
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
public class QRAuthServiceTests {
    @Autowired
    private QRService qrService;

    @Test
    public void testQRAuth_QR만료(){
        try{
            ReservationVO reservationVO  = qrService.authQR(11);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }

    @Test
    public void testQRAuth_예약만료(){
        try{
            ReservationVO reservationVO  = qrService.authQR(11);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }

    @Test
    public void testQRAuth_당일예약아님(){
        try{
            ReservationVO reservationVO  = qrService.authQR(15);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }

    @Test
    public void testQRAuth_성공(){
        try{
            ReservationVO reservationVO  = qrService.authQR(16);
            log.info("인증 성공");
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }


}
