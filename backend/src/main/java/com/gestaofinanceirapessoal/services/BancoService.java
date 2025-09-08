package com.gestaofinanceirapessoal.services;

import com.gestaofinanceirapessoal.domains.Banco;
import com.gestaofinanceirapessoal.domains.dtos.BancoDTO;
import com.gestaofinanceirapessoal.repositories.BancoRepository;
import com.gestaofinanceirapessoal.repositories.ContaRepository;
import com.gestaofinanceirapessoal.services.exceptions.DataIntegrityViolationException;
import com.gestaofinanceirapessoal.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private ContaRepository contaRepo;

    public List<BancoDTO> findAll() {
        return bancoRepo.findAll().stream()
                .map(BancoDTO::new)
                .collect(Collectors.toList());
    }

    public Banco findById(Long id) {
        return bancoRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Banco não encontrado! Id: " + id));
    }

    public Banco create(BancoDTO dto) {
        dto.setId(null);
        validaCnpj(dto);
        Banco obj = new Banco(dto);

        if (dto.getContasIds() != null && !dto.getContasIds().isEmpty()) {
            obj.setContas(dto.getContasIds().stream()
                    .map(id -> contaRepo.findById(id)
                            .orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada! Id: " + id)))
                    .collect(Collectors.toList()));
        }

        return bancoRepo.save(obj);
    }

    public Banco update(Long bancoId, BancoDTO dto) {
        dto.setId(bancoId);
        Banco oldObj = findById(bancoId);
        validaCnpj(dto);
        oldObj = new Banco(dto);

        if (dto.getContasIds() != null && !dto.getContasIds().isEmpty()) {
            oldObj.setContas(dto.getContasIds().stream()
                    .map(id -> contaRepo.findById(id)
                            .orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada! Id: " + id)))
                    .collect(Collectors.toList()));
        }

        return bancoRepo.save(oldObj);
    }

    public void delete(Long id) {
        Banco obj = findById(id);
        if (!obj.getContas().isEmpty()) {
            throw new DataIntegrityViolationException("Banco não pode ser deletado pois possui contas vinculadas!");
        }
        bancoRepo.deleteById(id);
    }

    private void validaCnpj(BancoDTO dto) {
        Optional<Banco> obj = bancoRepo.findByCnpj(dto.getCnpj());
        if (obj.isPresent() && !obj.get().getId().equals(dto.getId())) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado!");
        }
    }
}
