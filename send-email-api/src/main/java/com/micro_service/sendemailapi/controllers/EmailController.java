package com.micro_service.sendemailapi.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.micro_service.sendemailapi.dtos.EmailDto;
import com.micro_service.sendemailapi.models.EmailModel;
import com.micro_service.sendemailapi.services.EmailService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/email")
public class EmailController {
        @Autowired
        EmailService emailService;

        @PostMapping("/send")
        public ResponseEntity<EmailModel> sendEmail (@RequestBody @Valid EmailDto emailDto) {
                EmailModel emailModel = new EmailModel();
                BeanUtils.copyProperties(emailDto, emailModel);
                emailService.sendEmail(emailModel);
                
                return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
        }

        @GetMapping("/historic")
        public ResponseEntity<List<EmailModel>> findAll () {
                return ResponseEntity.ok().body(emailService.findAll());
        }
        
}
