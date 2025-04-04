package com.origemite.gmail.bootgmailsend.controller;

import com.origemite.gmail.bootgmailsend.service.MailService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    @Value("${spring.mail.password}")
    private String appPassword;

    @GetMapping("/test1")
    public void testMail(){
        mailService.sendMail("wlazhd00@naver.com","메일 센드 테스트","test1");
    }

}
