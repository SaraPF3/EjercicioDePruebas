package es.etg.prog.mvc.view;

import java.util.Scanner;

import es.etg.prog.mvc.model.database.Alumno;
import es.etg.prog.mvc.model.database.AlumnosDAOImpl;

public class AlumnoView {

    public static final String TXT_PEDIR_NOMBRE_ALUMNO = "Introduzca el nombre del alumno: ";
    public static final String TXT_PEDIR_APELLIDOS_ALUMNO = "Introduzca los apellidos del alumno: ";
    public static final String TXT_PEDIR_EDAD_ALUMNO = "Introduzca la edad del alumno: ";
    public static final String TXT_INSERTAR_ALUMNO = ". Insertar alumno";
    public static final String TXT_LISTAR_ALUMNOS = ". Listar alumnos";
    public static final String TXT_SALIR = ". Salir";
    public static final String TXT_OPCION_INVALIDA = "Opción inválida";
    public static final String TXT_LISTADO_ALUMNOS = "Listado de alumnos:";
    public static final String TXT_ALUMNO_INSERTADO = "Alumno insertado";
    public static final String TXT_SALIENDO_MENU = "Saliendo del menú";

    public static final int INSERTAR_ALUMNO = 1;
    public static final int LISTAR_ALUMNOS = 2;
    public static final int SALIR = 3;

    Scanner sc = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    private int edad;
    AlumnosDAOImpl alumnosDAOImp = new AlumnosDAOImpl();



    public void menuGestionarAlumnos(){
        while (true) {

            System.out.println(INSERTAR_ALUMNO + TXT_INSERTAR_ALUMNO);
            System.out.println(LISTAR_ALUMNOS + TXT_LISTAR_ALUMNOS);
            System.out.println(SALIR + TXT_SALIR);
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case INSERTAR_ALUMNO:

                    System.out.println(TXT_PEDIR_NOMBRE_ALUMNO);
                    nombre = sc.nextLine();

                    System.out.println(TXT_PEDIR_APELLIDOS_ALUMNO);
                    apellidos = sc.nextLine();

                    System.out.println(TXT_PEDIR_EDAD_ALUMNO);
                    edad = Integer.parseInt(sc.nextLine());

                    alumnosDAOImp.insertar(new Alumno(nombre, apellidos, edad));
                    System.out.println(TXT_ALUMNO_INSERTADO);
                break;

                case LISTAR_ALUMNOS:
                    System.out.println(TXT_LISTADO_ALUMNOS + "\n" + alumnosDAOImp.listar());
                break;

                case SALIR:
                    System.out.println(TXT_SALIENDO_MENU);
                    return;

                default: System.out.println(TXT_OPCION_INVALIDA);
            }
        }

    }
}
