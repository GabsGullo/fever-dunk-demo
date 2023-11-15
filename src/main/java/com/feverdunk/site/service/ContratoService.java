package com.feverdunk.site.service;

import com.feverdunk.site.models.compositeIDs.ContratoId;
import com.feverdunk.site.exceptions.ObjectNotFoundException;
import com.feverdunk.site.models.Contrato;
import com.feverdunk.site.repository.ContratoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public List<Contrato> getContrato() {
        return contratoRepository.findAll();
    }

    public Contrato findById(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);

        return contrato.orElseThrow(() -> new ObjectNotFoundException("Contrato com id: {" + id + "} não foi encontrado"));
    }

    public Contrato create(Contrato contrato) {
        contrato.setId(null);

        return contratoRepository.save(contrato);
    }

    public Contrato update(Contrato contratoNovo) {
        Contrato contrato = findById(contratoNovo.getId());

        contrato.setTime(contratoNovo.getTime());
        contrato.setJogador(contratoNovo.getJogador());
        contrato.setAdquiridoEm(contratoNovo.getAdquiridoEm());
        contrato.setVendidoEm(contratoNovo.getVendidoEm());

        return contratoRepository.save(contrato);
    }

    public void delete(Long id) {
        Contrato contrato = findById(id);
        LocalDateTime data = LocalDateTime.now();
        contrato.setVendidoEm(data);
    }
}
