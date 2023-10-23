import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaMat {

    private Materia cabeza;

    public ListaMat(){
        cabeza = null;
    }


    public Materia getMateriasN(int codigo) {
        Materia aux = cabeza;
        Materia auxCop = new Materia();
        while (aux != null){
            if(aux.getCodigoMateria() == codigo){
                auxCop.setLiga(aux.getLiga());
                auxCop.setNota(aux.getNota());
                auxCop.setDescripcion(aux.getDescripcion());
                auxCop.setNombre(aux.getNombre());
                auxCop.setCodigoMateria(aux.getCodigoMateria());
                break;
            }
            aux = aux.getLiga();
        }
        return auxCop;
    }


    public Materia getCabeza() {
        return cabeza;
    }

    public void setCabeza(Materia cabeza) {
        this.cabeza = cabeza;
    }

    public  void cargarMateriasN() {
        Materia anterior = null;
        String nombreArchivo = "archivos/cargaMaterias.txt";
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                Materia materia = new Materia();
                if (partes.length == 4) {
                    materia.setCodigoMateria(Integer.parseInt(partes[0]));
                    materia.setNombre(partes[1]);
                    materia.setDescripcion(partes[2]);
                    materia.setNota(Float.parseFloat(partes[3]));
                }
                if(cabeza == null){
                    cabeza = materia;
                }else{
                    anterior.setLiga(materia);
                }
                anterior = materia;
                i++;

            }
        } catch (IOException e) {
            System.err.println("Error al cargar materias desde archivo: " + e.getMessage());
        }


    }

    public void mostrarTodasLasMateriasN(){
        String mensaje = "Las materias son: \n ";
        Materia aux = cabeza;
        while (aux != null){
            mensaje +=  "Nombre: " +aux.getNombre() + " Codigo: "+ aux.getCodigoMateria()+ "\n" ;
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensaje);

    }

}
