import javax.swing.*;

public class Alumno extends Persona {

    private float promedio;
    private ListaMat lMaterias;
    private Materia[] materias;

    private Alumno liga;

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

    public Alumno(ListaMat lMaterias){
        liga = null;
        Materia aux = new Materia();
        aux = lMaterias.getCabeza();
        this.lMaterias = new ListaMat();
        Materia auxCop = null;
        while (aux != null){
            Materia nuevaM = new Materia();
            nuevaM.setCodigoMateria(aux.getCodigoMateria());
            nuevaM.setNombre(aux.getNombre());
            nuevaM.setDescripcion(aux.getDescripcion());
            if (auxCop == null){
                this.lMaterias.setCabeza(nuevaM);
                auxCop = nuevaM;
            }
            else{
                auxCop.setLiga(nuevaM);
                auxCop = nuevaM;
            }
            aux = aux.getLiga();

        }

    }

    public ListaMat getlMaterias() {
        return lMaterias;
    }

    public void setlMaterias(String nota, int codigo) {
        Materia aux = lMaterias.getCabeza();
        while (aux != null){
            if (aux.getCodigoMateria() == codigo){
                aux.setNota(Float.parseFloat(nota));
            }
            aux = aux.getLiga();
        }
    }

    public Alumno getLiga() {
        return liga;
    }

    public void setLiga(Alumno liga) {
        this.liga = liga;
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

    public void mostrarnotasN(){
        Materia aux = lMaterias.getCabeza();
        String datos = "";
        while (aux != null){
            datos += "\n\n" + aux.getNombre() + " Nota = " + aux.getNota()
                    + "\nDescripcion: " + aux.getDescripcion();
            System.out.println(aux.getNombre());
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,"Alumno: " + getNombre() + datos + "\nPROMEDIO TOTAL: "+getPromedio());
    }

}
