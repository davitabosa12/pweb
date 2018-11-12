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
    
    public boolean inserir(String descricao, double preco, int categoriaId, String imgPath){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (descricao, preco, categoria_id, img) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, categoriaId);
            preparedStatement.setString(4, imgPath);
            
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public boolean alterar(int id, String descricao, double preco, int categoriaId, String imgPath){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao = ?, preco = ?, categoria_id = ?, img = ? WHERE id = ?");
            
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, categoriaId);
            preparedStatement.setString(4, imgPath);
            preparedStatement.setInt(5, id);
            
            
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
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, descricao, preco, categoria_id, img FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setImgPath(resultSet.getString("img"));
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
            ResultSet resultSet = statement.executeQuery("SELECT id, descricao, preco, categoria_id, img FROM produto");
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoriaId(resultSet.getInt("categoria_id"));
                produto.setImgPath(resultSet.getString("img"));
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
    /**
     * Obtem varios produtos ordenados por ID
     * @param num numero de produtos para serem obtidos
     * @return lista de produtos
     */
    public List<Produto> obterVarios(int num){
        List<Produto> resultado = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement stmt = connection.prepareCall("SELECT id, descricao, preco, categoria_id, img FROM produto ORDER BY id FETCH FIRST ? ROWS ONLY");
            stmt.setInt(1, num);            
            
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoriaId(resultSet.getInt("categoria_id"));
                produto.setImgPath(resultSet.getString("img"));
                resultado.add(produto);
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
        return resultado;
    }
    /**
     * Obtem varios produtos ordenados por ID
     * @param skip numero de produtos para saltar
     * @param num numero de produtos para serem obtidos
     * @return lista de produtos
     */
    public List<Produto> obterVarios(int skip, int num){
        List<Produto> resultado = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement stmt = connection.prepareCall("SELECT id, descricao, preco, categoria_id, img FROM produto ORDER BY id OFFSET ? ROWS FETCH FIRST ? ROWS ONLY");
            stmt.setInt(1, skip);            
            stmt.setInt(2, num);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(resultSet.getString("id")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoriaId(resultSet.getInt("categoria_id"));
                produto.setImgPath(resultSet.getString("img"));
                resultado.add(produto);
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
        return resultado;
    }
}
