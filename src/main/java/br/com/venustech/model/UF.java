package br.com.venustech.model;

import javax.persistence.Column;

/**
 * Created by vinny on 28/08/17.
 */
public class UF extends AbstractModel {
    @Column()
    int codigo;

    @Column(nullable = false, length = 40)
    private String nome;

    private Pais pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
