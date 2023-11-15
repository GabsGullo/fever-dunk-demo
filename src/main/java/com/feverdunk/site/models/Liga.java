package com.feverdunk.site.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "ligas")
@Data
public class Liga {

    @Id
    private Long id;

    @Field("descricao")
    @NotBlank
    private String descricao;

    @Field("liga_senha")
    @NotBlank
    private String senha;

    private List<Participacao> participacao;
}
