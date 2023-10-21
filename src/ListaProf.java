import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaProf {

    Profesor[] profesores;
    int sizeP;

    public ListaProf(){
        sizeP = validarTamano();
        this.profesores = new Profesor[sizeP];
        for (int i = 0; i < sizeP; i ++) {
            profesores[i] = new Profesor();

        }


    }


    public int validarTamano(){
        String nombreArchivo = "archivos/cargaProf.txt";
        int sizeL = 0;
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


    public void cargarProf(ListaMat materias){
        String nombreArchivo = "archivos/cargaProf.txt",nombre,id,genero,tel;
        //para guardar los numeros de las materias
        int codM1, codM2, codM3;
        Materia m1,m2,m3;
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            int i = 0;
            while((linea = lector.readLine()) != null){
                String[] partes = linea.split(",");
                if(partes.length == 7){
                    nombre = partes[0];
                    id = partes[1];
                    genero = partes[2];
                    tel = partes[3];
                    codM1 = Integer.parseInt(partes[4]);
                    m1 = materias.getMaterias()[codM1];
                    codM2 = Integer.parseInt(partes[5]);
                    m2 = materias.getMaterias()[codM2];
                    codM3 = Integer.parseInt(partes[6]);
                    System.out.println(codM1+codM2+codM3);
                    m3 = materias.getMaterias()[codM3];
                    Profesor profesor = new Profesor(m1,m2,m3);
                    profesor.setNombre(nombre);
                    profesor.setiD(id);
                    profesor.setGenero(genero);
                    profesor.setTel(tel);
                    this.profesores[i] = profesor;
                    i ++;

                }
            }


        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

        //return profesores;
    }

    public void mostrarTodoslosprofesores(){
        String mensaje = "Lista profesores: \n";
        for (int i = 0; i < sizeP; i++){
            mensaje +=  "Nombre: " +profesores[i].getNombre() + " Identificacion: "+ profesores[i].getiD()+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }



}
