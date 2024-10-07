package Service.Server;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;
import io.javalin.json.JsonMapper;
import io.javalin.rendering.JavalinRenderer;

import java.io.IOException;
import java.util.function.Consumer;

public class Server {
    public static final String baseUrl = "localhost:8080";
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
            new Router().init();
        }
    }

    private static Consumer<JavalinConfig> config() {
        return config -> {
            // Configuración de CORS
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost(); // Permitir todas las solicitudes de cualquier origen (cuidado en producción)
                });
            });

        };
    }



}