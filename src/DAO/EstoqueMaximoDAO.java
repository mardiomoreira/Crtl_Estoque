/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EstoqueMaximoDTO;
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
public class EstoqueMaximoDAO {

    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    String sql;
    ArrayList<EstoqueMaximoDTO> listaEstoqueMaximoDTO = new ArrayList<>();

    public ArrayList<EstoqueMaximoDTO> estoqueMaximo() {
        sql = "SELECT * FROM `vw_estoqueproduto` WHERE ttestoque > `estoque_maximo`;";
        conn = new Conexao().conexaoBD();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                EstoqueMaximoDTO objEstoqueMaximoDTO = new EstoqueMaximoDTO();
                objEstoqueMaximoDTO.setId_produto(rs.getInt("id_produto"));
                objEstoqueMaximoDTO.setTtestoque(rs.getInt("ttestoque"));
                objEstoqueMaximoDTO.setEstoque_minimo(rs.getInt("estoque_minimo"));
                objEstoqueMaximoDTO.setEstoque_maximo(rs.getInt("estoque_maximo"));
                objEstoqueMaximoDTO.setDescricao(rs.getString("descricao"));
                listaEstoqueMaximoDTO.add(objEstoqueMaximoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EstoqueMaximo: "+erro);
        }
        return listaEstoqueMaximoDTO;
    }
}
