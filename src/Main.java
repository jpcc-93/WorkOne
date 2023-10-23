import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        String menu = "1. Mostrar alumnos del curso \n" +
                      "2. Mostrar profesores \n" +
                      "3. Mostrar materias \n"+
                      "4. Mostrar alumnos que ganan todas las materias \n"+
                      "5. Mostrar alumnas que ganan todas las materias \n"+
                      "6. Promedio de notas mayor a 3.8 \n"+
                      "7. Mostrar alumno indicado";



        int opcion = 0;
        float ccbuscar;
        ListaMat materias = new ListaMat();
        ListaAlum alumnos = new ListaAlum();
        ListaProf profesores = new ListaProf();
        materias.cargarMateriasN();
        alumnos.cargarCursoN(materias);
        profesores.cargarProfN(materias);


        //profesores.cargarProf(materias);
        System.out.println("carga ok");


        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion){
                case 1: alumnos.mostrarTodoslosalumnosN();
                    break;
                case 2: profesores.mostrarTodoslosprofesoresN();
                    break;
                case 3: materias.mostrarTodasLasMateriasN();
                    break;
                case 4: alumnos.mostrarHgananN();
                    break;
                case 5: alumnos.mostrarFgananN();
                    break;
                case 6: alumnos.mostrarpromedio38N();
                    break;
                case 7: alumnos.buscarN();
                    break;
                case 0:
                    opcion = 0;
                    break;


            }

        }while(opcion != 0);

        System.out.println("todo bien");

    }


}