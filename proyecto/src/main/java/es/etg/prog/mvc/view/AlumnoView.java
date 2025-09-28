package es.etg.prog.mvc.view;

import java.util.Scanner;

import es.etg.prog.mvc.model.database.Alumno;
import es.etg.prog.mvc.model.database.AlumnosDAOImp;

public class AlumnoView {

    public static final String PEDIR_NOMBRE_ALUMNO = "Introduzca el nombre del alumno: ";
    public static final String PEDIR_APELLIDOS_ALUMNO = "Introduzca los apellidos del alumno: ";
    public static final String PEDIR_EDAD_ALUMNO = "Introduzca la edad del alumno: ";
    public static final String TXT_INSERTAR_ALUMNO = ". Insertar alumno";
    public static final String TXT_LISTAR_ALUMNOS = ". Listar alumnos";
    public static final String TXT_SALIR = ". Salir";


    public static final int INSERTAR_ALUMNO = 1;
    
    public static final int LISTAR_ALUMNOS = 2;
    public static final int SALIR = 3;

    Scanner sc = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    private int edad;
    AlumnosDAOImp alumnosDAOImp = new AlumnosDAOImp();



    public void menuGestionarAlumno(){
        while (true) {

            System.out.println(INSERTAR_ALUMNO + TXT_INSERTAR_ALUMNO);
            System.out.println(LISTAR_ALUMNOS + TXT_LISTAR_ALUMNOS);
            System.out.println(SALIR + TXT_SALIR);
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case INSERTAR_ALUMNO:

                    System.out.println(PEDIR_NOMBRE_ALUMNO);
                    nombre = sc.nextLine();

                    System.out.println(PEDIR_APELLIDOS_ALUMNO);
                    apellidos = sc.nextLine();

                    System.out.println(PEDIR_EDAD_ALUMNO);
                    edad = Integer.parseInt(sc.nextLine());

                    alumnosDAOImp.insertar(new Alumno(nombre, apellidos, edad));
                    System.out.println("Alumno insertado.");
                break;

                case LISTAR_ALUMNOS:
                    System.out.println("""
                                       Listado de alumnos:
                                       """ + alumnosDAOImp.listar());
                break;

                case SALIR:
                    System.out.println("Saliendo...");
                    return;

                default: System.out.println("Opción inválida.");
            }
        }

    }
}
