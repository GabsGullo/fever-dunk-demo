package com.feverdunk.site.repository;

import com.feverdunk.site.models.Liga;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigaRepository extends MongoRepository<Liga, Long> {

    public List<Liga> findAllByParticipacao_Time_id(Long id);
}
