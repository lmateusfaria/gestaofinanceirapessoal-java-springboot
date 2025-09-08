package com.gestaofinanceirapessoal.services;

import com.gestaofinanceirapessoal.domains.CentroCusto;
import com.gestaofinanceirapessoal.domains.dtos.CentroCustoDTO;
import com.gestaofinanceirapessoal.repositories.CentroCustoRepository;
import com.gestaofinanceirapessoal.repositories.UsuarioRepository;
import com.gestaofinanceirapessoal.services.exceptions.DataIntegrityViolationException;
import com.gestaofinanceirapessoal.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroCustoService {

    @Autowired
    private CentroCustoRepository centroCustoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<CentroCustoDTO> findAll() {
        return centroCustoRepo.findAll().stream()
                .map(CentroCustoDTO::new)
                .collect(Collectors.toList());
    }

    public CentroCusto findById(Long id) {
        return centroCustoRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Centro de Custo não encontrado! Id: " + id));
    }

    public CentroCusto create(CentroCustoDTO dto) {
        dto.setId(null);
        CentroCusto obj = new CentroCusto(dto);

        if (dto.getUsuarioId() != null) {
            obj.setUsuario(usuarioRepo.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + dto.getUsuarioId())));
        }

        return centroCustoRepo.save(obj);
    }

    public CentroCusto update(Long id, CentroCustoDTO dto) {
        dto.setId(id);
        CentroCusto oldObj = findById(id);
        oldObj = new CentroCusto(dto);

        if (dto.getUsuarioId() != null) {
            oldObj.setUsuario(usuarioRepo.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + dto.getUsuarioId())));
        }

        return centroCustoRepo.save(oldObj);
    }

    public void delete(Long id) {
        CentroCusto obj = findById(id);
        if (!obj.getTransacoes().isEmpty()) {
            throw new DataIntegrityViolationException("Centro de Custo não pode ser deletado pois possui transações vinculadas!");
        }
        centroCustoRepo.deleteById(id);
    }
}
