package com.micro_service.sendemailapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro_service.sendemailapi.models.EmailModel;;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
