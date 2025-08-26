package com.gestaofinanceirapessoal.repositories;

import com.gestaofinanceirapessoal.domains.Transacao;
import com.gestaofinanceirapessoal.domains.enums.Status;
import com.gestaofinanceirapessoal.domains.enums.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByStatus(Status status);

    List<Transacao> findByTipoTransacao(TipoTransacao tipo);

    List<Transacao> findByDataVencimentoBetween(LocalDate inicio, LocalDate fim);
}
