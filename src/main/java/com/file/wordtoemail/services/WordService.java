package com.file.wordtoemail.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WordService {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmailWord(MultipartFile file) {
        boolean send = false;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String textMessage = "this is an example";
        String email = "labtesting000@gmail.com";
        String subject = "test";
        try {
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);
            helper.addAttachment("Invoice", file);
            mailSender.send(message);
            send = true;
            WordService.log.info("Email sent!");
        } catch (MessagingException e) {
            WordService.log.error("Hubo un error al enviar el email: {}", e);
        }
        return send;
    }
}
