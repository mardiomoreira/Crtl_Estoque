/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mardio
 */
public class Vw_estoqueprodutoDTO {
    private int  id_produto;
    private double ttestoque;
    private int estoque_minimo;
    private int estoque_maximo;
    private String descricao;

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the ttestoque
     */
    public double getTtestoque() {
        return ttestoque;
    }

    /**
     * @param ttestoque the ttestoque to set
     */
    public void setTtestoque(double ttestoque) {
        this.ttestoque = ttestoque;
    }

    /**
     * @return the estoque_minimo
     */
    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    /**
     * @param estoque_minimo the estoque_minimo to set
     */
    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    /**
     * @return the estoque_maximo
     */
    public int getEstoque_maximo() {
        return estoque_maximo;
    }

    /**
     * @param estoque_maximo the estoque_maximo to set
     */
    public void setEstoque_maximo(int estoque_maximo) {
        this.estoque_maximo = estoque_maximo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
