package com.file.wordtoemail.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import java.util.Properties;


@Configuration
public class EmailConfig {
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        /// Gmail
        mailSenderImpl.setHost("smtp.gmail.com");
        mailSenderImpl.setPort(587);

        mailSenderImpl.setUsername(System.getenv("USERMAIL"));
        mailSenderImpl.setPassword(System.getenv("PASSMAIL"));

        Properties props = mailSenderImpl.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        ///

        /// Amazon SES
        // mailSenderImpl.setHost("email-smtp.us-west-2.amazonaws.com");
        // mailSenderImpl.setPort(25);

        // mailSenderImpl.setUsername(System.getenv("USERMAIL"));
        // mailSenderImpl.setPassword(System.getenv("PASSMAIL"));

        // Properties props = mailSenderImpl.getJavaMailProperties();
        // props.put("mail.transport.protocol", "smtp");
        // props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.starttls.enable", "true");
        // props.put("mail.debug", "true");
        //

        return mailSenderImpl;
    }

}
