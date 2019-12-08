package com.sanyogeeta.qasession.representation;

import com.sanyogeeta.qasession.model.Answer;
import com.sanyogeeta.qasession.model.Question;
import java.util.List;

public class QuestionAnswerRepresentation {

    private Question question;
    private List<Answer> answers;

    public QuestionAnswerRepresentation(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
