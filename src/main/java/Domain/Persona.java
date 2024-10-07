package Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("barrios")
    private List<String> barrios;

    public Persona() {
        barrios = new ArrayList<>();
    }
}
