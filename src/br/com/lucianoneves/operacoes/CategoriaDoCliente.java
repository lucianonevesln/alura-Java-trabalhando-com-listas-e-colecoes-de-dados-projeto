package br.com.lucianoneves.operacoes;

public class CategoriaDoCliente {
    private byte categoria = 0;

    public byte getCategoria() {
        return categoria;
    }

    public void setCategoria(byte categoria) {
        this.categoria = categoria;
    }

    String categoriaDoCliente = """
                                    \n******************************
                                    Escolha a categoria do Cliente:
                                    1 - Cliente Comum;
                                    2 - Cliente Especial.
                                    ******************************
                                    
                                    Digite a categoria desejada:""";

    public void mostraCategoriasDoCliente () {
        System.out.println(categoriaDoCliente);
    }

}
