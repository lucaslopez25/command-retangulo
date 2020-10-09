# Command Retângulo
Atividade em casa - mover e colorir um retângulo utilizando o design pattern Command

    Implementar uma aplicação (console, não visual) que permita a realização de "undo" e "redo" de duas operações, realizadas em um objeto retângulo:
        Operação de movimentação: modifica as coordenadas do retângulo para uma nova posição (x, y).
        Operação de mudança de cor: modifica a cor do retângulo para uma nova cor, informada como uma String. 
    A aplicação deve exibir as informações atuais do retângulo - inicialmente na posição (0, 0) e cor preta:
        O retângulo está na posição (0, 0) com cor preta 
    Logo abaixo da informação atual do retângulo, deve exibir o seguinte menu:
        1) Mover o retângulo
        2) Altera a cor do retângulo
        3) Undo
        4) Redo
        5) Sair da aplicação
        Digite a sua opção: 
    Ao selecionar 1:
        A aplicação deve criar uma nova instância da classe MoveCommand, alterar a posição do retângulo e guardar esta instância no histórico de commands. Um atributo deve armazenar a posição atual no histórico de commands. 
    Ao selecionar 2:
        A aplicação deve criar uma nova instância da classe ColorChangeCommand, alterar a cor do retângulo e guardar esta instância no histórico de commands. 
    Ao selecionar 3:
        A aplicação deve executar o método undo() no command atual e retroceder a posição atual no histórico. Caso o primeiro command do histórico já tenha sido desfeito exibir a mensagem "Não posso mais realizar undo". 
    Ao selecionar 4:
        A aplicação deve avançar a posição atual no histórico e executar o método redo() do command atual. Caso o último command do histórico já tenha sido refeito exibir a mensagem "Não posso mais realizar redo". 
    OBS: caso seja selecionado 1 ou 2 e a posição atual no histórico não seja o último elemento, deve-se eliminar todos os elementos à frente da posição atual e proceder conforme indicado acima.
    Ao selecionar 5:
        A aplicação é encerrada. Qualquer uma das outras opções deve realizar a operação informada e reapresentar o menu. 
