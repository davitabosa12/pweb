/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.carrinho;

import com.google.gson.Gson;
import modelo.produto.Produto;

/**
 *
 * @author aluno
 */
public class CarrinhoComprasItem {
    private int quantidade;
    private Produto produto;

    public CarrinhoComprasItem() {
    }

    public CarrinhoComprasItem(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }
}
