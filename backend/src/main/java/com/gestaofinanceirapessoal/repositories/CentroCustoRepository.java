package com.gestaofinanceirapessoal.repositories;

import com.gestaofinanceirapessoal.domains.CentroCusto;
import com.gestaofinanceirapessoal.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCusto, Long> {

    List<CentroCusto> findByUsuario(Usuario usuario);
}
