import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaAlum {

    private Alumno cabeza;
    Alumno[] alumnos;
    int sizeL;

    public ListaAlum() {
        cabeza = null;

        sizeL = validarTamano();
        this.alumnos = new Alumno[sizeL];
        ListaMat materias = new ListaMat();

        for (int i = 0; i < sizeL; i ++) {
            alumnos[i] = new Alumno(materias.getMaterias());
        }
    }

    public Alumno getCabeza() {
        return cabeza;
    }

    public void setCabeza(Alumno cabeza) {
        this.cabeza = cabeza;
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
                    for(int j = 3,k = 0; j < 14 ; j++, k++){
                        System.out.println(j);
                        alumno.setlMaterias(partes[j],k);
                        alumno.setPromedio(alumno.getPromedio() + Float.parseFloat(partes[j]));

                        //System.out.println(alumno.getlMaterias().getCabeza().getNombre() +"esto: "+ alumno.getlMaterias().getCabeza().getNota() );
                    }
                    alumno.setPromedio(alumno.getPromedio()/10);
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

    public void mostrarTodoslosalumnosN(){
        Alumno aux = cabeza;
        String mensajeAlumnos = "Lista estudiantes: \n";
        while (aux != null){
            mensajeAlumnos +=  "Nombre: " +aux.getNombre() + " Identificacion: "+ aux.getiD()+ "\n" ;
            aux = aux.getLiga();
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
