package Service.Server;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.json.JavalinJackson;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.redoc.ReDocPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

import java.util.function.Consumer;

public class Servidor {

    private static Javalin app = null;

    public static Javalin app() {
        if (app == null) {
            throw new RuntimeException("App no inicializada");
        }
        return app;
    }

    public static void init() {
        if (app == null) {
            Integer port = Integer.parseInt(System.getProperty("port", "8080"));
            app = Javalin.create(config()).start(port);
            JavalinJackson.defaultMapper();
            Router.init();
        }
    }

    private static Consumer<JavalinConfig> config() {
        return config -> {

            // Configuración de OpenAPI con ruta personalizada para la documentación
            config.registerPlugin(new OpenApiPlugin(openApiPluginConfiguration -> {
                openApiPluginConfiguration.withDocumentationPath("/openapi");
                openApiPluginConfiguration.withDefinitionConfiguration((version, definition) ->
                        definition.withOpenApiInfo(openApiInfo -> {
                            openApiInfo.setTitle("DeccoSalud REST");
                            openApiInfo.setDescription(
                                    "<p>DeccoSalud, una extensión de DeccoColaboración para RESTcatar a las personas más vulnerables, " +
                                    "y brindar una salud social para una sociedad mejor.</p>" +
                                    "<center><img src='https://i.ibb.co/JqXrZmV/Captura.png' alt='Logo DeccoSalud' style='max-width: 300px;'/></center>" +
                                    "<p><marquee>Para más información, visita nuestro sitio web o consulta la documentación.</marquee></p>");
                            openApiInfo.contact("DeccoSalud@gmail.com");
                            openApiInfo.setVersion(version);
                        })
                );
            }));

            config.registerPlugin(new SwaggerPlugin());
            config.registerPlugin(new ReDocPlugin());

        };


    }
}
