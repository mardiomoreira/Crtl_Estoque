/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mardio
 */
public class Conexao {

    String caminho, nome;
    String username, senha, servidor, bancoDados;

    public Connection conexaoBD() {
        ArrayList lista = new ArrayList<>();
        //LEITURA DO ARQUIVO DE CONFIGURAÇÃO

        try {
            String caminho = Conexao.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            caminho = caminho.substring(1, caminho.lastIndexOf('/') + 1);
            nome = "/" + caminho + "config.inc";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                lista.add(linha);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            servidor = lista.get(0).toString();
            username = lista.get(1).toString();
            senha = lista.get(2).toString();
            bancoDados = lista.get(3).toString();
            /*
            JOptionPane.showMessageDialog(null,"Servidor: "+servidor);
            JOptionPane.showMessageDialog(null,"usuario: "+username);
            JOptionPane.showMessageDialog(null,"Senha: "+senha);
            JOptionPane.showMessageDialog(null,"Banco: "+bancoDados);
            */
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //ESTABELECENDO A CONEXÃO
        Connection conn = null;
        try {
            String url = "jdbc:mysql://"+servidor+":3306/"+bancoDados+"?user="+username+"&password="+senha+"";
            conn = DriverManager.getConnection(url);
            //JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!!!");
        } catch (Exception erro) {

            System.out.println("Conexao:" + erro.getMessage());
        }
        return conn;

    }
}
