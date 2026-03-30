package br.com.jurisia.repository;

import br.com.jurisia.model.Jurisprudencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class JurisprudenciaRepository implements PanacheRepository<Jurisprudencia> {

    public List<Jurisprudencia> buscarPorTexto(String texto) {
        return list("lower(texto) like ?1", "%" + texto.toLowerCase() + "%");
    }
}