package es.etg.prog.mvc.model.database;

import java.util.ArrayList;
import java.util.List;

public class AlumnosDAOImpl implements AlumnosDAO {

    private final List<Alumno> alumnos = new ArrayList<>();

    @Override
    public void insertar(Alumno alumno){
        alumnos.add(alumno);    
    }

    @Override
    public List<Alumno> listar(){
        return new ArrayList<>(alumnos);
    }
}
