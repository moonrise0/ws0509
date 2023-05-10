package com.kbstar.controller;

import com.kbstar.dto.MsgAdm;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;


@Slf4j
@Component
public class ScheduleController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    CartService cartService;


    @Scheduled(cron = "*/2 * * * * *")
    public void cronJobDailyUpdate() {
        Random r = new Random();
        int content1 = r.nextInt(100)+1;
        int content2 = r.nextInt(1000)+1;
        int content3 = r.nextInt(500)+1;
        int content4 = r.nextInt(10)+1;

        MsgAdm msg = new MsgAdm();
        msg.setContent1(content1);
        msg.setContent2(content2);
        msg.setContent3(content3);
        msg.setContent4(content4);
//        System.out.println("----------- Scheduler ------------");
        messagingTemplate.convertAndSend("/sendadm", msg);
    }

    @Scheduled(cron = "*/4 * * * * *")
    public void cronJobWeeklyUpdate() throws Exception {
        int count = cartService.count();
        log.info(count+"");
//      Random r = new Random();
//      int num = r.nextInt(100)+1;
//      log.info(num+"");
    }






}