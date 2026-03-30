package br.com.jurisia.resource;

import br.com.jurisia.model.Jurisprudencia;
import br.com.jurisia.service.JurisprudenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/jurisprudencia")
@Consumes("application/json")
@Produces("application/json")
public class JurisprudenciaResource {
    @Inject
    JurisprudenciaService service;

    @GET
    @Path("/buscar")
    public Map<String, Object> buscar(@QueryParam("texto") String texto) {

        List<Jurisprudencia> casos = service.buscar(texto);

        double chance = service.calcularChance(casos);

        Map<String, Object> response = new HashMap<>();
        response.put("casos", casos);
        response.put("chance", chance);

        return response;
    }
}
