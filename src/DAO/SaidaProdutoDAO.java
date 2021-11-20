/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SaidaProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class SaidaProdutoDAO {
        public void CadastrarSaidaProduto(SaidaProdutoDTO objSaidaProdutoDTO) {
            Connection Conn;
            PreparedStatement pstm;
        String sql;
        Conn = new Conexao().conexaoBD();
        sql = "INSERT INTO saida_produto (`id_produto`,`qtde`,`valor_unitario`,`data_saida`)VALUES(?,?,?,?);";
        try {
            pstm = Conn.prepareStatement(sql);
            pstm.setInt(1, objSaidaProdutoDTO.getId_produto());
            pstm.setInt(2, objSaidaProdutoDTO.getQtde());
            pstm.setDouble(3, objSaidaProdutoDTO.getValor_unitario());
            pstm.setDate(4, objSaidaProdutoDTO.getData_saida());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Saída Cadastrada com Sucesso!!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "SaidaProdutoDAO: " + erro);
        }
    }
}
