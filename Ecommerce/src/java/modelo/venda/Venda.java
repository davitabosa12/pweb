/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venda;

import java.util.List;
import modelo.produto.Produto;
import modelo.usuario.Usuario;

/**
 *
 * @author aluno
 */
public class Venda {
    private Usuario usuario;
    private List<ProdutoVenda> produtos;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Venda() {
    }

    public Venda(Usuario usuario, List<ProdutoVenda> produtos, int id) {
        this.usuario = usuario;
        this.produtos = produtos;
        this.id = id;
    }



    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }
    
    public double getGrandeTotal(){
        double soma = 0;
        for(ProdutoVenda p : produtos){
            soma += p.getPrecoUnitario() * p.getQuantidade();
        }
        return soma;
    }

   
    
    
    
}
