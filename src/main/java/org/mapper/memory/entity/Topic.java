package org.mapper.memory.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Topic {
    @Id
    private Long topicId;
    private String topicName;

    public Long getTopicId() {
        return topicId;
    }

    public Topic setTopicId(Long topicId) {
        this.topicId = topicId;
        return this;
    }

    public String getTopicName() {
        return topicName;
    }

    public Topic setTopicName(String topicName) {
        this.topicName = topicName;
        return this;
    }
}