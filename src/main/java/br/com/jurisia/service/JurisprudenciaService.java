package br.com.jurisia.service;

import br.com.jurisia.model.Jurisprudencia;
import br.com.jurisia.repository.JurisprudenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class JurisprudenciaService {

    @Inject
    JurisprudenciaRepository repository;

    public List<Jurisprudencia> buscar(String texto) {
        return repository.buscarPorTexto(texto);
    }

    public double calcularChance(List<Jurisprudencia> casos) {

        if (casos.isEmpty()) return 0;

        long favoraveis = casos.stream()
                .filter(c -> "FAVORAVEL".equalsIgnoreCase(c.resultado))
                .count();

        return (favoraveis * 100.0) / casos.size();
    }
}

