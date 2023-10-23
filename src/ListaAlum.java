import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaAlum {

    private Alumno cabeza;


    public ListaAlum() {
        cabeza = null;
    }

    public Alumno getCabeza() {
        return cabeza;
    }

    public void setCabeza(Alumno cabeza) {
        this.cabeza = cabeza;
    }

    public void cargarCursoN(ListaMat materias){

        String nombreArchivo = "archivos/carga.txt";
        Alumno anterior = null;

        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            int i = 0;
            while((linea = lector.readLine()) != null){
                String[] partes = linea.split(",");
                if(partes.length == 14){
                    //System.out.println(materias.getCabeza().getNota());
                    Alumno alumno = new Alumno(materias);
                    alumno.setNombre(partes[0]);
                    alumno.setiD(partes[1]);
                    alumno.setGenero(partes[2]);
                    alumno.setTel(partes[3]);
                    for(int j = 4,k = 0; j < 14 ; j++, k++){
                        alumno.setlMaterias(partes[j],k);
                        alumno.setPromedio(alumno.getPromedio() + Float.parseFloat(partes[j]));
                        System.out.println(alumno.getPromedio());

                        //System.out.println(alumno.getlMaterias().getCabeza().getNombre() +"esto: "+ alumno.getlMaterias().getCabeza().getNota() );
                    }
                    alumno.setPromedio(alumno.getPromedio()/10);
                    //System.out.println(alumno.getPromedio());
                    if(i == 0){
                        cabeza = alumno;
                    }else{
                        anterior.setLiga(alumno);
                    }
                    anterior = alumno;
                    System.out.println(alumno.getNombre()+"  "+ alumno.getiD() +"   "+alumno.getGenero()+" " +alumno.getTel());

                    i ++;

                }



            }

        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

    }

    public void mostrarTodoslosalumnosN(){
        Alumno aux = cabeza;
        String mensajeAlumnos = "Lista estudiantes: \n";
        while (aux != null){
            mensajeAlumnos +=  "Nombre: " +aux.getNombre() + " Identificacion: "+ aux.getiD()+ "\n" ;
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);
    }

    public void mostrarHgananN(){
        Alumno aux = cabeza;
        String mensajeAlumnos = "Lista estudiantes hombres que ganan: \n";
        while (aux != null){
            if(aux.getPromedio() >= 3 && aux.getGenero().equals("M")) {
                mensajeAlumnos += "\nNonbre: " + aux.getNombre() + " Identificacion: " +
                        aux.getiD() + "\n" + "Promedio: " + String.format("%.2f",aux.getPromedio());
            }
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);

    }


    public void mostrarFgananN(){
        Alumno aux = cabeza;
        String mensajeAlumnos = "Lista estudiantes mujeres que ganan: \n";
        while (aux != null){
            if(aux.getPromedio() >= 3 && aux.getGenero().equals("F")) {
                mensajeAlumnos += "\nNonbre: " + aux.getNombre() + " Identificacion: " +
                        aux.getiD() + "\n" + "Promedio: " + String.format("%.2f",aux.getPromedio());
            }
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);

    }

    public void mostrarpromedio38N(){
        Alumno aux = cabeza;
        String mensajeAlumnos = "Lista estudiantes: \n";
        while (aux != null){
            System.out.println(aux.getPromedio());
            if(aux.getPromedio() >= 3.8 ) {
                mensajeAlumnos += "\nNonbre: " + aux.getNombre() + " Identificacion: " +
                        aux.getiD() + "\n" + "Promedio: " + String.format("%.2f",aux.getPromedio());
            }
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);
    }
    public void buscarN(){
        Alumno aux = cabeza;
        float opcion = 0;
        String mensajeAlumnos = "Lista estudiantes: \n";
        while (aux != null){
            mensajeAlumnos +=  "Nonbre: " + aux.getNombre() + " Identificacion: "+ aux.getiD()+ "\n" ;
            aux = aux.getLiga();
        }
        mensajeAlumnos += "\n" +"Ingrese cedula del alumno: ";
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,mensajeAlumnos));
        aux = cabeza;
        while (aux != null){
            if (opcion == Float.parseFloat(aux.getiD())){
                aux.mostrarnotasN();

            }
            aux = aux.getLiga();
        }
    }

}
