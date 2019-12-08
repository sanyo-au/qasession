package com.sanyogeeta.qasession.controller;

import com.sanyogeeta.qasession.exception.ResourceNotFoundException;
import com.sanyogeeta.qasession.model.Answer;
import com.sanyogeeta.qasession.repository.AnswerRepository;
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
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/question/{questionId}/answer")
    public Answer postAnswer(
        @PathVariable long questionId,
        @Valid @RequestBody Answer answer) {
        return questionRepository.findById(questionId)
            .map(question -> {
                answer.setQuestion(question);
                return answerRepository.save(answer);
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }
}
