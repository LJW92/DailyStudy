package com.jiawei.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled()
    public void hello(){
        System.out.println("hello,ni bei zhixing le ~");
    }


}
