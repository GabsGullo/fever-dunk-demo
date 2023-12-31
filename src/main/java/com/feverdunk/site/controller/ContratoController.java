package com.feverdunk.site.controller;

import com.feverdunk.site.models.compositeIDs.ContratoId;
import com.feverdunk.site.exceptions.ObjectNotFoundException;
import com.feverdunk.site.models.Contrato;
import com.feverdunk.site.service.ContratoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Data
@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoService contratoService;

    @GetMapping
    public List<Contrato> getContrato(){
        return contratoService.getContrato();
    }

    @GetMapping("/{id}")
    public Contrato getContratoById(@PathVariable Long id){
        return contratoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Contrato> post(@RequestBody @Validated Contrato contrato){
        return criarContrato(contrato);
    }

    @PutMapping
    public ResponseEntity<Contrato> put(@RequestBody @Validated Contrato contrato){
        try{
            getContratoById(contrato.getId());

            Contrato contratoAtualizado = contratoService.update(contrato);
            return ResponseEntity.ok(contratoAtualizado);
        }catch (ObjectNotFoundException e){

            return criarContrato(contrato);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contrato> delete(@PathVariable Long id){
        contratoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Contrato> criarContrato(Contrato contrato) {
        Contrato contratoCriada = contratoService.create(contrato);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("{/id}").buildAndExpand(contratoCriada.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
