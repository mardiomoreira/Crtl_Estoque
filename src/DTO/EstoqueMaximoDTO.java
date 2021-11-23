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
public class EstoqueMaximoDTO {

    private int id_produto;
    private double ttestoque;
    private int estoque_minimo;
    private int estoque_maximo;
    private String descricao;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public double getTtestoque() {
        return ttestoque;
    }

    public void setTtestoque(double ttestoque) {
        this.ttestoque = ttestoque;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public int getEstoque_maximo() {
        return estoque_maximo;
    }

    public void setEstoque_maximo(int estoque_maximo) {
        this.estoque_maximo = estoque_maximo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
