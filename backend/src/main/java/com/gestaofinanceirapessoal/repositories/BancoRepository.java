package com.gestaofinanceirapessoal.repositories;

import com.gestaofinanceirapessoal.domains.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

    boolean existsByCnpj(String cnpj);
    Optional<Banco> findByCnpj(String cnpj);
}
