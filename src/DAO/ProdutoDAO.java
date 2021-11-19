/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class ProdutoDAO {

    Connection Conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> lista = new ArrayList<>();


    public void cadastrarProduto(ProdutoDTO objProdutoDTO) {
        Conn = new Conexao().conexaoBD();
        String sql = "INSERT INTO produto(`status`,`descricao`,`estoque_minimo`,`estoque_maximo`)VALUES(?,?,?,?);";

        try {

            pstm = Conn.prepareStatement(sql);
            pstm.setString(1, objProdutoDTO.getStatus());
            pstm.setString(2, objProdutoDTO.getDescricao());
            pstm.setInt(3, objProdutoDTO.getEstoque_minimo());
            pstm.setInt(4, objProdutoDTO.getEstoque_maximo());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "<html>O produto <b style='color:#35fc03'>" + objProdutoDTO.getDescricao() + "</b> foi cadastrato com Sucesso!!");
            
        } catch (SQLException erro) {
            System.out.println("ProdutoDAO erro: "+erro);

        }

    }
    public ArrayList<ProdutoDTO> PesquisarProduto(){
        String sql = "SELECT * FROM `produto`;";
        Conn = new Conexao().conexaoBD();
        try {
            pstm = Conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setId(rs.getInt("id"));
                objProdutoDTO.setStatus(rs.getString("status"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setEstoque_minimo(rs.getInt("estoque_minimo"));
                objProdutoDTO.setEstoque_maximo(rs.getInt("estoque_maximo"));
                lista.add(objProdutoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO: " + erro);
        }
        return lista;
    }

}
