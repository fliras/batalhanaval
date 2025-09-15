package br.edu.cefsa.batalhanaval.main;

import br.edu.cefsa.batalhanaval.acoes.contratos.ChecadorDeVencedor;
import br.edu.cefsa.batalhanaval.acoes.contratos.GeradorDeJogadas;
import br.edu.cefsa.batalhanaval.acoes.contratos.MontadorDeEmbarcacoes;
import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.ExecutorDeDisparos;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.PosicionadorDeEmbarcacoes;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.PosicionamentosDeEmbarcacao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionadorDeEmbarcacoesPadrao;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaDireita;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoHorizontalParaEsquerda;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaBaixo;
import br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes.PosicionamentoEmbarcacaoVerticalParaCima;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeDificil;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeFacil;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeMedia;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.contratos.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.embarcacoes.HelpersEmbarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;
import br.edu.cefsa.batalhanaval.utils.Utils;
import java.util.List;

public class MaquinaDeJogo {    
    private final DificuldadeDeJogo[] dificuldades = new DificuldadeDeJogo[] {
        DificuldadeFacil.obtem(),
        DificuldadeMedia.obtem(),
        DificuldadeDificil.obtem()
    };
    
    private final ExecutorDeDisparos executorDisparos;
    private final ChecadorDeVencedor checadorVencedor;
    private final GeradorDeJogadas geradorJogadas;
    private final MontadorDeEmbarcacoes montadorEmbarcacoes;
    private final PosicionadorDeEmbarcacoes posicionadorEmbarcacoes;
    
    private JanelaDoTabuleiro janelaTabuleiroAlvo;
    private JanelaDoTabuleiro janelaTabuleiroAtacante;
    
    private DificuldadeDeJogo dificuldade;
    private Jogador jogadorAtacante;
    private Jogador jogadorAlvo;
    private DadosExecucaoDisparo dadosProximaJogada;
    private EstadosMaquinaDeJogo estadoAtual;
    
    public MaquinaDeJogo(
            ExecutorDeDisparos executorDisparos,
            ChecadorDeVencedor checadorVencedor,
            GeradorDeJogadas geradorJogadas,
            MontadorDeEmbarcacoes montadorEmbarcacoes,
            PosicionadorDeEmbarcacoes posicionadorEmbarcacoes) {
        this.executorDisparos = executorDisparos;
        this.checadorVencedor = checadorVencedor;
        this.geradorJogadas = geradorJogadas;
        this.montadorEmbarcacoes = montadorEmbarcacoes;
        this.posicionadorEmbarcacoes = posicionadorEmbarcacoes;
    }
    
    public void inicia() {
        estadoAtual = EstadosMaquinaDeJogo.OBTENCAO_DO_NOME_DO_JOGADOR;
        loop();
    }
    
    private void loop() {
        while (true) {
            switch(estadoAtual) {
                case OBTENCAO_DO_NOME_DO_JOGADOR -> obtemNomeDoJogador();
                case ESCOLHA_DE_DIFICULDADE -> solicitaDificuldade();
                case INICIALIZACAO_DE_COMPONENTES -> inicializaComponentes();
                case ESCOLHA_DE_EMBARCACAO -> solicitaEmbarcacao();
                case ESCOLHA_DE_TIRO -> solicitaTipoDeTiro();
                case ESCOLHA_DE_ALVO -> solicitaCoordenadasDoAlvo();
                case REALIZACAO_DE_DISPARO -> realizaDisparo();
                case DISPARO_DO_BOT -> realizaDisparoDoBot();
                case REINICIO -> reinicia();
            }
        }
    }
    
    private void obtemNomeDoJogador() {
        String nomeJogador = Utils.obtemInput("Digite o seu nome: ");
        if (!nomeJogador.equals("")) {
            jogadorAtacante = new Jogador();
            jogadorAtacante.atribuiNome(nomeJogador);
            estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_DIFICULDADE;
        } else {
            Utils.exibeMensagem("Informe o seu nome!");
        }
    }
    
    private void solicitaDificuldade() {
        int escolhaDificuldade = Utils.obtemOpcaoNumerica("escolha uma dificuldade:\n"
            + "1 - Fácil\n" + "2 - Médio\n" + "3 - Difícil");
        if (escolhaDificuldade != -1) {
            dificuldade = dificuldades[escolhaDificuldade - 1];
            estadoAtual = EstadosMaquinaDeJogo.INICIALIZACAO_DE_COMPONENTES;
        } else {
            Utils.exibeMensagem("Opção inválida! Escolha novamente");
        }
    }
    
    private void inicializaComponentes() {        
        Tabuleiro tabuleiroJogador1 = new TabuleiroPadrao(dificuldade);
        Tabuleiro tabuleiroJogador2 = new TabuleiroPadrao(dificuldade);
        
        List<Embarcacao> embarcacoesJogador1 = montadorEmbarcacoes.monta(dificuldade);
        List<Embarcacao> embarcacoesJogador2 = montadorEmbarcacoes.monta(dificuldade);

        jogadorAtacante.atribuiEmbarcacoes(embarcacoesJogador1);
        jogadorAtacante.atribuiTabuleiro(tabuleiroJogador1);
        
        jogadorAlvo = new Jogador();
        jogadorAlvo.atribuiNome("BOT");
        jogadorAlvo.atribuiEmbarcacoes(embarcacoesJogador2);
        jogadorAlvo.atribuiTabuleiro(tabuleiroJogador2);
        
        posicionadorEmbarcacoes.posiciona(jogadorAtacante.obtemTabuleiro(), jogadorAtacante.obtemEmbarcacoes());
        posicionadorEmbarcacoes.posiciona(jogadorAlvo.obtemTabuleiro(), jogadorAlvo.obtemEmbarcacoes());

        janelaTabuleiroAtacante = new JanelaDoTabuleiro(jogadorAtacante.obtemTabuleiro());
        janelaTabuleiroAtacante.atualizaTela();

        janelaTabuleiroAlvo = new JanelaDoTabuleiro(jogadorAlvo.obtemTabuleiro());
        janelaTabuleiroAlvo.setVisible(true);
        janelaTabuleiroAlvo.atualizaTela();
        
        dadosProximaJogada = new DadosExecucaoDisparo();
        dadosProximaJogada.atribuiTabuleiroAlvo(jogadorAlvo.obtemTabuleiro());
        estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_EMBARCACAO;
    }
    
    private void solicitaEmbarcacao() {
        List<Embarcacao> embarcacoesDisponiveis = HelpersEmbarcacao.filtraEmbarcacoesOperantes(jogadorAtacante.obtemEmbarcacoes());
        String opcoesDoPrompt = "";
        for (int i = 0; i < embarcacoesDisponiveis.size(); i++) {
            opcoesDoPrompt += String.format("%d - %s\n", (i + 1), embarcacoesDisponiveis.get(i).obtemNome());
        }
        int idEmbarcacao = Utils.obtemOpcaoNumerica("Escolha uma embarcação para atirar:\n" + opcoesDoPrompt);
        if (idEmbarcacao == -1 || idEmbarcacao - 1 >= embarcacoesDisponiveis.size()) {
            Utils.exibeMensagem("Embarcação inválida! Escolha novamente.");
        } else {
            Embarcacao embarcacaoEscolhida = embarcacoesDisponiveis.get(idEmbarcacao - 1);
            dadosProximaJogada.atribuiEmbarcacao(embarcacaoEscolhida);
            estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_TIRO;
        }
    }
    
    private void solicitaTipoDeTiro() {
        TiposDeTiro[] tirosDisponiveis = dadosProximaJogada.obtemEmbarcacao().listaTiposDeTiroDisponiveis();
        String opcoesDoPrompt = "";
        for (int i = 0; i < tirosDisponiveis.length; i++) {
            opcoesDoPrompt += String.format("%d - %s\n", (i + 1), tirosDisponiveis[i].toString());
        }
        int idTiro = Utils.obtemOpcaoNumerica("Escolha um tipo de tiro:\n" + opcoesDoPrompt);
        if (idTiro == -1 || idTiro - 1 >= tirosDisponiveis.length) {
            Utils.exibeMensagem("Tiro inválido! Escolha novamente.");
        } else {
            TiposDeTiro tiroEscolhido = tirosDisponiveis[idTiro - 1];
            dadosProximaJogada.atribuiTipoTiro(tiroEscolhido);
            estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_ALVO;
        }
    }
    
    private void solicitaCoordenadasDoAlvo() {
        String coordenadas = Utils.obtemInput("Informe a posição alvo.\nEx: para atingir a 4º coluna da 3º linha, informe 3:4");
        Coordenadas posicaoAlvo = new Coordenadas(coordenadas);
        dadosProximaJogada.atribuiPosicaoAlvo(posicaoAlvo);
        estadoAtual = EstadosMaquinaDeJogo.REALIZACAO_DE_DISPARO;
    }
    
    private void realizaDisparo() {
        boolean disparoExecutado = executorDisparos.executa(dadosProximaJogada);
        if (disparoExecutado) {
            janelaTabuleiroAlvo.atualizaTela();
            Jogador vencedor = checadorVencedor.checa(jogadorAlvo, jogadorAtacante);
            if (vencedor != null) {
                Utils.exibeMensagem(String.format("O jogador %s venceu!", vencedor.obtemNome()));
                estadoAtual = EstadosMaquinaDeJogo.REINICIO;
            } else {
                Utils.exibeMensagem("Disparo executado! Confira o resultado em tela.");
                alternaTurno();
                estadoAtual = EstadosMaquinaDeJogo.DISPARO_DO_BOT;
            }
        } else {
            Utils.exibeMensagem("Disparo não realizado! Tente novamente.");
            estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_ALVO;
        }
    }
    
    private void realizaDisparoDoBot() {
        DadosExecucaoDisparo disparoAleatorio = geradorJogadas.gera(jogadorAtacante.obtemEmbarcacoes(), jogadorAlvo.obtemTabuleiro());
        boolean disparoExecutado = executorDisparos.executa(disparoAleatorio);
        if (disparoExecutado) {
            janelaTabuleiroAlvo.atualizaTela();
            Jogador vencedor = checadorVencedor.checa(jogadorAlvo, jogadorAtacante);
            if (vencedor != null) {
                Utils.exibeMensagem(String.format("O jogador %s venceu!", vencedor.obtemNome()));
                estadoAtual = EstadosMaquinaDeJogo.REINICIO;
            } else {
                Utils.exibeMensagem("O bot realizou uma jogada. Veja o resultado em tela.");
                alternaTurno();
                estadoAtual = EstadosMaquinaDeJogo.ESCOLHA_DE_EMBARCACAO;
            }
        }
    }
        
    private void alternaTurno() {
        JanelaDoTabuleiro janelaAux = janelaTabuleiroAlvo;
        janelaTabuleiroAlvo = janelaTabuleiroAtacante;
        janelaTabuleiroAtacante = janelaAux;

        janelaTabuleiroAtacante.setVisible(false);
        janelaTabuleiroAlvo.setVisible(true);

        Jogador jAuxiliar = jogadorAtacante;
        jogadorAtacante = jogadorAlvo;
        jogadorAlvo = jAuxiliar;
        dadosProximaJogada.atribuiTabuleiroAlvo(jogadorAlvo.obtemTabuleiro());
    }
    
    private void reinicia() {
        janelaTabuleiroAlvo.dispose();
        janelaTabuleiroAtacante.dispose();
        estadoAtual = EstadosMaquinaDeJogo.OBTENCAO_DO_NOME_DO_JOGADOR;
    }
}
