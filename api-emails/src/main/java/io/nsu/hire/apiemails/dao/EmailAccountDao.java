package io.nsu.hire.apiemails.dao;

import io.nsu.hire.apiemails.model.EmailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAccountDao extends JpaRepository<EmailAccount, Long> {
}

