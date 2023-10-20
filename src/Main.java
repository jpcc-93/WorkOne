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
        Materia[] materias = new Materia[10];
        materias = ListaMat.cargarMaterias();
        ListaAlum alumnos2 = new ListaAlum();
        alumnos2.cargarCurso(materias);
        alumnos2.mostrarTodoslosalumnos();
        System.out.println("carga ok");
        Alumno[] alumnos = new Alumno[15];
        Profesor[] profesores;
        materias = cargarMaterias();
        alumnos = cargarCurso(materias);
        profesores = cargarProfesores(materias);

//        //mostrar por consola alumnos
//        for (int i = 0; i < 15; i++){
//            alumnos[i].mostrarnotas();
//        }
//        //muestra por JOPTION profesores
//        for (int i = 0; i < 4; i++){
//            profesores[i].mostrardatos();
//        }
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion){
                case 1:
                    alumnos[0].mostrarTodoslosalumnos(alumnos);
                    break;
                case 2:
                    profesores[0].mostrarTodos(profesores);

                    break;
                case 3:
                    materias[0].mostrarTodas(materias);
                    break;
                case 4:
                    alumnos[0].mostrarHganan(alumnos);

                    break;
                case 5:
                    alumnos[0].mostrarFganan(alumnos);
                    break;
                case 6:
                    alumnos[0].mostrarpromedio38(alumnos);
                    break;
                case 7:
                    ccbuscar = alumnos[0].buscarTodoslosalumnos(alumnos);
                    for(int i = 0; i < 15; i++){
                        if(ccbuscar == Float.parseFloat(alumnos[i].getiD())){
                            alumnos[i].mostrarnotas();
                        }
                    }

                    break;
                case 0:
                    opcion = 0;
                    break;


            }

        }while(opcion != 0);








        System.out.println("todo bien");

    }


    public static Alumno[] cargarCurso(Materia[] materias){

        String nombreArchivo = "archivos/carga.txt";
        Alumno[] alumnos = new Alumno[15];
        String nombres = "";
        float promedio = 0;
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            int i = 0;
            while((linea = lector.readLine()) != null){
                String[] partes = linea.split(",");
                if(partes.length == 14){

                    Alumno alumno = new Alumno(materias);

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
                    alumnos[i] = alumno;


                    nombres += (alumnos[i].getNombre()) + "\n";

                    i ++;

                }


            }


//            JOptionPane.showMessageDialog(null,nombres);
//
//            JOptionPane.showMessageDialog(null, alumnos[8].getNombre() +" Nota: "+ alumnos[8].getMaterias(9) );

        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }
        return alumnos;

    }

    public static Materia[] cargarMaterias() {
        String nombreArchivo = "archivos/cargaMaterias.txt";
        Materia[] materias = new Materia[11];
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

    public static Profesor[] cargarProfesores(Materia[] materias){

        String nombreArchivo = "archivos/cargaProf.txt",nombre,id,genero,tel;
        //para guardar los numeros de las materias
        int codM1, codM2, codM3;
        Materia m1 = new Materia(),m2 = new Materia(),m3 = new Materia();

        Profesor[] profesores = new Profesor[4];
        String nombres = "";
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
                    m1 = materias[codM1];
                    codM2 = Integer.parseInt(partes[5]);
                    m2 = materias[codM2];
                    codM3 = Integer.parseInt(partes[6]);
                    m3 = materias[codM3];


                    Profesor profesor = new Profesor(m1,m2,m3);
                    profesor.setNombre(nombre);
                    profesor.setiD(id);
                    profesor.setGenero(genero);
                    profesor.setTel(tel);

                    profesores[i] = profesor;


                    nombres += (profesores[i].getNombre()) + "\n";

                    i ++;

                }
            }


        }catch (IOException e)
        {
            System.err.println("Error al cargar alumnos desde el archivo: " + e.getMessage());
        }

        return profesores;
    }


}