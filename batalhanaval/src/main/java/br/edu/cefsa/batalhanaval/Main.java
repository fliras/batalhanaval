package br.edu.cefsa.batalhanaval;

import br.edu.cefsa.batalhanaval.acoes.ChecadorDeVencedorPadrao;
import br.edu.cefsa.batalhanaval.acoes.GeradorDeJogadasPadrao;
import br.edu.cefsa.batalhanaval.acoes.ExecutorDeDisparosPadrao;
import br.edu.cefsa.batalhanaval.acoes.MontadorDeEmbarcacoesPadrao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaDireita;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaEsquerda;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionadorDeEmbarcacoesPadrao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaBaixo;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaCima;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.PosicionamentosDeEmbarcacao;
import br.edu.cefsa.batalhanaval.main.MaquinaDeJogo;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ExecutorDeDisparosPadrao executorDisparos = new ExecutorDeDisparosPadrao();
        ChecadorDeVencedorPadrao checadorVencedor = new ChecadorDeVencedorPadrao();
        GeradorDeJogadasPadrao geradorJogadas = new GeradorDeJogadasPadrao();
        MontadorDeEmbarcacoesPadrao montadorEmbarcacoes = new MontadorDeEmbarcacoesPadrao();
        HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento = new HashMap<>() {{
            put(PosicionamentosDeEmbarcacao.HORIZONTAL_PARA_ESQUERDA, new PosicionamentoEmbarcacaoHorizontalParaEsquerda());
            put(PosicionamentosDeEmbarcacao.HORIZONTAL_PARA_DIREITA, new PosicionamentoEmbarcacaoHorizontalParaDireita());
            put(PosicionamentosDeEmbarcacao.VERTICAL_PARA_BAIXO, new PosicionamentoEmbarcacaoVerticalParaBaixo());
            put(PosicionamentosDeEmbarcacao.VERTICAL_PARA_CIMA, new PosicionamentoEmbarcacaoVerticalParaCima());
        }};
        PosicionadorDeEmbarcacoesPadrao posicionadorEmbarcacoes = new PosicionadorDeEmbarcacoesPadrao(algoritmosPosicionamento);
        
        MaquinaDeJogo maquinaDeJogo = new MaquinaDeJogo(
            executorDisparos,
            checadorVencedor,
            geradorJogadas,
            montadorEmbarcacoes,
            posicionadorEmbarcacoes
        );
        maquinaDeJogo.inicia();
    }
    
    public static String montaJanelaDeInput(String titulo, String prompt) {
        return JOptionPane.showInputDialog(null, prompt, titulo, JOptionPane.QUESTION_MESSAGE);
    }
}
