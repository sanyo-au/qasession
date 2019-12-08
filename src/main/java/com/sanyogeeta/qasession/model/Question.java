package com.sanyogeeta.qasession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "asked_by")
    private String askedBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "qa_id", nullable = false)
    @JsonIgnore
    private QASession qaSession;

    public Question() {
    }

    public Question(String text, String askedBy) {
        this.text = text;
        this.askedBy = askedBy;
    }

    public long getId() {
        return id;
    }

    public void setQuestionId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    public QASession getQaSession() {
        return qaSession;
    }

    public void setQaSession(QASession qaSession) {
        this.qaSession = qaSession;
    }
}
