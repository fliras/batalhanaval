# 🔱 Batalha Naval

Este é um jogo clássico de Batalha Naval implementado em Java, com foco na aplicação dos princípios SOLID e outras boas práticas da programação orientada a objetos. O projeto também serve como exemplo educacional para reforçar conceitos como coesão, acoplamento e separação de responsabilidades.

---

## 🧠 Conceitos Aplicados

- Princípios SOLID
- Encapsulamento
- Herança e polimorfismo
- Separação de responsabilidades
- Baixo acoplamento e alta coesão
- Abstração de regras de negócio

---

## 🧱 Tecnologias e Ferramentas

- Java (JDK 17 ou superior)
- Apache NetBeans (recomendado: versão 12.5 ou superior)
- Maven
- Swing (interface gráfica)

---

## 🕹️ Dinâmica do Jogo

1. **Entrada do jogador**
   - O usuário informa seu **nome** ao iniciar a partida.
   - Em seguida, escolhe a **dificuldade do jogo** (fácil, médio ou difícil).

2. **Configuração do tabuleiro**
   - Um tabuleiro é criado automaticamente com base na dificuldade selecionada (tamanho e número de embarcações variam).
   - As **embarcações do jogador e do bot** são posicionadas **aleatoriamente** em seus respectivos tabuleiros.

3. **Rodadas**
   - O jogo é dividido em turnos alternados entre o **jogador humano** e o **bot**.
   - A cada turno, o jogador:
     - Escolhe uma de suas **embarcações ainda vivas**.
     - Seleciona o **tipo de disparo**:
       - **Simples**: dispara em uma única posição.
       - **Duplo**: dois disparos consecutivos.
       - **Explosivo**: atinge uma área ao redor da posição alvo.
     - Informa a **posição alvo** para o disparo.

4. **Turno do bot**
   - Após o disparo do jogador, o bot realiza seu ataque seguindo uma lógica automática.

5. **Fim de jogo**
   - O jogo continua alternando os turnos até que **um dos lados perca todas as suas embarcações**.
   - Quando isso acontece, o vencedor é anunciado.

---

## 🚀 Como executar o projeto

1. Clone este repositório:

   git clone https://github.com/fliras/batalhanaval.git

2. Abra o projeto no Apache NetBeans:
   - Vá em "File > Open Project"
   - Selecione a pasta raiz do projeto (NetBeans reconhecerá automaticamente como projeto Maven)

3. Execute o jogo:
   - No painel de projetos, abra o arquivo `Main.java`
   - Clique com o botão direito e escolha "Run File" (ou pressione Shift + F6)
   - O método `main()` será executado automaticamente.

   Obs: No NetBeans, o método `main()` é reconhecido como ponto de entrada por padrão.

---

Autor: Felipe Lira
