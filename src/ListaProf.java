import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaProf {

    private Profesor cabeza;


    public ListaProf(){
        cabeza = null;

    }

    public void cargarProfN(ListaMat materias){
        String nombreArchivo = "archivos/cargaProf.txt";
        //para guardar los numeros de las materias

        Profesor anterior = new Profesor();
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            int i = 0;
            while((linea = lector.readLine()) != null){
                String[] partes = linea.split(",");
                if(partes.length == 7){
                    Profesor profesor = new Profesor();
                    profesor.setNombre(partes[0]);
                    profesor.setiD(partes[1]);
                    profesor.setGenero(partes[2]);
                    profesor.setTel(partes[3]);
                    profesor.setM1(materias.getMateriasN(Integer.parseInt(partes[4])));
                    profesor.setM2(materias.getMateriasN(Integer.parseInt(partes[5])));
                    profesor.setM3(materias.getMateriasN(Integer.parseInt(partes[6])));
                    if(i == 0){
                        cabeza = profesor;
                    }else{
                        anterior.setLiga(profesor);
                    }
                    anterior = profesor;
                    i ++;

                }
            }


        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

        //return profesores;
    }


    public void mostrarTodoslosprofesoresN(){
        Profesor aux = cabeza;
        String mensaje = "Lista profesores: \n";
        while (aux != null){
            mensaje +=  "Nombre: " +aux.getNombre() + " Identificacion: "+ aux.getiD()+ "\n" ;
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }



}
