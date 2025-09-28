package es.etg.prog.mvc.model.database;

import java.util.List;

public interface AlumnosDAO {
    void insertar(Alumno alumno);
    List<Alumno> listar();
    
}