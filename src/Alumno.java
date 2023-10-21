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
            datos += "\n\n" + materias[i].getNombre() + " Nota = " + materias[i].getNota()
            + "\nDescripcion: " + materias[i].getDescripcion();
        }
        JOptionPane.showMessageDialog(null,"Alumno: " + getNombre() + datos + "\nPROMEDIO TOTAL: "+getPromedio());
    }

}
