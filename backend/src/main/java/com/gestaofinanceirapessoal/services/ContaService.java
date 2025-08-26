package com.gestaofinanceirapessoal.services;

import com.gestaofinanceirapessoal.domains.Conta;
import com.gestaofinanceirapessoal.domains.dtos.ContaDTO;
import com.gestaofinanceirapessoal.repositories.ContaRepository;
import com.gestaofinanceirapessoal.services.exceptions.DataIntegrityViolationException;
import com.gestaofinanceirapessoal.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepo;

    public List<ContaDTO> findAll() {
        return contaRepo.findAll().stream()
                .map(ContaDTO::new)
                .collect(Collectors.toList());
    }

    public Conta findById(Long id) {
        return contaRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada! Id: " + id));
    }

    public Conta create(ContaDTO dto) {
        dto.setId(null);
        Conta obj = new Conta(dto);
        return contaRepo.save(obj);
    }

    public Conta update(Long id, ContaDTO dto) {
        dto.setId(id);
        Conta oldObj = findById(id);
        oldObj = new Conta(dto);
        return contaRepo.save(oldObj);
    }

    public void delete(Long id) {
        Conta obj = findById(id);
        if (!obj.getTransacoes().isEmpty()) {
            throw new DataIntegrityViolationException("Conta não pode ser deletada pois possui transações vinculadas!");
        }
        contaRepo.deleteById(id);
    }


}
