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
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO;

/**
 *
 * @author aluno
 */
public class VendaDAO {

    public VendaDAO() {
    }
    public Venda obterVenda(int id_venda) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Venda venda = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, cliente_login FROM venda WHERE id = ?");
            preparedStatement.setInt(1, id_venda);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda = new Venda();
                venda.setId(resultSet.getInt("id"));
                venda.setUsuario(usuarioDao.obterUsuario(resultSet.getString("cliente_login")));
                venda.setProdutos(new ProdutoVendaDAO().obterProdutoVenda(id_venda));                
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return venda;
    }
    
    public List<Venda> obterVendaPorUsuario(String login){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Venda> vendas = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, cliente_login FROM venda WHERE cliente_login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Venda venda = new Venda();
                venda.setId(resultSet.getInt("id"));
                venda.setUsuario(usuarioDao.obterUsuario(resultSet.getString("cliente_login")));
                venda.setProdutos(new ProdutoVendaDAO().obterProdutoVenda(venda.getId()));                
                vendas.add(venda);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return vendas;
    }
    
    public boolean inserirVenda(Venda venda){
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda (cliente_login) VALUES (?) RETURNING id");
            preparedStatement.setString(1, venda.getUsuario().getLogin());
            
            //resultado = (preparedStatement.executeUpdate() > 0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idVenda = resultSet.getInt("id");
                ProdutoVendaDAO produtoVendaDAO = new ProdutoVendaDAO();
                boolean res2 = false;
                for(ProdutoVenda pv : venda.getProdutos()){
                    res2 = produtoVendaDAO.inserir(idVenda, pv.getProduto(), pv.getQuantidade(), pv.getPrecoUnitario());
                    if(!res2){
                        break;
                    }
                }
                if(!res2){
                    resultado = false;
                } else {
                    resultado = true;
                }
                
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
}
