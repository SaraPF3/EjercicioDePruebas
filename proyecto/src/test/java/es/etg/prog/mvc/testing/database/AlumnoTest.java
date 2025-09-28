package es.etg.prog.mvc.testing.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import es.etg.prog.mvc.model.database.Alumno;
import es.etg.prog.mvc.model.database.AlumnosDAO;


@ExtendWith (MockitoExtension.class)
public class AlumnoTest {


    @Mock
    AlumnosDAO alumnosDAO;



    @Test
    public void testValoresAlumno()
    {

        Alumno alumno = new Alumno("Pedro", "Pérez", 52);
        assertEquals("Pedro", alumno.getNombre());
        assertEquals("Pérez", alumno.getApellidos());
        assertEquals(52, alumno.getEdad());
    }


    @Test
    public void testInsertarAlumno(){

        Alumno alumno = new Alumno("Pedro", "Pérez", 52);
        alumnosDAO.insertar(alumno);
        verify(alumnosDAO).insertar(alumno);

        when(alumnosDAO.listar()).thenReturn(Arrays.asList(alumno));

        List<Alumno> lista = alumnosDAO.listar();
        assertTrue(lista.contains(alumno));
    }

     @Test
    public void testListarAlumnos() {

        Alumno alumno1 = new Alumno("Pedro", "Pérez", 52);
        Alumno alumno2 = new Alumno("Ana", "Gómez", 20);


        List<Alumno> lista = new ArrayList<>();
        lista.add(alumno1);
        lista.add(alumno2);

        when(alumnosDAO.listar()).thenReturn(lista);

        List<Alumno> resultado = alumnosDAO.listar();
        assertTrue(resultado.contains(alumno1));
        assertTrue(resultado.contains(alumno2));
    }

    
}
