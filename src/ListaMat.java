import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaMat {



    Materia[] materias;
    int sizeM;


    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    public ListaMat(){
        sizeM = validarTamano();
        this.materias = new Materia[sizeM];
        for (int i= 0; i<sizeM;i++){
            materias[i] = new Materia();
        }
    }




    public  Materia[] cargarMaterias() {
        int sizeM = validarTamano();
        String nombreArchivo = "archivos/cargaMaterias.txt";
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    Materia materia = new Materia();
                    materia.setCodigoMateria(Integer.parseInt(partes[0]));
                    materia.setNombre(partes[1]);
                    materia.setDescripcion(partes[2]);
                    materia.setNota(Float.parseFloat(partes[3]));
                    materias[i] = materia;
                    i++;
                }

            }
        } catch (IOException e) {
            System.err.println("Error al cargar materias desde archivo: " + e.getMessage());
        }
        return materias;

    }

    public static int validarTamano(){
        String nombreArchivo = "archivos/cargaMaterias.txt";
        int i = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((lector.readLine()) != null) {
                    i++;
            }
        } catch (IOException e) {
            System.err.println("Error al cargar materias desde archivo: " + e.getMessage());
        }

        return i;
    }


    public void mostrarTodasLasMaterias(){
        String mensaje = "Las materias son: \n ";
        for (int i = 0; i < sizeM; i ++){
            mensaje +=  "Nombre: " +materias[i].getNombre() + " Codigo: "+ materias[i].getCodigoMateria()+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,mensaje);

    }
}
