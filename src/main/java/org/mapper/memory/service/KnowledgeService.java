package org.mapper.memory.service;

import org.mapper.memory.dto.QuestionDTO;
import org.mapper.memory.entity.Question;
import org.mapper.memory.entity.Topic;
import org.mapper.memory.mapper.QuestionMapper;
import org.mapper.memory.repository.QuestionRepository;
import org.mapper.memory.repository.TopicRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class KnowledgeService {

    QuestionRepository questionRepository;
    TopicRepository topicRepository;

    public KnowledgeService(QuestionRepository questionRepository, TopicRepository topicRepository){
        this.questionRepository = questionRepository;
        this.topicRepository = topicRepository;
    }
    //Get First
    public Mono<Question> getFirst(){
        return questionRepository.findAll()
                .next();
    }

    public Mono<Question> getNext(Long id){
        Mono<Long> count = questionRepository.count();
        return count.map(c -> {
            Long val = (id + 1) % c;
            if(val ==0){
                val = c;
            }
            return val;
        }).flatMap(quesid -> questionRepository.findOneByQuesId(quesid));
    }

    public Mono<Question> getPrev(Long id){
        Mono<Long> count = questionRepository.count();
        return count.map(c -> {
            if(id <=1){
                return c;
            } else {
                return ((id - 1) % c);
            }
        }).flatMap(quesid -> questionRepository.findOneByQuesId(quesid));
    }

    public Mono<Question> save(QuestionDTO questionDTO){

        return Mono.just(questionDTO)
                .map(QuestionMapper::map)
                .flatMap(ques -> questionRepository.save(ques));
    }
}
