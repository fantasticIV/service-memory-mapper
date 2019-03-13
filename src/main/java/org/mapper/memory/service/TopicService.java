package org.mapper.memory.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.entity.Subscribed;
import org.mapper.memory.entity.Topics;
import org.mapper.memory.repository.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private SubscribedRepo subscribedRepo;
    private QARepository qaRepository;
    private QARepoNonReactive qaRepoNonReactive;
    private SubscribedNonReactiveRepo subscribedNonReactiveRepo;
    //TODO check for concurrent and transactional scope.
    private Long currentId;

    public TopicService(UserRepo userRepo, TopicRepo topicRepo, SubscribedRepo subscribedRepo, QARepository qaRepository, QARepoNonReactive qaRepoNonReactive, SubscribedNonReactiveRepo subscribedNonReactiveRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.subscribedRepo = subscribedRepo;
        this.qaRepository = qaRepository;
        this.qaRepoNonReactive = qaRepoNonReactive;
        this.subscribedNonReactiveRepo = subscribedNonReactiveRepo;

    }

    public Mono<Subscribed> subscribeTopics(String topics, String userId) throws JSONException {
        List<Topics> topics1 = new ArrayList<Topics>();

        JSONArray jsonArr = new JSONArray(topics);

        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonTopic = jsonArr.getJSONObject(i);
            String tId = jsonTopic.getString("tId");
            String tName = jsonTopic.getString("tName");
            Topics topic = new Topics();
            topic.settId(tId);
            topic.settName(tName);
            topics1.add(topic);
        }


        Subscribed subscribed = new Subscribed();
        subscribed.setTopics(topics1);
        subscribed.setUserId(userId);

        return subscribedRepo.save(subscribed);
    }

    public Mono<Topics> createTopic(Topics topics) {
        return topicRepo.save(topics);
    }

    public Mono<QAEntity> getCurrentSubscribeQA(String qId, String userId) {

        return Mono.just(getCurrentQId(Long.parseLong(qId)))
                .flatMap(t -> checkSubscription(t, userId))
                .filter(bool -> bool.booleanValue())
                .flatMap(t -> qaRepository.findById(currentId))
                .switchIfEmpty(Mono.empty());



    }

    private Mono<Boolean> checkSubscription(Long qId, String userId) {
        return subscribedRepo.findById(userId)
                .map(t -> t.getTopics())
                .filter(t -> this.check(t, qId))
                .map(t -> true)
                .switchIfEmpty(Mono.just(false));
    }

    private Long getCurrentQId(Long qId) {
        boolean isExist = qaRepoNonReactive.existsById(qId);
        if (isExist) {
            return qId;
        } else {
            return getCurrentQId(qId + 1);
        }

    }


    private boolean check(List<Topics> t, Long qId) {
        QAEntity qaEntity = qaRepoNonReactive.findById(qId).get();
        for (Topics topics : t) {
            if (topics.gettId().equals(qaEntity.gettId())) {
                currentId = qId;
                return true;
            }
        }
        return false;

    }

}
