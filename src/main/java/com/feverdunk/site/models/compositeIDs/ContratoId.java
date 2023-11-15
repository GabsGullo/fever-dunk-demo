package com.feverdunk.site.models.compositeIDs;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ContratoId implements Serializable {
    
    private Long jogadorId;
    
    private Long timeId;
}
