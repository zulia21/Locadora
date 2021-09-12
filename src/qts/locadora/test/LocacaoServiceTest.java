package qts.locadora.test;


import qts.locadora.Cliente;
import qts.locadora.Jogo;
import qts.locadora.Locacao;
import qts.locadora.service.LocacaoService;
import qts.exception.JogoSemEstoqueException;
import qts.locadora.util.DataUtil;

import java.util.Date;
import java.util.zip.DataFormatException;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Test
    public void alugarJogo() throws Exception {

        Cliente cliente = new Cliente("Antonio");
        Jogo jogo = new Jogo("Harry Potter", 15.00, 1);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;

        locacao = locacaoService.alugarJogo(cliente, jogo);

        assertEquals(locacao.getJogo().getNome(), jogo.getNome());
        assertEquals(locacao.getCliente().getNome(), cliente.getNome());
        assertEquals("Erro no valor do jogo", locacao.getValor(), jogo.getValor(), 0.0);

    }

    @Test(expected = JogoSemEstoqueException.class)
    public void testeSemEstoque() throws Exception {

        Cliente cliente = new Cliente("Antônio");
        Jogo jogo = new Jogo("Harry Potter", 15.00, 0);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;
        locacao = locacaoService.alugarJogo(cliente, jogo);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testeValorZero() throws Exception {

        Cliente cliente = new Cliente("Antônio");
        Jogo jogo = new Jogo("Harry Potter", 0.00, 1);

        LocacaoService locacaoService = new LocacaoService();
        Locacao locacao;
        locacao = locacaoService.alugarJogo(cliente, jogo);
    }

}



