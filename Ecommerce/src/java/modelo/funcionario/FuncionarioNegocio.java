/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funcionario;

import java.util.List;

/**
 *
 * @author Davi
 */
public class FuncionarioNegocio {
    
    public boolean efetuarLogin(String login, String senha) {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.obterFuncionario(login);
        return (funcionario != null && funcionario.getSenha().equals(senha));
    }

    
    public boolean inserir(String nome, String login, String senha, double salario) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.inserir(nome, login, senha, salario);
    }

    public Funcionario obterFuncionario(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.obterFuncionario(login);
    }

    public List<Funcionario> obterTodos() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.obterTodos();
    }

    public boolean alterar(String nome, String login, String senha, double salario) {
       FuncionarioDAO dao = new FuncionarioDAO();
       return dao.alterar(login, nome, senha, salario);
    }

    public boolean excluir(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.excluir(login);
    }
    
}
