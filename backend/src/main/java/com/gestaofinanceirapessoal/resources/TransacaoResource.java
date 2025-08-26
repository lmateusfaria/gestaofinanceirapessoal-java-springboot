package com.gestaofinanceirapessoal.resources;

import com.gestaofinanceirapessoal.domains.Transacao;
import com.gestaofinanceirapessoal.domains.dtos.TransacaoDTO;
import com.gestaofinanceirapessoal.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoResource {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> findAll() {
        return ResponseEntity.ok().body(transacaoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransacaoDTO> findById(@PathVariable Long id) {
        Transacao obj = transacaoService.findById(id);
        return ResponseEntity.ok().body(new TransacaoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody TransacaoDTO objDto) {
        Transacao transacao = transacaoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransacaoDTO> update(@PathVariable Long id, @Valid @RequestBody TransacaoDTO objDto) {
        Transacao obj = transacaoService.update(id, objDto);
        return ResponseEntity.ok().body(new TransacaoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
