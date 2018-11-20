/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venda;

import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.carrinho.CarrinhoComprasItem;
import modelo.produto.Produto;
import modelo.produto.ProdutoDAO;
import modelo.usuario.Usuario;

/**
 *
 * @author Davi
 */
public class ProdutoVendaDAO {

    public ProdutoVendaDAO() {
    }
    public List<ProdutoVenda> obterProdutoVenda(int id_venda) {
        List<ProdutoVenda> items = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id_produto, quantidade, preco_unitario FROM produto_venda WHERE id_venda = ?");
            preparedStatement.setInt(1, id_venda);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto produto = new ProdutoDAO().obter(resultSet.getInt("id_produto"));
                int quantidade = resultSet.getInt("quantidade");
                double precoUnitario = resultSet.getDouble("preco_unitario");
                items.add(new ProdutoVenda(produto, quantidade, precoUnitario));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return items;
    }

    public boolean inserir(int idVenda, Produto prod, int qtde, double precoUnitario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto_venda (id_venda, id_produto, quantidade, preco_unitario ) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, idVenda);
            preparedStatement.setInt(2, prod.getId());
            preparedStatement.setInt(3, qtde);
            preparedStatement.setDouble(4, precoUnitario);
            
            resultado = (preparedStatement.executeUpdate() > 0);
            
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    
    }
    
}
