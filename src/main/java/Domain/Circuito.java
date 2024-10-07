package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuito {

    private static Circuito circuito;

    public static Circuito getInstance(){
        if(circuito == null){
            circuito = new Circuito();
        } return circuito;
    }

    public List<ResumenBarrio> procesarCircuito(List<Persona> personas) {
        Map<String, ResumenBarrio> resumenMap = new HashMap<>();

        for (Persona persona : personas) {
            String nombre = persona.getNombre();
            List<String> barrios = persona.getBarrios();

            for (String barrio : barrios) {
                resumenMap.putIfAbsent(barrio, new ResumenBarrio(barrio));
                ResumenBarrio resumenBarrio = resumenMap.get(barrio);
                resumenBarrio.agregarPersona(nombre);
            }
        }

        return new ArrayList<>(resumenMap.values());
    }



}
