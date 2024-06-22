package com.zuitopia.petopia.mypage;

import com.zuitopia.petopia.dto.ReservationQRVO;
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
public class QRAuthMapperTests {
    @Autowired
    private QRAuthMapper authMapper;

    @Test
    public void testCreateQR(){
        try{
//            ReservationQRVO reservationQRVO = ReservationQRVO.builder()
//                    .reservationId(2)
//                    .qrExpireTime(new Date(new Date().getTime() + 30))
//                    .build();
            int qrValue = authMapper.createQR(2);
            log.info(qrValue);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }


}
