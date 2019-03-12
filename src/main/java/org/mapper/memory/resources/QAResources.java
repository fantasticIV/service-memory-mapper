package org.mapper.memory.resources;

import org.mapper.memory.dto.MappingDTO;
import org.mapper.memory.dto.QADTO;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.entity.UserAndQAMapping;
import org.mapper.memory.service.QAService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/smart/{qId}"})
public class QAResources {

    private QAService qaService;

    public QAResources(QAService qaService) {
        this.qaService = qaService;
    }

    @GetMapping("/currentQuestion")
    private Mono<QAEntity> getCurrentQuestion(@PathVariable String qId) {
        return qaService.getCurrentQuestion(qId);
    }

    @GetMapping("/nextQuestion")
    private Mono<QAEntity> getNextQuestion(@PathVariable String qId) {
        return qaService.getNextQuestion(qId);
    }

    @GetMapping("/previousQuestion")
    private Mono<QAEntity> getPreviousQuestion(@PathVariable String qId) {
        return qaService.getPreviousQuestion(qId);
    }

    @PutMapping
    public Mono<QAEntity> addQuestion(@RequestBody QADTO QADTO) {
        return qaService.createQA(QADTO);


    }

    @PostMapping("/remember")
    public UserAndQAMapping remember(@RequestBody MappingDTO mappingDTO) {
        return qaService.updateMapping(Long.parseUnsignedLong(mappingDTO.getqId()));
    }


}
