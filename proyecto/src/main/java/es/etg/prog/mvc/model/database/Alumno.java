package es.etg.prog.mvc.model.database;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class Alumno {
    
    String nombre;
    String apellidos;
    int edad;

}
