package org.mapper.memory.entity;

import org.springframework.data.annotation.Id;

public class QAAndTopicMapping {
    @Id
    private int qId;
    private String tId;
    private String tName;
}
