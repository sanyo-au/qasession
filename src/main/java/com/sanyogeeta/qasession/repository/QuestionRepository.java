package com.sanyogeeta.qasession.repository;

import com.sanyogeeta.qasession.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQaSessionId(Long qaId);
}
