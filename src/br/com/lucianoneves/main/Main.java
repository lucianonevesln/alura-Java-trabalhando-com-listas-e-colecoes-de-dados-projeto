package br.com.lucianoneves.main;

import br.com.lucianoneves.extrato.MostraExtrato;
import br.com.lucianoneves.modelos.MostraInformacoesDoCliente;
import br.com.lucianoneves.modelos.ClienteComum;
import br.com.lucianoneves.modelos.ClienteEspecial;
import br.com.lucianoneves.modelos.Utils;
import br.com.lucianoneves.operacoes.CategoriaDoCliente;
import br.com.lucianoneves.operacoes.Operacoes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        byte controle = 5;

        ClienteComum clienteComum = new ClienteComum();
        ClienteEspecial clienteEspecial = new ClienteEspecial();
        Operacoes operacoes = new Operacoes();
        CategoriaDoCliente categoriaDoCliente = new CategoriaDoCliente();
        MostraInformacoesDoCliente mostraInformacoesDoCliente = new MostraInformacoesDoCliente();
        MostraExtrato mostraExtrato = new MostraExtrato();
        Utils utils = new Utils();

        operacoes.mostraOperacoes();
        controle = leitura.nextByte();

        while (controle != 6) {
            if (controle == 1) {
                categoriaDoCliente.mostraCategoriasDoCliente();
                categoriaDoCliente.setCategoria(leitura.nextByte());
                if (categoriaDoCliente.getCategoria() == 1) {
                    utils.pedeNome();
                    clienteComum.setNome(leitura.next());
                    utils.pedeLimite();
                    clienteComum.setValorDoLimite(leitura.nextDouble());
                } else if (categoriaDoCliente.getCategoria() == 2) {
                    utils.pedeNome();
                    clienteEspecial.setNome(leitura.next());
                    utils.pedeLimite();
                    clienteEspecial.setValorDoLimite(leitura.nextDouble());
                } else {
                    utils.informaValidadeDeOperacao();
                }
            } else if (controle == 2) {
                if (categoriaDoCliente.getCategoria() == 1) {
                    mostraInformacoesDoCliente.mostrar(clienteComum);
                } else {
                    mostraInformacoesDoCliente.mostrar(clienteEspecial);
                }
            } else if (controle == 3) {
                if (categoriaDoCliente.getCategoria() == 1) {
                    utils.pedeDespesa();
                    clienteComum.setNomeDaDespesa(leitura.next());
                    utils.pedeValorDeDespesa();
                    clienteComum.setValorDaDespesa(leitura.nextDouble());
                    clienteComum.registraDespesa(clienteComum.getNomeDaDespesa(), clienteComum.getValorDaDespesa());
                } else if (categoriaDoCliente.getCategoria() == 2) {
                    utils.pedeDespesa();
                    clienteEspecial.setNomeDaDespesa(leitura.next());
                    utils.pedeValorDeDespesa();
                    clienteEspecial.setValorDaDespesa(leitura.nextDouble());
                    clienteEspecial.registraDespesa(clienteEspecial.getNomeDaDespesa(),
                            clienteEspecial.getValorDaDespesa());
                } else {
                    utils.informaValidadeDeCategoria();
                }
            } else if (controle == 4) {
                if (categoriaDoCliente.getCategoria() == 1) {
                    mostraExtrato.mostraExtrato(clienteComum);
                } else if (categoriaDoCliente.getCategoria() == 2) {
                    mostraExtrato.mostraExtrato(clienteEspecial);
                } else {
                    utils.informaValidadeDeCategoria();
                }
            } else if (controle == 5) {
                if (categoriaDoCliente.getCategoria() == 1) {
                    mostraExtrato.mostraSaldo(clienteComum);
                } else if (categoriaDoCliente.getCategoria() == 2) {
                    mostraExtrato.mostraSaldo(clienteEspecial);
                } else {
                    utils.informaValidadeDeCategoria();
                }
            } else {
                utils.informaValidadeDeOperacao();
            }
            operacoes.mostraOperacoes();
            controle = leitura.nextByte();
        }

        leitura.close();
    }

}
