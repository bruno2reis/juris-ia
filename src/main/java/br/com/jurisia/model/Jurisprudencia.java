package br.com.jurisia.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Jurisprudencia extends PanacheEntity {
    public String titulo;
    public String texto;
    public String tribunal;
    public String juiz;
    public String resultado;
}
