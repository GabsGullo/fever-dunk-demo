package com.feverdunk.site.service;

import com.feverdunk.site.exceptions.ObjectNotFoundException;
import com.feverdunk.site.models.Desempenho;
import com.feverdunk.site.repository.DesempenhoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class DesempenhoService {

    private DesempenhoRepository desempenhoRepository;

    public List<Desempenho> getDesempenho() { return desempenhoRepository.findAll(); }

    public Desempenho findById(Long id){
        Optional<Desempenho> desempenho = desempenhoRepository.findById(id);

        return desempenho.orElseThrow(() -> new ObjectNotFoundException("Desempenho com id: {" + id + "} não foi encontrado"));
    }

    public Desempenho create(Desempenho desempenho){
        desempenho.setId(null);

        return desempenhoRepository.save(desempenho);
    }

    public Desempenho update(Desempenho desempenhoNovo){
        Desempenho desempenho = findById(desempenhoNovo.getId());

        desempenho.setData(desempenhoNovo.getData());
        desempenho.setPontos(desempenhoNovo.getPontos());
        desempenho.setRebotes(desempenhoNovo.getRebotes());
        desempenho.setAssistencias(desempenhoNovo.getAssistencias());
        desempenho.setMinJogados(desempenhoNovo.getMinJogados());
        desempenho.setJogador(desempenhoNovo.getJogador());

        return desempenhoRepository.save(desempenho);
    }

    public void delete(Long id) { desempenhoRepository.delete(findById(id));}

}
