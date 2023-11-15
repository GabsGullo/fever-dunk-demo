package com.feverdunk.site.models.compositeIDs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Embeddable
public class ParticipacaoId implements Serializable {

    @Field("participacao_id_liga")
    private Long ligaId;

    @Field("participacao_id_time")
    private Long timeId;

}
