package com.origemite.gmail.bootgmailsend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 수신자
        message.setSubject(subject); // 제목
        message.setText(text); // 본문
        message.setFrom("jangws1003@budit.ai"); // 발신자 (username과 동일)

        javaMailSender.send(message);
    }

}
