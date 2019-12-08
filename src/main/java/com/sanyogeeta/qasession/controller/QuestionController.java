package com.sanyogeeta.qasession.controller;

import com.sanyogeeta.qasession.exception.ResourceNotFoundException;
import com.sanyogeeta.qasession.model.Question;
import com.sanyogeeta.qasession.repository.QASessionRepository;
import com.sanyogeeta.qasession.repository.QuestionRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QASessionRepository qaSessionRepository;

    @PostMapping("/qa/{qaId}/question")
    public Question postQuestion(
        @PathVariable long qaId,
        @Valid @RequestBody Question question) {
        return qaSessionRepository.findById(qaId)
            .map(qaSession -> {
                question.setQaSession(qaSession);
                return questionRepository.save(question);
            }).orElseThrow(() -> new ResourceNotFoundException("QA Session not found with id " + qaId));
    }

}
