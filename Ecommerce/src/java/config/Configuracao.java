/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que representa os elementos de configuração da aplicação
 */
public final class Configuracao {
        

    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/pweb1";
    public static final String JDBC_USUARIO = "teste"; //mudar para postgres quando estiver na UFC
    public static final String JDBC_SENHA = "ufc123";

    private Configuracao() {
        
    }
}
