package com.feverdunk.site.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "times")
@Data
public class Time {

    @Id
    private Long id;

    @Field("time_nome")
    private String nome;

    @Field("time_pontuacao")
    private int pontuacao;

    private List<Contrato> contratos;

    private List<Participacao> participacoes;
}
