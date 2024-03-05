package com.micro_service.sendemailapi.models;

import java.time.LocalDateTime;

import com.micro_service.sendemailapi.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="email")
public class EmailModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="email_email_id_seq")
    @SequenceGenerator(name="email_email_id_seq", sequenceName="email_email_id_seq", allocationSize=1)
    private Long email_id;
    private String owner_ref;
    private String email_from;
    private String email_to;
    private LocalDateTime send_date_email;
    private String subject;
    @Column(columnDefinition="TEXT")
    private String text;
    private StatusEmail status_email;

    public StatusEmail getStatus_email() {
        return status_email;
    }

    public void setStatus_email(StatusEmail status_email) {
        this.status_email = status_email;
    }

    public LocalDateTime getSend_date_email() {
        return send_date_email;
    }

    public void setSend_date_email(LocalDateTime send_date_email) {
        this.send_date_email = send_date_email;
    }

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

    public long getEmail_id() {
        return email_id;
    }

    public void setEmailId(Long email_id) {
        this.email_id = email_id;
    }

}
