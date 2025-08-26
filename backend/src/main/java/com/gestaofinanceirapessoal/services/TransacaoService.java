package com.gestaofinanceirapessoal.services;

import com.gestaofinanceirapessoal.domains.Transacao;
import com.gestaofinanceirapessoal.domains.dtos.TransacaoDTO;
import com.gestaofinanceirapessoal.repositories.TransacaoRepository;
import com.gestaofinanceirapessoal.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepo;

    public List<TransacaoDTO> findAll() {
        return transacaoRepo.findAll().stream()
                .map(TransacaoDTO::new)
                .collect(Collectors.toList());
    }

    public Transacao findById(Long id) {
        return transacaoRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Transação não encontrada! Id: " + id));
    }

    public Transacao create(TransacaoDTO dto) {
        dto.setId(null);
        Transacao obj = new Transacao(dto);
        return transacaoRepo.save(obj);
    }

    public Transacao update(Long id, TransacaoDTO dto) {
        dto.setId(id);
        Transacao oldObj = findById(id);
        oldObj = new Transacao(dto);
        return transacaoRepo.save(oldObj);
    }

    public void delete(Long id) {
        Transacao obj = findById(id);
        transacaoRepo.deleteById(id);
    }
}
