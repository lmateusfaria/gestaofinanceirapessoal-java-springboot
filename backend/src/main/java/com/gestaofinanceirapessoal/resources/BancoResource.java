package com.gestaofinanceirapessoal.resources;

import com.gestaofinanceirapessoal.domains.Banco;
import com.gestaofinanceirapessoal.domains.dtos.BancoDTO;
import com.gestaofinanceirapessoal.services.BancoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/bancos")
public class BancoResource {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoDTO>> findAll() {
        return ResponseEntity.ok().body(bancoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoDTO> findById(@PathVariable Long id) {
        Banco obj = bancoService.findById(id);
        return ResponseEntity.ok().body(new BancoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody BancoDTO objDto) {
        Banco banco = bancoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(banco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BancoDTO> update(@PathVariable Long id, @Valid @RequestBody BancoDTO objDto) {
        Banco obj = bancoService.update(id, objDto);
        return ResponseEntity.ok().body(new BancoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bancoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
