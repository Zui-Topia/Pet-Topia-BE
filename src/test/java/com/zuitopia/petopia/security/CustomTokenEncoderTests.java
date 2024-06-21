package com.zuitopia.petopia.security;

import static org.junit.Assert.assertEquals;

import com.zuitopia.petopia.security.service.CustomTokenEncoder;
import java.util.HashMap;
import java.util.Map;
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
public class CustomTokenEncoderTests {
    @Autowired
    private CustomTokenEncoder customTokenEncoder;

    @Test
    public void testTokenMatch(){
        Map<String, Object> m = new HashMap<>();
        m.put("userId", Integer.valueOf(1));

        String token = customTokenEncoder.createAccessToken(m);
        log.info(token);

        Map<String, Object> result =  customTokenEncoder.extractClaims(token);
        log.info(result);
//        assertEquals(Integer.valueOf(1), (Integer)result.get("userId"));
    }
}
