package br.com.lucianoneves.modelos;

import br.com.lucianoneves.extrato.Extrato;

public class ClienteComum extends Cliente implements InformacoesDoCliente, Extrato {
    private String categoria = "Comum";

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void setValorDoLimite(Double valorDoLimite) {
        if (valorDoLimite <= 1000.0) {
            super.setValorDoLimite(valorDoLimite);
            System.out.println("Valor cadastrado com sucesso!");
        } else {
            System.out.println("Limite permitido de até R$ 1.000,00.");
        }
    }

    @Override
    public String informacoesDoCliente() {
        String mensagem = """
                          \n******************************
                          Nome do cliente: %s
                          Categoria: %s
                          Limite de Crédito: %.2f
                          ******************************
                          """.formatted(getNome(), getCategoria(), getValorDoLimite());
        return mensagem;
    }

    @Override
    public String extrato() {
        for (String despesa: getExtratoDeCartaoDeCredito().keySet()) {
            System.out.println("(-) Despesa/Cliente Comum: " + despesa + " | " + "Valor: " +
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
