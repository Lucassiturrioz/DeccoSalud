package Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ResumenBarrio {
    @JsonProperty
    private String barrio;
    @JsonProperty
    private int cantidadPersonas;
    @JsonProperty
    private List<String> personas;

    public void agregarPersona(String nombre) {
        personas.add(nombre);
        cantidadPersonas++;
    }

    public ResumenBarrio(String barrio) {
        this.barrio = barrio;
        this.personas = new ArrayList<>();
    }

}
