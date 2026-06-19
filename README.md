# Projeto de Xadrez

Este repositório contém o código-fonte de um sistema completo para simulação e gerenciamento de partidas de xadrez local, desenvolvido como projeto prático para a disciplina de Programação Orientada a Objetos (POO) no curso de Ciência da Computação. O software adota uma arquitetura em camadas e implementa as regras oficiais da Federação Internacional de Xadrez (FIDE).

## Desenvolvedores
* **Antonio Andrade Trauthman**
* **Igor Anicezio Oliveira**

---

## Arquitetura e Padrões de Projeto

O sistema foi estruturado seguindo o padrão de projeto em camadas com o objetivo de garantir a modularização, o baixo acoplamento e a alta coesão entre os componentes do software:

* **Camada de Tabuleiro (boardgame):** Funciona como a base de estrutura de dados genérica para jogos de matriz. É responsável pelo controle dimensional do tabuleiro, verificação de existência de posições e pela alocação ou remoção física de objetos contendo peças. Incorpora mecanismos de programação defensiva através de exceções customizadas para mitigar estados inconsistentes em tempo de execução.
* **Camada de Xadrez (chess):** Detém as regras de negócio e a semântica do jogo de xadrez. Realiza o mapeamento alfanumérico bidirecional (coordenadas do xadrez 'a1' a 'h8' para índices de matriz), gerencia os estados das entidades de jogo, controla a alternância de turnos e computa os estados de vulnerabilidade do Rei.
* **Camada de Aplicação (application):** Atua como a interface de apresentação em modo console (UI). É encarregada da captura de dados de entrada do usuário, do tratamento primário de exceções de digitação e da renderização visual do estado da partida utilizando sequências de escape ANSI para a distinção cromática dos elementos.

---

## Cronograma de Implementação Incremental

O desenvolvimento do sistema seguiu rigorosamente o fluxo evolutivo estipulado pelo roteiro metodológico do projeto:

### Fase 1: Estrutura Base e Matriz do Tabuleiro
* Configuração do controle de versão via Git e parametrização do arquivo `.gitignore` para o ecossistema Java.
* Modelagem e encapsulamento da classe básica de coordenadas `Position`.
* Codificação das classes abstratas e estruturais `Piece` e `Board`, estabelecendo as associações iniciais da estrutura de dados em matriz.

### Fase 2: Alinhamento da Camada de Xadrez e Interface Gráfica Primal
* Introdução do enumerador `Color` e especialização da classe `ChessPiece` por meio de herança.
* Acoplamento do controlador principal da partida `ChessMatch` e concepção dos métodos de impressão de caracteres na classe `UI`.
* Desenvolvimento do método de posicionamento inicial de peças (`InitialSetup`) com inserção polimórfica das torres (`Rook`) e reis (`King`).

### Fase 3: Programação Defensiva e Lógica de Translação
* Implementação da classe `BoardException` para validações limítrofes do tabuleiro.
* Concepção da classe `ChessPosition` e refatoração dos métodos de inicialização para o padrão alfanumérico convencional.
* Codificação da lógica de movimentação elementar (`PerformChessMove` e `MakeMove`) integrada à rotina de limpeza dinâmica do terminal (`clearScreen`).

### Fase 4: Matrizes de Movimentos Legais e Gestão de Turnos
* Declaração de métodos abstratos para o cálculo de movimentos possíveis na classe abstrata genérica, permitindo a sobrescrita polimórfica por componente.
* Sobrecarga do método de impressão do tabuleiro para realce visual das posições viáveis de destino no console.
* Atribuição das propriedades de controle de fluxo de jogo `Turn` e `CurrentPlayer` com restrição de acesso a modificações externas.

### Fase 5: Estruturas de Captura e Validação de Estados de Cheque
* Implementação de coleções do tipo `List` na classe `ChessMatch` para triagem segregada de peças ativas e peças capturadas.
* Desenvolvimento do algoritmo reversivo `UndoMove`, essencial para submeter cenários hipotéticos à validação da engine.
* Codificação dos métodos analíticos `TestCheck` e `TestCheckmate` para monitoramento de vetores de ataque contra o Rei e verificação de ausência de movimentos de fuga válidos.

### Fase 6: Finalização do Escopo de Peças e Movimentos Especiais
* Introdução da propriedade de contagem de movimentos (`MoveCount`) em `ChessPiece` para subsidiar regras temporais.
* Conclusão do modelo de classes com a lógica vetorial interna e polimórfica para as peças `Pawn` (Peão), `Bishop` (Bispo), `Knight` (Cavalo) e `Queen` (Rainha).
* Implementação dos três movimentos especiais normatizados:
  * **Roque (Castling):** Translação simultânea e coordenada entre as entidades Rei e Torre.
  * **En Passant:** Captura em diagonal de um peão adversário vulnerável que executou avanço duplo no turno imediatamente anterior.
  * **Promoção (Promotion):** Substituição compulsória do peão que atinge a extremidade oposta do tabuleiro por uma peça de maior valor tático.

---

## Conceitos de Orientação a Objetos Evidenciados

* **Encapsulamento Rígido:** Utilização estrita de modificadores de acesso (`private` e `protected`) para salvaguardar o estado interno das classes, disponibilizando a leitura por meio de propriedades com métodos de acesso públicos e alteração restrita.
* **Herança Extensível:** Uso da palavra-chave `extends` para reaproveitamento de propriedades e comportamentos estruturais comuns (ex: `ChessPiece` estendendo a classe abstrata `Piece`).
* **Polimorfismo Dinâmico:** Aplicação de vinculação tardia onde o método genérico de movimentos possíveis (`possibleMoves`) comporta-se de forma distinta de acordo com a instância real da peça invocada em tempo de execução.
* **Sobrecarga (Overloading):** Implementação de métodos homogêneos com assinaturas de argumentos distintas (ex: renderização padrão do tabuleiro *versus* renderização com realce de caminhos possíveis).

---

## Apresentação do Projeto

O vídeo explicativo detalhando a arquitetura estrutural adotada, as principais decisões de projeto tomadas pela dupla, os desafios de engenharia superados e a demonstração prática das funcionalidades implementadas encontra-se disponível no endereço institucional abaixo:

* URL: [Acessar Apresentação do Projeto - Google Drive](link do drive)

---

## Instruções para Compilação e Execução

Para compilar e executar a aplicação a partir do código-fonte em um terminal compatível com caracteres ANSI, execute a sequência de comandos descrita a seguir:

1. Certifique-se de possuir o Java JDK 11 ou superior configurado nas variáveis de ambiente do sistema.
2. Acesse o diretório raiz do projeto clonado.
3. Realize a compilação direcionando os binários para uma pasta de destino:
   ```bash
   javac src/application/Program.java -d bin

## Estrutura Para os Diretórios:

```
sistema-xadrez-java/
│
├── src/
│   ├── application/
│   │   ├── Program.java         # Fluxo principal do jogo e tratamento de exceções gerais 
│   │   └── UI.java              # Cores ANSI, leitura de posições, prints de tabuleiro/partida/capturadas 
│   │
│   ├── boardgame/               # Camada de Dados e Estrutura do Tabuleiro 
│   │   ├── Position.java        # Linha e coluna da matriz 
│   │   ├── Piece.java           # Classe abstrata base com os métodos de movimentos possíveis 
│   │   ├── Board.java           # Matriz, colocação/remoção e validações defensivas 
│   │   └── BoardException.java  # Exceções de violação de limites ou regras de posição 
│   │
│   └── chess/                   # Camada de Regras de Negócio do Xadrez 
│       ├── Color.java           # Enum para WHITE e BLACK 
│       ├── ChessPiece.java      # Herda Piece; adiciona Cor, ChessPosition e MoveCount 
│       ├── ChessPosition.java   # Converte coordenadas 'a1'-'h8' para índices da matriz 
│       ├── ChessException.java  # Exceções específicas da lógica de xadrez 
│       ├── ChessMatch.java      # Core: turnos, xeque, xeque-mate, capturas, regras especiais 
│       │
│       └── pieces/              # Implementações polimórficas de cada peça 
│           ├── King.java        # Movimentos do Rei + lógica de Roque 
│           ├── Queen.java       # Movimentos combinados de Torre e Bispo 
│           ├── Rook.java        # Movimentos em linhas/colunas diretas 
│           ├── Bishop.java      # Movimentos estritamente diagonais 
│           ├── Knight.java      # Movimento em 'L' (pula peças) 
│           └── Pawn.java        # Movimento frontal + Capturas + En Passant
│
├── .gitignore                   # Configurado para ignorar binários do Java
└── README.md
```