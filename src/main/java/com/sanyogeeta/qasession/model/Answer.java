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
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerId;

    @Column(name = "text")
    private String text;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "answered_by")
    private String answeredBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question", nullable = false)
    @JsonIgnore
    private Question question;

    public Answer(){

    }

    public Answer(String text, String imageUrl, String answeredBy) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.answeredBy = answeredBy;
    }

    public long getAnswerId() {
        return answerId;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public Question getQuestion() { return question; }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    public void setQuestion(Question question) { this.question = question; }
}
