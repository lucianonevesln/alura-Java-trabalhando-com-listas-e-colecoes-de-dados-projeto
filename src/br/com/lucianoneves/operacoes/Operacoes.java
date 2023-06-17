package br.com.lucianoneves.operacoes;

public class Operacoes {
    String operacoes = """
                           \n******************************
                           Operações:
                            1 - Cadastrar cliente;
                            2 - Ver dados de cliente cadastrado;
                            3 - Efetuar pagamento;
                            4 - Verificar extrato;
                            5 - Verificar saldo;
                            6 - Sair.
                           ******************************

                           Digite a operação desejada:""";

    public void mostraOperacoes () {
        System.out.println(operacoes);
    }
}
