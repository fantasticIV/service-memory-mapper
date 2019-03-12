package org.mapper.memory.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mapper.memory.entity.Subscribed;
import org.mapper.memory.entity.Topics;
import org.mapper.memory.repository.SubscribedRepo;
import org.mapper.memory.repository.TopicRepo;
import org.mapper.memory.repository.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private SubscribedRepo subscribedRepo;

    public TopicService(UserRepo userRepo, TopicRepo topicRepo, SubscribedRepo subscribedRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.subscribedRepo = subscribedRepo;
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
}
