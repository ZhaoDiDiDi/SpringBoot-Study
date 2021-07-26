package com.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10AsyncApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //简单邮件发送
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("测试");
        mailMessage.setText("Hello Word");

        mailMessage.setTo("739333160@qq.com");
        mailMessage.setFrom("739333160@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void cotextLoads2() throws MessagingException {

        //复杂邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("测试");
        helper.setText("<p style='color:red'>Hello Word</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("E:\\javaproject\\springboot\\springboot-10-async\\src\\main\\resources\\static\\1.jpg"));

        helper.setTo("739333160@qq.com");
        helper.setFrom("739333160@qq.com");

        mailSender.send(mimeMessage);
    }
}
