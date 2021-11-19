/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.EntradaProdutoDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class EntradaProdutoDAO {

    public void CadastrarEntradaProduto(EntradaProdutoDTO objEntradaProdutoDTO) {
        Connection Conn;
        PreparedStatement pstm;
        String sql;
        Conn = new Conexao().conexaoBD();
        sql = "INSERT INTO entrada_produto (`id_produto`,`qtde`,`valor_unitario`,`data_entrada`)VALUES(?,?,?,?);";
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setInt(1, objEntradaProdutoDTO.getId_produto());
            pstm.setInt(2, objEntradaProdutoDTO.getQtde());
            pstm.setDouble(3, objEntradaProdutoDTO.getValor_unitario());
            pstm.setDate(4, objEntradaProdutoDTO.getData_entrada());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Entrada Cadastrada com Sucesso!!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EntradaProdutoDAO: " + erro);
        }
    }

}
