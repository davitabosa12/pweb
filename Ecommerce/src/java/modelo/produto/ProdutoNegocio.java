/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

import java.util.List;

/**
 *
 * @author Davi
 */
public class ProdutoNegocio {
    ProdutoDAO dao;

    public ProdutoNegocio() {
        dao = new ProdutoDAO();
    }
    
    

    public boolean inserir(String descricao, double preco, int categoriaId) {
        return dao.inserir(descricao, preco, categoriaId);
    }

    public boolean alterar(int id, String descricao, double preco, int categoriaId) {
        return dao.alterar(id, descricao, preco, categoriaId);
    }

    public boolean excluir(int id) {
        return dao.excluir(id);
    }

    public Produto obter(int id) {
        return dao.obter(id);        
    }

    public List<Produto> obterTodos() {
        return dao.obterTodos();
    }
}
