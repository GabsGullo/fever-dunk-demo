package com.feverdunk.site.repository;

import com.feverdunk.site.models.compositeIDs.ContratoId;
import com.feverdunk.site.models.Contrato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends MongoRepository<Contrato, Long> {

}
