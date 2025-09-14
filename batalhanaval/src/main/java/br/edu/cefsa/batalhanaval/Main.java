package br.edu.cefsa.batalhanaval;

import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeFacil;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeMedia;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeDificil;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.HelpersEmbarcacao;
import br.edu.cefsa.batalhanaval.armas.TiposDeTiro;
import br.edu.cefsa.batalhanaval.acoes.execucaoDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.acoes.ChecagemDeVencedor;
import br.edu.cefsa.batalhanaval.acoes.GeradorDeJogadas;
import br.edu.cefsa.batalhanaval.acoes.execucaoDeDisparos.ExecucaoDeDisparo;
import br.edu.cefsa.batalhanaval.acoes.MontagemEmbarcacoes;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaDireita;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaEsquerda;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionadorDeEmbarcacoes;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaBaixo;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaCima;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentosDeEmbarcacao;
import br.edu.cefsa.batalhanaval.main.JanelaDoTabuleiro;
import br.edu.cefsa.batalhanaval.main.Jogador;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        DificuldadeDeJogo[] dificuldades = new DificuldadeDeJogo[] {
            DificuldadeFacil.obtem(),
            DificuldadeMedia.obtem(),
            DificuldadeDificil.obtem()
        };
        
        ExecucaoDeDisparo execucaoDisparo = new ExecucaoDeDisparo();
        Jogador jogadorAtacante = null;
        Jogador jogadorAlvo = null;
        
        ChecagemDeVencedor checagemVencedor = new ChecagemDeVencedor();
        GeradorDeJogadas geradorJogadas = new GeradorDeJogadas();
        
        JanelaDoTabuleiro janelaTabuleiroAtacante;
        JanelaDoTabuleiro janelaTabuleiroAlvo;
        
        String nomeJogador1 = montaJanelaDeInput("Batalha Naval", "Informe o seu nome");
        int escolhaDificuldade = Integer.parseInt(montaJanelaDeInput("BatalhaNaval", "escolha uma dificuldade:\n"
                + "1 - Fácil\n" + "2 - Médio\n" + "3 - Difícil"));

        DificuldadeDeJogo dificuldade = dificuldades[escolhaDificuldade - 1];
        Tabuleiro tabuleiroJogador1 = new Tabuleiro(dificuldade);
        Tabuleiro tabuleiroJogador2 = new Tabuleiro(dificuldade);

        MontagemEmbarcacoes montagemEmbarcacoes = new MontagemEmbarcacoes(dificuldade);
        List<Embarcacao> embarcacoesJogador1 = montagemEmbarcacoes.monta();
        List<Embarcacao> embarcacoesJogador2 = montagemEmbarcacoes.monta();

        jogadorAtacante = new Jogador(embarcacoesJogador1, tabuleiroJogador1);
        jogadorAlvo = new Jogador(embarcacoesJogador2, tabuleiroJogador2);

        HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento = new HashMap<>() {{
            put(PosicionamentosDeEmbarcacao.HORIZONTAL_PARA_ESQUERDA, new PosicionamentoEmbarcacaoHorizontalParaEsquerda());
            put(PosicionamentosDeEmbarcacao.HORIZONTAL_PARA_DIREITA, new PosicionamentoEmbarcacaoHorizontalParaDireita());
            put(PosicionamentosDeEmbarcacao.VERTICAL_PARA_BAIXO, new PosicionamentoEmbarcacaoVerticalParaBaixo());
            put(PosicionamentosDeEmbarcacao.VERTICAL_PARA_CIMA, new PosicionamentoEmbarcacaoVerticalParaCima());
        }};
        PosicionadorDeEmbarcacoes posicionador = new PosicionadorDeEmbarcacoes(algoritmosPosicionamento);
        posicionador.posiciona(jogadorAtacante.obtemTabuleiro(), jogadorAtacante.obtemEmbarcacoes());
        posicionador.posiciona(jogadorAlvo.obtemTabuleiro(), jogadorAlvo.obtemEmbarcacoes());

        janelaTabuleiroAtacante = new JanelaDoTabuleiro(jogadorAtacante.obtemTabuleiro());
        janelaTabuleiroAtacante.atualizaTela();

        janelaTabuleiroAlvo = new JanelaDoTabuleiro(jogadorAlvo.obtemTabuleiro());
        janelaTabuleiroAlvo.setVisible(true);
        janelaTabuleiroAlvo.atualizaTela();
        
        while (true) {
            List<Embarcacao> embarcacoesDisponiveis = HelpersEmbarcacao.filtraEmbarcacoesOperantes(jogadorAtacante.obtemEmbarcacoes());
            String opcoesDoPrompt = "";
            for (int i = 0; i < embarcacoesDisponiveis.size(); i++) {
                opcoesDoPrompt += String.format("%d - %s\n", (i + 1), embarcacoesDisponiveis.get(i).obtemNome());
            }
            int idEmbarcacao = Integer.parseInt(montaJanelaDeInput("Batalha Naval", "Escolha uma embarcação para atirar:\n"
                    + opcoesDoPrompt)) - 1;
            Embarcacao embarcacaoEscolhida = embarcacoesDisponiveis.get(idEmbarcacao);
            
            TiposDeTiro[] tirosDisponiveis = embarcacaoEscolhida.listaTiposDeTiroDisponiveis();
            opcoesDoPrompt = "";
            for (int i = 0; i < tirosDisponiveis.length; i++) {
                opcoesDoPrompt += String.format("%d - %s\n", (i + 1), tirosDisponiveis[i].toString());
            }
            int idTiro = Integer.parseInt(montaJanelaDeInput("Batalha Naval", "Escolha um tipo de tiro:\n"
                    + opcoesDoPrompt)) - 1;
            TiposDeTiro tiroEscolhido = tirosDisponiveis[idTiro];
            
            String coordenadas = montaJanelaDeInput("Batalha Naval",
                    "Informe a posição alvo.\nEx: para atingir a 4º coluna da 3º linha, informe 3:4");
            Coordenadas posicaoAlvo = new Coordenadas(coordenadas);
            
            DadosExecucaoDisparo dadosDisparo = new DadosExecucaoDisparo(embarcacaoEscolhida, tiroEscolhido, posicaoAlvo, jogadorAlvo.obtemTabuleiro());
            boolean disparoExecutado = execucaoDisparo.executa(dadosDisparo);
            if (disparoExecutado) {
                janelaTabuleiroAlvo.atualizaTela();
                if (checagemVencedor.checa(jogadorAlvo, jogadorAtacante) != null) {
                    JOptionPane.showMessageDialog(null, "VENCERAO!!!!!");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Disparo executado! Confira o resultado em tela.");

                    JanelaDoTabuleiro janelaAux = janelaTabuleiroAlvo;
                    janelaTabuleiroAlvo = janelaTabuleiroAtacante;
                    janelaTabuleiroAtacante = janelaAux;

                    janelaTabuleiroAtacante.setVisible(false);
                    janelaTabuleiroAlvo.setVisible(true);

                    Jogador jAuxiliar = jogadorAtacante;
                    jogadorAtacante = jogadorAlvo;
                    jogadorAlvo = jAuxiliar;
                }
                
                
                DadosExecucaoDisparo disparoAleatorio = geradorJogadas.gera(jogadorAtacante.obtemEmbarcacoes(), jogadorAlvo.obtemTabuleiro());
                execucaoDisparo.executa(disparoAleatorio);
                janelaTabuleiroAlvo.atualizaTela();
                JOptionPane.showMessageDialog(null, "O bot realizou uma jogada. Veja o resultado em tela.");
                
                JanelaDoTabuleiro janelaAux = janelaTabuleiroAlvo;
                janelaTabuleiroAlvo = janelaTabuleiroAtacante;
                janelaTabuleiroAtacante = janelaAux;

                janelaTabuleiroAtacante.setVisible(false);
                janelaTabuleiroAlvo.setVisible(true);

                Jogador jAuxiliar = jogadorAtacante;
                jogadorAtacante = jogadorAlvo;
                jogadorAlvo = jAuxiliar;
                
            } else {
                montaJanelaDeInput("INvalido", "invalido chifrudo!!");
            }
        }
        
        
    }
    
    public static String montaJanelaDeInput(String titulo, String prompt) {
        return JOptionPane.showInputDialog(null, prompt, titulo, JOptionPane.QUESTION_MESSAGE);
    }
}
