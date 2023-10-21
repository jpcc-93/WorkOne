import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaAlum {

    Alumno[] alumnos;
    int sizeL;

    public ListaAlum() {
        sizeL = validarTamano();
        this.alumnos = new Alumno[sizeL];
        ListaMat materias = new ListaMat();

        for (int i = 0; i < sizeL; i ++) {
            alumnos[i] = new Alumno(materias.getMaterias());
        }
    }

// se usa para validar la cantidad de datos que contiene el archivo plano
    public int validarTamano(){
        String nombreArchivo = "archivos/carga.txt";
        sizeL = 0;
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            while((lector.readLine()) != null){
                sizeL ++;

            }

        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

        return sizeL;
    }

    public void cargarCurso(ListaMat materias){

        String nombreArchivo = "archivos/carga.txt";

        String nombres = "";
        float promedio = 0;
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            int i = 0;
            while((linea = lector.readLine()) != null){
                String[] partes = linea.split(",");
                if(partes.length == 14){

                    Alumno alumno = new Alumno(materias.getMaterias());

                    alumno.setNombre(partes[0]);
                    alumno.setiD(partes[1]);
                    alumno.setGenero(partes[2]);
                    alumno.setTel(partes[3]);
//                    System.out.println(alumno.getNombre() +" Notas: ");
                    for(int j = 4,k = 0; j < 14 ; j++, k++){

                        alumno.setMaterias(partes[j], k);
//                            System.out.println("j = " + j + " k = " + k);
//                            System.out.println(alumno.getMaterias(k));
                        alumno.setPromedio(alumno.getPromedio() + Float.parseFloat(partes[j]));

                    }

                    alumno.setPromedio(alumno.getPromedio()/10);

                    this.alumnos[i] = alumno;


                    nombres += (this.alumnos[i].getNombre()) + "\n";

                    i ++;

                }


            }

        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

    }

    public void mostrarTodoslosalumnos(){
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            mensajeAlumnos +=  "Nombre: " +alumnos[i].getNombre() + " Identificacion: "+ alumnos[i].getiD()+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);
    }

    public void mostrarHganan(){
        String mensajeAlumnos = "Lista estudiantes hombres que ganan: \n";
        for (int i = 0; i < sizeL; i++){
            System.out.println(alumnos[i].getPromedio());
            if(alumnos[i].getPromedio() >= 3 && alumnos[i].getGenero().equals("M")) {
                mensajeAlumnos += "\nNonbre: " + alumnos[i].getNombre() + " Identificacion: " +
                        alumnos[i].getiD() + "\n" + "Promedio: " + String.format("%.2f",alumnos[i].getPromedio());
            }
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);

    }

    public void mostrarFganan(){
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            System.out.println(alumnos[i].getPromedio());
            if(alumnos[i].getPromedio() >= 3 && alumnos[i].getGenero().equals("F")) {
                mensajeAlumnos += "\nNonbre: " + alumnos[i].getNombre() + " Identificacion: " +
                        alumnos[i].getiD() + "\n" + "Promedio: " + String.format("%.2f",alumnos[i].getPromedio());
            }
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);

    }
    public void mostrarpromedio38(){
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            System.out.println(alumnos[i].getPromedio());
            if(alumnos[i].getPromedio() >= 3.8 ) {
                mensajeAlumnos += "\nNonbre: " + alumnos[i].getNombre() + " Identificacion: " +
                        alumnos[i].getiD() + "\n" + "Promedio: " + String.format("%.2f",alumnos[i].getPromedio());
            }
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);
    }
    public void buscar(){
        float opcion = 0;
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < sizeL; i++){
            mensajeAlumnos +=  "Nonbre: " +alumnos[i].getNombre() + " Identificacion: "+ alumnos[i].getiD()+ "\n" ;
        }
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,mensajeAlumnos));
        for (int i = 0; i < sizeL; i++){
            if (opcion == Float.parseFloat(alumnos[i].getiD())){
                alumnos[i].mostrarnotas();
            }
        }
    }
}
