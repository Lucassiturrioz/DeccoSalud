package Service.Server;


import Controller.CircuitoController;

public class Router {
    public static void init(){
        Server.app().get("/",context -> context.result("Bienvenido a DeccoSalud!"));

        CircuitoController pedidoController = new CircuitoController();
        Server.app().post("/pedidos", pedidoController::obtenerResumenPedidos);

    }

}
