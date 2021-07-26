package com.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@EnableAsync    //开启异步注解功能
@EnableScheduling   //开启基于注解的定时任务
@SpringBootApplication
public class Springboot10AsyncApplication {



    public static void main(String[] args) {
        SpringApplication.run(Springboot10AsyncApplication.class, args);
    }

}
