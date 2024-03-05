package com.micro_service.sendemailapi.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.micro_service.sendemailapi.enums.StatusEmail;
import com.micro_service.sendemailapi.models.EmailModel;
import com.micro_service.sendemailapi.repositories.EmailRepository;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail (EmailModel emailModel) {
        emailModel.setSend_date_email(LocalDateTime.now());
        
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmail_from());
            message.setTo(emailModel.getEmail_to());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatus_email(StatusEmail.SENT);

        } catch (MailException e) {
            emailModel.setStatus_email(StatusEmail.ERROR);
        }
        return emailRepository.save(emailModel);

    }

    public List<EmailModel> findAll () {
        return emailRepository.findAll();
    }

}
