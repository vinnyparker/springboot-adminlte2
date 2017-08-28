package br.com.venustech.model;

import javax.persistence.Column;

/**
 * Created by vinny on 28/08/17.
 */
public class Condominio extends AbstractModel {
    @Column(nullable = false, length = 250)
    String nome;

    @Column(length = 14)
    String cnpj;

    @Column(length = 100)
    String endereco;

    @Column()
    int numero;

    @Column(length = 50)
    String complemento;

    @Column(length = 50)
    String bairro;

    @Column(nullable = true)
    int cep;


}
