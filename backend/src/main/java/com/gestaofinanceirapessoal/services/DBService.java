package com.gestaofinanceirapessoal.services;

import com.gestaofinanceirapessoal.domains.*;
import com.gestaofinanceirapessoal.domains.enums.Status;
import com.gestaofinanceirapessoal.domains.enums.TipoConta;
import com.gestaofinanceirapessoal.domains.enums.TipoTransacao;
import com.gestaofinanceirapessoal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CentroCustoRepository centroCustoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB() {

        // ==========================
        // Usuários
        // ==========================
        Usuario user1 = new Usuario(null, "49257440893", "Luis Mateus",
                "lmateus@email.com", encoder.encode("123456"), LocalDate.now());

        Usuario user2 = new Usuario(null, "47076241897", "Bife Valeri",
                "felipevaleri@email.com", encoder.encode("123456"), LocalDate.now());

        usuarioRepository.save(user1);
        usuarioRepository.save(user2);

        // ==========================
        // Bancos
        // ==========================
        Banco banco1 = new Banco(null, "12345678000199", "Banco do Brasil");
        Banco banco2 = new Banco(null, "98765432000188", "Caixa Econômica");

        bancoRepository.save(banco1);
        bancoRepository.save(banco2);

        // ==========================
        // Contas
        // ==========================
        Conta conta1 = new Conta(null, TipoConta.CONTA_CORRENTE, 2000, 1500.0,
                1234, 56789, banco1, user1);
        Conta conta2 = new Conta(null, TipoConta.CONTA_POUPANCA, 0, 5000.0,
                4321, 98765, banco2, user2);

        contaRepository.save(conta1);
        contaRepository.save(conta2);

        // ==========================
        // Centro de Custo
        // ==========================
        CentroCusto cc1 = new CentroCusto(null, "Alimentação", 2000, user1);
        CentroCusto cc2 = new CentroCusto(null, "Transporte", 1000, user1);

        centroCustoRepository.save(cc1);
        centroCustoRepository.save(cc2);

        // ==========================
        // Transações
        // ==========================
        Transacao t1 = new Transacao(null, "Compra supermercado", 1.0,
                LocalDate.now(), LocalDate.now(), LocalDate.now(),
                350.0, TipoTransacao.DEBITO, Status.ABERTO, conta1, cc1);

        Transacao t2 = new Transacao(null, "Salário", 1.0,
                LocalDate.now(), LocalDate.now(), LocalDate.now(),
                3000.0, TipoTransacao.CREDITO, Status.BAIXADO, conta1, cc2);

        transacaoRepository.save(t1);
        transacaoRepository.save(t2);
    }
}
