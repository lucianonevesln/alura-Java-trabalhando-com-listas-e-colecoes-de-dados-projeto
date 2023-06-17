package br.com.lucianoneves.extrato;

public class MostraExtrato {
    public void mostraExtrato (Extrato extrato) {
        System.out.println(extrato.extrato());
    }

    public void mostraSaldo (Extrato extrato) {
        System.out.println("Saldo disponível: " + extrato.saldo());
    }

}
