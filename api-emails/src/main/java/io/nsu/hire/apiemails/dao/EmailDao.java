package io.nsu.hire.apiemails.dao;

import io.nsu.hire.apiemails.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Long> {

}