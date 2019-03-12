package org.mapper.memory.resources;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.JSONException;
import org.mapper.memory.entity.Subscribed;
import org.mapper.memory.entity.Topics;
import org.mapper.memory.service.TopicService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/topic"})
public class QASubscribe {

    private TopicService topicService;

    public QASubscribe(TopicService topicService) {
        this.topicService = topicService;
    }

    @PutMapping("/subscribe/{userId}")
    @JsonDeserialize
    private Mono<Subscribed> subscribeToTopic(@RequestBody String topics, @PathVariable String userId) throws JSONException {

        return topicService.subscribeTopics(topics, userId);

    }

    @PutMapping("/addTopic")
    public Mono<Topics> addTopic(@RequestBody Topics topics) {
        return topicService.createTopic(topics);

    }


}
