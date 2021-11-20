/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RelatorioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mardio
 */
public class RelatoriosDAO {
        ArrayList<RelatorioDTO> listaRelatorioDTO = new ArrayList<>();
        Connection Conn;
        PreparedStatement pstm;
        ResultSet rs;

    public ArrayList<RelatorioDTO> PesquisaRelatorio() {
        String sql = "SELECT produto.descricao, SUM(estoque.qtde) AS qtdEstoque FROM produto INNER JOIN estoque ON produto.id = estoque.id_produto GROUP BY estoque.id_produto;";
        Conn = new Conexao().conexaoBD();
        try {
            pstm = Conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                RelatorioDTO objRelatorioDTO = new RelatorioDTO();
                    objRelatorioDTO.setDescricao(rs.getString("descricao"));
                    objRelatorioDTO.setQtdEstoque(rs.getInt("qtdEstoque"));
                    listaRelatorioDTO.add(objRelatorioDTO);
            }
        } catch (Exception e) {
        }
        return listaRelatorioDTO;
    }

}
