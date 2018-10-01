/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.categoria;

import java.util.List;

/**
 *
 * @author Davi
 */
public class CategoriaNegocio {
    private CategoriaDAO dao;
    public CategoriaNegocio(){
        dao = new CategoriaDAO();
    }
    public boolean alterar(int id, String descricao) {
        return dao.alterar(id, descricao);
    }

    public boolean excluir(int id) {
        return dao.excluir(id);
    }

    public boolean inserir(String descricao) {
        return dao.inserir(descricao);
    }

    public Categoria obter(int id) {
        return dao.obter(id);
    }

    public List<Categoria> obterTodos() {
        return dao.obterTodos();
    }
}
