package org.mapper.memory.mapper;

import org.mapper.memory.dto.QADTO;
import org.mapper.memory.entity.QAEntity;

public final class QADTOMapper {
    private QADTOMapper() {
    }

    public static QAEntity getQAEntityFromQADTO(QADTO QADTO) {
        QAEntity qaEntity = new QAEntity();
        qaEntity.setQuestion(QADTO.getQuestion());
        qaEntity.setAnswer(QADTO.getAnswer());
        qaEntity.setqId(QADTO.getqId());
        qaEntity.settId(QADTO.gettId());
        return qaEntity;
    }

}
