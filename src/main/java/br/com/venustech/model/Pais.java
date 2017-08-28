package br.com.venustech.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by vinny on 28/08/17.
 */
@Entity
public class Pais extends AbstractModel<Long> {
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 3)
    private String sigla;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
