package Service.Server;

import Controller.CircuitoController;
import Domain.Persona;
import io.javalin.openapi.*;

@OpenApi(
        description = "Obtener resumen de la semana",
        summary = "Resumen de pedidos agrupados barrios",
        operationId = "obtenerResumenPedidos",
        path = "/pedidos",
        methods = io.javalin.openapi.HttpMethod.POST,
        tags = {"Pedidos"},
        requestBody = @OpenApiRequestBody(
                content = @OpenApiContent(
                        mimeType = "application/json",
                        from = Persona.class,
                        example = "[\n" +
                                "  {\n" +
                                "    \"nombre\": \"lucas iturrioz\",\n" +
                                "    \"barrios\": [\"almagro\", \"palermo\"]\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"nombre\": \"pepito luis\",\n" +
                                "    \"barrios\": [\"belgrano\", \"almagro\"]\n" +
                                "  }\n" +
                                "]"
                )
        )

)
public class Router {
    public static void init() {
        Servidor.app().get("/", context -> context.redirect("/swagger"));

        CircuitoController pedidoController = new CircuitoController();
        Servidor.app().post("/pedidos", pedidoController::obtenerResumenPedidos);
    }
}
