/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EntradaProdutoDTO;
import DTO.Vw_estoqueprodutoDTO;
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
public class EstoqueMinimoDAO {

    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    String sql;
    ArrayList<Vw_estoqueprodutoDTO> listaVw_estoqueprodutoDTO = new ArrayList<>();

    public ArrayList<Vw_estoqueprodutoDTO> estoqueMinimo() {
        sql = "SELECT * FROM `vw_estoqueproduto` WHERE ttestoque < estoque_minimo;";
        conn = new Conexao().conexaoBD();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Vw_estoqueprodutoDTO objVw_estoqueprodutoDTO = new Vw_estoqueprodutoDTO();
                objVw_estoqueprodutoDTO.setId_produto(rs.getInt("id_produto"));
                objVw_estoqueprodutoDTO.setTtestoque(rs.getInt("ttestoque"));
                objVw_estoqueprodutoDTO.setEstoque_minimo(rs.getInt("estoque_minimo"));
                objVw_estoqueprodutoDTO.setEstoque_maximo(rs.getInt("estoque_maximo"));
                objVw_estoqueprodutoDTO.setDescricao(rs.getString("descricao"));
                listaVw_estoqueprodutoDTO.add(objVw_estoqueprodutoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Vw_estoqueprodutoDTO: " + erro);
        }
        return listaVw_estoqueprodutoDTO;
    }
}
