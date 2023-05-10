package com.kbstar.marker;

import com.kbstar.dto.Marker;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    MarkerService service;
    @Test
    void contextLoads() {
        try {
            service.modify(new Marker(109, "빵2","http://www.naver.com",36.90,132.9,"im.jpg","S"));
            service.get();
        } catch (Exception e) {
            log.info("오류");
        }

    }

}
