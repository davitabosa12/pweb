/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.carrinho;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;

/**
 *
 * @author aluno
 */
public class CarrinhoCompras {

    private List<CarrinhoComprasItem> itens;

    public CarrinhoCompras() {
        itens = new ArrayList<>();
    }

    public static CarrinhoCompras fromCookieArray(Cookie[] cookies) {
        Cookie carrinhoCookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("ecommerce.carrinho")) {
                carrinhoCookie = c;
                break;
            }
        }
        if (carrinhoCookie == null) {
            return new CarrinhoCompras();
        }

        CarrinhoCompras c;
        String carrinhoCookieJSON = carrinhoCookie.getValue();
        try{
            c = new Gson().fromJson(carrinhoCookieJSON, CarrinhoCompras.class);
        } catch (JsonSyntaxException ex){
            ex.printStackTrace();
            return new CarrinhoCompras();
        }
        
        return c;

    }


public void adicionarItem(CarrinhoComprasItem item){
    System.out.println("modelo.carrinho.CarrinhoCompras.adicionarItem()");
    boolean itemIgual = false;
        for(CarrinhoComprasItem item2 : itens){
              if(item.getProduto().getId()== item2.getProduto().getId()){ 
                  item2.setQuantidade(item2.getQuantidade() + item.getQuantidade());
                  itemIgual = true;
                  System.out.println("      Combinando Itens iguais!");
                  break;
              }
        }
        if(!itemIgual){
            System.out.println("      Item unico!");
            itens.add(item);
        }
        
        
    }

    public List<CarrinhoComprasItem> getItens() {
        return itens;
    }
    
    @Override
        public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);        
    }

    private void combinarProdutosIguais() {

        for(CarrinhoComprasItem item : itens){
            for(CarrinhoComprasItem item2 : itens){
                if(item.getProduto().equals(item2.getProduto())){
                    //combine e deletar
                    int item2_qtde = item2.getQuantidade();
                    item.setQuantidade(item.getQuantidade() + item2_qtde);
                    itens.remove(item2);
                }
            }
            
        }
    }
}
