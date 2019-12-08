package com.sanyogeeta.qasession.controller;

import com.sanyogeeta.qasession.model.QASession;
import com.sanyogeeta.qasession.repository.AnswerRepository;
import com.sanyogeeta.qasession.repository.QASessionRepository;
import com.sanyogeeta.qasession.repository.QuestionRepository;
import com.sanyogeeta.qasession.representation.QASessionRepresentation;
import com.sanyogeeta.qasession.representation.QuestionAnswerRepresentation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QASessionController {

    @Autowired
    private QASessionRepository qaSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping("/qa")
    public QASession addQASession(@Valid @RequestBody QASession qaSession) {
        return qaSessionRepository.save(qaSession);
    }

    @GetMapping("/qa/{qaId}")
    public Optional<QASession> getQASession(@PathVariable Long qaId) {
        return qaSessionRepository.findById(qaId);
    }

    @GetMapping("/qa/{qaId}/questions")
    public QASessionRepresentation getAllQuestions(@PathVariable Long qaId) {

        List<QuestionAnswerRepresentation> answeredQuestions = questionRepository.findByQaSessionId(qaId)
            .stream()
            .filter(question -> answerRepository.findByQuestionId(question.getId()).size() > 0)
            .map(question ->
                new QuestionAnswerRepresentation(question, answerRepository.findByQuestionId(question.getId())))
            .collect(Collectors.toList());

        List<QuestionAnswerRepresentation> unansweredQuestions = questionRepository.findByQaSessionId(qaId)
            .stream()
            .filter(question -> answerRepository.findByQuestionId(question.getId()).size() == 0)
            .map(question ->
                new QuestionAnswerRepresentation(question, answerRepository.findByQuestionId(question.getId())))
            .collect(Collectors.toList());
        return new QASessionRepresentation(qaId, answeredQuestions, unansweredQuestions);
    }


}
