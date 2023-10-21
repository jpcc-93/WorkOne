import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaMat {




    public static Materia[] cargarMaterias() {
        int sizeM = validarTamano();
        String nombreArchivo = "archivos/cargaMaterias.txt";
        Materia[] materias = new Materia[sizeM];
        String nombres = "";
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
                    nombres += materia.getCodigoMateria() + " " + materia.getNombre() + "\n";
                    i++;
                }

            }
//            JOptionPane.showMessageDialog(null, nombres);

        } catch (IOException e) {
            System.err.println("Error al cargar materias desde archivo: " + e.getMessage());
        }
        return materias;

    }

    public static int validarTamano(){
        String nombreArchivo = "archivos/cargaMaterias.txt";
        int i = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    i++;
                }
                else{System.err.println("Datos mal cargados en archivo.");}

            }
//            JOptionPane.showMessageDialog(null, nombres);

        } catch (IOException e) {
            System.err.println("Error al cargar materias desde archivo: " + e.getMessage());
        }

        return i;
    }
}
