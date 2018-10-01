package modelo.produto;

import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.produto.Produto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */
public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    public boolean inserir(String descricao, double preco, int categoriaId){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (descricao, preco, categoria_id) VALUES (?, ?, ?)");
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, categoriaId);
            
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public boolean alterar(int id, String descricao, double preco, int categoriaId){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao = ?, preco = ?, categoria_id = ? WHERE id = ?");
            
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, categoriaId);
            preparedStatement.setInt(4, id);
            
            
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return resultado;
    }
    
    public boolean excluir(int id){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public Produto obter(int id){
        Produto produto = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, descricao, preco, categoria_id FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoriaId(resultSet.getInt("categoria_id"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return produto;
    }
    
    public List<Produto> obterTodos(){
        List<Produto> resultado = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, descricao, preco, categoria_id FROM produto");
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoriaId(resultSet.getInt("categoria_id"));
                resultado.add(produto);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
        return resultado;
    }
}
