package org.mapper.memory.dto;

import org.mapper.memory.entity.Question;
import org.mapper.memory.entity.Topic;

public class QuestionDTO {
    private Long quesId;
    private String question;
    private String answer;
    private String topicId;

    public Long getQuesId() {
        return quesId;
    }

    public QuestionDTO setQuesId(Long quesId) {
        this.quesId = quesId;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionDTO setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public QuestionDTO setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public String getTopicId() {
        return topicId;
    }

    public QuestionDTO setTopicId(String topicId) {
        this.topicId = topicId;
        return this;
    }
}
