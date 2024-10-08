package Controller;

import Domain.Circuito;
import Domain.Persona;
import Domain.ResumenBarrio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.List;

public class CircuitoController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void obtenerResumenPedidos(Context ctx) {
        List<Persona> pedidos;
        try {
            pedidos = objectMapper.readValue(ctx.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, Persona.class));
        } catch (JsonProcessingException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.json("Error al procesar la entrada JSON: " + e.getMessage());
            return;
        }

        if (pedidos.isEmpty()) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.json("La lista de pedidos no puede estar vacía");
            return;
        }

        for (Persona persona : pedidos) {
            if (persona.getBarrios().isEmpty()) {
                ctx.status(HttpStatus.BAD_REQUEST);
                ctx.json("La lista de barrios no puede estar vacía para " + persona.getNombre());
                return;
            }
        }

        List<ResumenBarrio> resumen = Circuito.getInstance().procesarCircuito(pedidos);
        ctx.json(resumen);
    }
}
