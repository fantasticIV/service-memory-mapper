package org.mapper.memory.mapper;

import org.mapper.memory.dto.QuestionDTO;
import org.mapper.memory.entity.Question;
import org.mapper.memory.entity.Topic;

public class QuestionMapper {

    public static Question map(QuestionDTO questionDTO){
        return new Question()
                .setQuesId(questionDTO.getQuesId())
                .setQuestion(questionDTO.getQuestion())
                .setAnswer(questionDTO.getAnswer());
    }
}
