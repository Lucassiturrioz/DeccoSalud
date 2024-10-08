package Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Persona {
    public List<String> getBarrios() {
        return barrios;
    }

    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("barrios")
    private List<String> barrios;

    public Persona() {
        barrios = new ArrayList<>();
    }




}
