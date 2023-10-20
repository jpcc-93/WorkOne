import javax.swing.*;

public class Alumno extends Persona {

    float promedio;



    private Materia[] materias;

    public Alumno(Materia[] materias) {
        this.materias = new Materia[materias.length];
        this.promedio = 0;
        for (int i = 0; i < materias.length; i++) {
            this.materias[i] = new Materia();
            this.materias[i].setCodigoMateria(materias[i].getCodigoMateria());
            this.materias[i].setNombre(materias[i].getNombre());
            this.materias[i].setNota(materias[i].getNota());
            this.materias[i].setDescripcion(materias[i].getDescripcion());
            this.promedio += materias[i].getNota();
        }




    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public float getMaterias(int codigoMateria) {
        return materias[codigoMateria].getNota();
    }

    public void setMaterias(String nota, int codigo) {

        materias[codigo].setNota(Float.parseFloat(nota));
    }

    public void mostrarnotas(){
        String datos = "";
        for (int i = 0; i < 10; i++){
            datos += "\n\nMateria: " + materias[i].getNombre() + "Nota = " + materias[i].getNota()
            + "\nDescripcion: " + materias[i].getDescripcion();
        }
        JOptionPane.showMessageDialog(null,"Alumno: " + getNombre() + datos + "\nPROMEDIO TOTAL: "+getPromedio());
    }

    public void mostrarTodoslosalumnos(Alumno[] alumnos){
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            mensajeAlumnos +=  "Nombre: " +alumnos[i].getNombre() + " Identificacion: "+ alumnos[i].getiD()+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);
    }


    public void mostrarHganan(Alumno[] alumnos){
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            System.out.println(alumnos[i].getPromedio());
            if(alumnos[i].getPromedio() >= 3 && alumnos[i].getGenero().equals("M")) {
                mensajeAlumnos += "\nNonbre: " + alumnos[i].getNombre() + " Identificacion: " +
                                    alumnos[i].getiD() + "\n" + "Promedio: " + String.format("%.2f",alumnos[i].getPromedio());
            }
        }
        JOptionPane.showMessageDialog(null,mensajeAlumnos);

    }

    public void mostrarFganan(Alumno[] alumnos){
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

    public void mostrarpromedio38(Alumno[] alumnos){
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
    public float buscarTodoslosalumnos(Alumno[] alumnos){
        float opcion = 0;
        String mensajeAlumnos = "Lista estudiantes: \n";
        for (int i = 0; i < 15; i++){
            mensajeAlumnos +=  "Nonbre: " +alumnos[i].getNombre() + " Identificacion: "+ alumnos[i].getiD()+ "\n" ;
        }
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,mensajeAlumnos));
        return opcion;
    }


}
