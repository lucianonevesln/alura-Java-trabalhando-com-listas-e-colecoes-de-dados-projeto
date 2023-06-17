package br.com.lucianoneves.modelos;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Pessoa {
    private Map<String, Double> extratoDeCartaoDeCredito = new HashMap<>();

    private String nomeDaDespesa;

    private Double valorDaDespesa = 0.0;

    private Double despesasIncorridas = 0.0;

    private Double valorDoLimite = 0.0;

    public Double getValorDoLimite() {
        return valorDoLimite;
    }

    public void setValorDoLimite(Double valorDoLimite) {
        this.valorDoLimite = valorDoLimite;
    }

    public String getNomeDaDespesa() {
        return nomeDaDespesa;
    }

    public void setNomeDaDespesa(String nomeDaDespesa) {
        this.nomeDaDespesa = nomeDaDespesa;
    }

    public Double getValorDaDespesa() {
        return valorDaDespesa;
    }

    public void setValorDaDespesa(Double valorDaDespesa) {
        this.valorDaDespesa = valorDaDespesa;
    }

    public void registraDespesa (String nomeDaDespesa, Double valorDaDespesa) {
        extratoDeCartaoDeCredito.put(nomeDaDespesa, valorDaDespesa);
    }

    public Map<String, Double> getExtratoDeCartaoDeCredito() {
        return extratoDeCartaoDeCredito;
    }

    public Double getDespesasIncorridas() {
        return despesasIncorridas;
    }

    public void setDespesasIncorridas(Double despesasIncorridas) {
        this.despesasIncorridas = despesasIncorridas;
    }

    public void setDespesasIncorridasParaIteracao(Double despesasIncorridas) {
        this.despesasIncorridas += despesasIncorridas;
    }

}
