package com.sanyogeeta.qasession.repository;

import com.sanyogeeta.qasession.model.QASession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QASessionRepository extends JpaRepository<QASession, Long> {
}
