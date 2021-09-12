package qts.locadora.service;

import java.util.Date;
import qts.locadora.Cliente;
import qts.locadora.Jogo;
import qts.locadora.Locacao;
import qts.locadora.util.DataUtil;

public class LocacaoService {
	
		private final int diasPadrao = 5;
		public int testePublic;
		int testDefault;
		
		public Locacao alugarJogo(Cliente cliente, Jogo jogo) throws Exception
		{
			if (jogo.getValor() == 0)
			{
				
				throw new IllegalArgumentException("valor � zero");
				
			}
			if (jogo.getQtsestoque() == 0)
			{
				throw new qts.exception.JogoSemEstoqueException();
			}
			
			Locacao locacao =  new Locacao();
			locacao.setCliente(cliente);
			locacao.setJogo(jogo);
			locacao.setValor(jogo.getValor());
			locacao.setRetirada(new Date());
			
			Date devolucao = new DataUtil().addDias(new Date(), diasPadrao);
			locacao.setDevolucao(devolucao);
			return locacao;
			
		}
		
		
}
