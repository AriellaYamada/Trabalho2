# Atribuições iniciais
    int matrix[9];
    int Estado = 1;
    int Quem_Começa = Servidor

# Estado 1 - Escolhendo Modo
- Imprime tela inicial, perguntando se vai ser cliente ou servidor
  - Se clicar em Cliente:
    - `Jogador = Cliente`
    - `Estado = 4`
  - Se clicar em Servidor:
    - `Jogador = Servidor`
    - `Estado = 2 (ou 3)`

# Estado 2 - Configurar Conexão
- Imprime campos para preencher com  a porta
- Ao clicar em Concluir, `Estado = 3`

Obs.: Talvez isso não seja necessário, aí pode pular direto para o Estado 3

# Estado 3 - Esperando Conexão
- Imprimir a informação do próprio IP e Porta
- Cria ServerSocket
- Quando Cliente conectar, `Estado = 6`

# Estado 4 - Conectando com o Servidor
- Imprime campos para preencher com IP (e talvez com a porta)
- Ao clicar em Concluir, `Estado = 5`

# Estado 5 - Tentando Conexão
- Cria Socket
- Quando conseguir conectar com o Servidor, `Estado = 6`

# Estado 6 - Imprimir Tabuleiro
- Inicializa `matrix = [0, 0, 0, 0, 0, 0, 0, 0, 0]`
- Imprime a grade do Jogo da Velha, com todos os botões desativados
- Inverte o estado de `Quem_Começa` (`Cliente` vira `Servidor` e vice-versa)
- Se `Quem_Começa == Servidor`:
  - Se `Jogador == Cliente`, `Estado = 9`
  - Se `Jogador == Servidor`, `Estado = 7`
- Se `Quem_Começa == Cliente`:
  - Se `Jogador == Cliente`, `Estado = 9`
  - Se `Jogador == Servidor`, `Estado = 7`

# Estado 7 - Sua vez de jogar
- Habilitar botões possíveis de serem clicados
  - Se `clicar em Desistir`:
    - Envia sinal de desistência para o outro jogador
    - `Estado = 12`
  - Se `clicar em um btn[n]`:
    - Desabilitar todos os botões
    - `Resposta = n`
    - Envia `Resposta` para a outra pessoa
    - `Estado = 8` (parêmatros `resposta` e `9`)

# Estado 8 - Efetuar jogada
(Isso pode ser um método que recebe `resposta` e `próx_estado` como parêmetros)
- `matrix[Resposta] = X (ou O)`
- Imprime Símbolo na tela
- Verifica se houve ganhador:
  - Se sim, `Estado = 10`
  - Se não, `Estado = próx_estado`
- Verifica se ainda há espaço para jogar:
  - Se sim, `Estado` permanece igual
  - Se não, `Estado = 11`

# Estado 9 - Esperando o outro
- Quando receber alguma comunicação:
  - Se recebeu sinal que o outro desistiu, `Estado = 12`
  - Do contrário, `Estado = 8` (parâmetros `estrada_de_comm` e `7`)

# Estado 10 - Alguém Venceu :tada:
- Marcar na tela a linha/coluna/diagonal que ganhou
- Adiciona 1 ponto para o ganhador
- Espera 1 seg
- `Estado = 6`

# Estado 11 - Deu Velha :confused:
- Imprime "Deu velha" na tela
- Espera 1 seg
- `Estado = 6`

# Estado 12 - Alguém desistiu :satisfied:
- Imprime na tela "Fim de jogo" e o placar
- Encerra a conexão dos sockets
