package br.com.lucianoneves.modelos;

import br.com.lucianoneves.extrato.Extrato;

public class ClienteEspecial extends Cliente implements InformacoesDoCliente, Extrato {
    private String categoria = "Especial";

    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setValorDoLimite(Double valorDoLimite) {
        if (valorDoLimite <= 50000.0) {
            super.setValorDoLimite(valorDoLimite);
            System.out.println("Valor cadastrado com sucesso!");
        } else {
            System.out.println("Limite permitido de até R$ 50.000,00.");
        }

    }

    @Override
    public String informacoesDoCliente() {
        String mensagem = """
                          \n******************************
                          Nome do cliente: %s
                          Categoria: %s
                          Limite de Crédito: %.2f.
                          ******************************
                          """.formatted(getNome(), getCategoria(), getValorDoLimite());
        return mensagem;
    }

    @Override
    public String extrato() {
        for (String despesa: getExtratoDeCartaoDeCredito().keySet()) {
            System.out.println("(-) Despesa/Cliente Especial: " + despesa + " | " + "Valor: " +
                    getExtratoDeCartaoDeCredito().get(despesa));
        }
        return "Fim";
    }

    @Override
    public double saldo() {
        setDespesasIncorridas(0.0);
        for (String despesa : getExtratoDeCartaoDeCredito().keySet()) {
            setDespesasIncorridasParaIteracao(getExtratoDeCartaoDeCredito().get(despesa));
        }
        return getValorDoLimite() - getDespesasIncorridas();
    }

}
