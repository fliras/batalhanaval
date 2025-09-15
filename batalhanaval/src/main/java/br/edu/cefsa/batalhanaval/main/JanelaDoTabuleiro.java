package br.edu.cefsa.batalhanaval.main;

import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.tabuleiro.PosicaoTabuleiroPadrao;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class JanelaDoTabuleiro extends JFrame {
    private JPanel gridPanel;
    private final JPanel[][] celulas;
    private final Tabuleiro tabuleiro;
    private final int qtdeLinhas;
    private final int qtdeColunas;
    private boolean deveEsconderEmbarcacoes;

    public JanelaDoTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        qtdeLinhas = qtdeColunas = tabuleiro.obtemQuantidadeDeLinhasEColunas();
        this.celulas = new JPanel[qtdeLinhas][qtdeColunas];
        this.deveEsconderEmbarcacoes = true;

        configurarJanela();
        criarPainelNumerado();
    }

    private void configurarJanela() {
        setTitle("Tabuleiro do Alvo atual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    private void criarPainelNumerado() {
        // Painel que junta tudo
        JPanel painelComNumeracao = new JPanel(new BorderLayout());

        // ---------- Numeração das colunas (horizontal, no topo) ----------
        JPanel colNumbers = new JPanel(new GridLayout(1, qtdeColunas));
        for (int col = 0; col < qtdeColunas; col++) {
            JLabel label = new JLabel(String.valueOf(col + 1), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            label.setPreferredSize(new Dimension(30, 30));
            colNumbers.add(label);
        }

        // Adiciona um placeholder para alinhar com numeração da linha
        JPanel topoComEspaco = new JPanel(new BorderLayout());
        topoComEspaco.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST); // mesmo tamanho dos números das linhas
        topoComEspaco.add(colNumbers, BorderLayout.CENTER);
        painelComNumeracao.add(topoComEspaco, BorderLayout.NORTH);

        // ---------- Numeração das linhas (vertical, na esquerda) ----------
        JPanel rowNumbers = new JPanel(new GridLayout(qtdeLinhas, 1));
        for (int lin = 0; lin < qtdeLinhas; lin++) {
            JLabel label = new JLabel(String.valueOf(lin + 1), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(30, 30));
            label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            rowNumbers.add(label);
        }
        painelComNumeracao.add(rowNumbers, BorderLayout.WEST);

        // ---------- Grid de células ----------
        gridPanel = new JPanel(new GridLayout(qtdeLinhas, qtdeColunas));
        for (int i = 0; i < qtdeLinhas; i++) {
            for (int j = 0; j < qtdeColunas; j++) {
                JPanel celula = new JPanel();
                celula.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                celulas[i][j] = celula;
                gridPanel.add(celula);
            }
        }
        painelComNumeracao.add(gridPanel, BorderLayout.CENTER);

        // Adiciona tudo na parte central da janela
        add(painelComNumeracao, BorderLayout.CENTER);
    }
    
    public void atualizaTela() {
        limpaTela();
        PosicaoTabuleiroPadrao[] posicoesAcessadas = tabuleiro.obtemPosicoesAcessadas();
        for (PosicaoTabuleiroPadrao posicao : posicoesAcessadas) {
            Coordenadas coordenadasPosicao = posicao.obtemCoordenadas();
            Color cor = Color.CYAN;
            if (!posicao.verificaSeEstaVazia() && posicao.verificaSeFoiAtingida())
                cor = Color.RED;
            else if (!deveEsconderEmbarcacoes && !posicao.verificaSeEstaVazia())
                cor = Color.BLACK;
            else if (posicao.verificaSeFoiAtingida())
                cor = Color.LIGHT_GRAY;
            celulas[coordenadasPosicao.obtemLinha() - 1][coordenadasPosicao.obtemColuna() - 1].setBackground(cor);
        }
    }
    
    private void limpaTela() {
        for (int linha = 0; linha < qtdeLinhas; linha++) {
            for (int coluna = 0; coluna < qtdeColunas; coluna++) {
                celulas[linha][coluna].setBackground(Color.CYAN);
            }
        }
    }
    
    public void defineSeDeveEsconderEmbarcacoes(boolean deveEsconder) {
        deveEsconderEmbarcacoes = deveEsconder;
    }
}
