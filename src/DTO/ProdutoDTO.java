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
public class ProdutoDTO {
    
private int id;
private String status;
private String descricao;
private int estoque_minimo;
private int estoque_maximo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
    
}
