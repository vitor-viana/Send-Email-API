package com.micro_service.sendemailapi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto {

    @NotBlank
    private String owner_ref;
    @NotBlank
    @Email
    private String email_from;
    @NotBlank
    @Email
    private String email_to;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail_to() {
        return email_to;
    }

    public void setEmail_to(String email_to) {
        this.email_to = email_to;
    }

    public String getEmail_from() {
        return email_from;
    }

    public void setEmail_from(String email_from) {
        this.email_from = email_from;
    }

    public String getOwner_ref() {
        return owner_ref;
    }

    public void setOwner_ref(String owner_ref) {
        this.owner_ref = owner_ref;
    }

}
