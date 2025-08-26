package com.gestaofinanceirapessoal.resources;

import com.gestaofinanceirapessoal.domains.CentroCusto;
import com.gestaofinanceirapessoal.domains.dtos.CentroCustoDTO;
import com.gestaofinanceirapessoal.services.CentroCustoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/centros-custo")
public class CentroCustoResource {

    @Autowired
    private CentroCustoService centroCustoService;

    @GetMapping
    public ResponseEntity<List<CentroCustoDTO>> findAll() {
        return ResponseEntity.ok().body(centroCustoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CentroCustoDTO> findById(@PathVariable Long id) {
        CentroCusto obj = centroCustoService.findById(id);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CentroCustoDTO objDto) {
        CentroCusto cc = centroCustoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cc.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CentroCustoDTO> update(@PathVariable Long id, @Valid @RequestBody CentroCustoDTO objDto) {
        CentroCusto obj = centroCustoService.update(id, objDto);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        centroCustoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
