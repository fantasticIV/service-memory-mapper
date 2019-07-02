package org.mapper.memory.entity;

import org.springframework.data.annotation.Id;

public class Question {
    @Id
    private Long quesId;
    private String question;
    private String answer;
    private Topic topic;

    public Long getQuesId() {
        return quesId;
    }

    public Question setQuesId(Long quesId) {
        this.quesId = quesId;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Topic getTopic() {
        return topic;
    }

    public Question setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }
}
