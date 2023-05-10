package com.kbstar;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class LombokTest {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Test
    void contextLoad() {
        Random r = new Random();
        int num = r.nextInt(100)+1;
//        ItemDTO cust = new ItemDTO("id01", "pwd01", "이말숙");
//        logger.info(cust.toString());
    }
}
