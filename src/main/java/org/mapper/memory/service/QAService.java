package org.mapper.memory.service;

import org.mapper.memory.dto.QADTO;
import org.mapper.memory.engine.Utils;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.entity.UserAndQAMapping;
import org.mapper.memory.mapper.QADTOMapper;
import org.mapper.memory.repository.MappingRepository;
import org.mapper.memory.repository.QARepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QAService {

    private QARepository qaRepository;
    private MappingRepository mappingRepository;
    private MongoTemplate mongoTemplate;

    public QAService(QARepository qaRepository, MongoTemplate mongoTemplate, MappingRepository mappingRepository) {
        this.qaRepository = qaRepository;
        this.mongoTemplate = mongoTemplate;
        this.mappingRepository = mappingRepository;
    }

    public Mono<QAEntity> createQA(QADTO QADTO) {
        return Mono.just(QADTO)
                .map(QADTOMapper::getQAEntityFromQADTO)
                .flatMap(qaRepository::save);
    }


    public UserAndQAMapping updateMapping(Long qId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("qId").is(qId));
        Update update = new Update();
        update.inc("count", 1);
        return mongoTemplate.findAndModify(query, update, UserAndQAMapping.class);
    }

    private Mono<QAEntity> getQuestionByQId(Long qId) {
        return qaRepository.findById(qId);

    }

    public Mono<QAEntity> getCurrentQuestion(String qId) {
        return getQuestionByQId(Long.parseLong(qId));
    }

    public Mono<QAEntity> getNextQuestion(String qId) {

        Long aLong = Utils.next(Long.parseLong(qId));

        return getQuestionByQId(aLong);
    }


    public Mono<QAEntity> getPreviousQuestion(String qId) {
        Long aLong = Utils.previous(Long.parseLong(qId));
        return getQuestionByQId(aLong);
    }


}

