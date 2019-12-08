package com.sanyogeeta.qasession.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class QASessionRepresentation {
    private long qaId;

    @JsonProperty(value = "answeredQuestions")
    private List<QuestionAnswerRepresentation> answeredQuestions;
    @JsonProperty(value = "unansweredQuestions")
    private List<QuestionAnswerRepresentation> unansweredQuestions;

    public QASessionRepresentation(long qaId, List<QuestionAnswerRepresentation> answeredQuestions, List<QuestionAnswerRepresentation> unansweredQuestions) {
        this.qaId = qaId;
        this.answeredQuestions = answeredQuestions;
        this.unansweredQuestions = unansweredQuestions;
    }

    public long getQaId() {
        return qaId;
    }

    public void setQaId(long qaId) {
        this.qaId = qaId;
    }

    public List<QuestionAnswerRepresentation> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(
        List<QuestionAnswerRepresentation> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public List<QuestionAnswerRepresentation> getUnansweredQuestions() {
        return unansweredQuestions;
    }

    public void setUnansweredQuestions(
        List<QuestionAnswerRepresentation> unansweredQuestions) {
        this.unansweredQuestions = unansweredQuestions;
    }
}
