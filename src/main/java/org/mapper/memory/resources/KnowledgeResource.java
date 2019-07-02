package org.mapper.memory.resources;

import org.mapper.memory.dto.QuestionDTO;
import org.mapper.memory.entity.Question;
import org.mapper.memory.service.KnowledgeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/smart"})
public class KnowledgeResource {

    KnowledgeService service;

    public KnowledgeResource(KnowledgeService knowledgeService){
        this.service = knowledgeService;
    }

    @GetMapping("/questions/first")
    public Mono<Question> getCurrentQuestion() {
        return service.getFirst();
    }

    @GetMapping("/questions/{currid}/next")
    public Mono<Question> getNextQuestion(@PathVariable Long currid) {
        return service.getNext(currid);
    }

    @GetMapping("/questions/{currid}/prev")
    public Mono<Question> getPrevQuestion(@PathVariable Long currid) {
        return service.getPrev(currid);
    }

    @PostMapping("/question")
    public Mono<Question> create(@RequestBody QuestionDTO questionDTO){
        return service.save(questionDTO);
    }


}
