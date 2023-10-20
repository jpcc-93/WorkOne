import javax.swing.*;

public class Profesor extends Persona {

    Materia m1 = null;
    Materia m2 = null;
    Materia m3 = null;

    String nombre;


    public Profesor(Materia m1, Materia m2, Materia m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = "Prof. " + nombre;
    }


    public Materia getM1() {
        return m1;
    }

    public void setM1(Materia m1) {
        this.m1 = m1;
    }

    public Materia getM2() {
        return m2;
    }

    public void setM2(Materia m2) {
        this.m2 = m2;
    }

    public Materia getM3() {
        return m3;
    }

    public void setM3(Materia m3) {
        this.m3 = m3;
    }

    public void mostrardatos(){
        JOptionPane.showMessageDialog(null,"Nombre: "+this.nombre+ "\nMaterias: "+m1.getNombre()+
                ", " + m2.getNombre() + ", "+m3.getNombre());

    }

    public void mostrarTodos(Profesor[] profesores){
        String mensajeprofesores = "Lista Profesores: \n";
        for (int i = 0; i < 4; i++){
            mensajeprofesores +=  "Nonbre: " +profesores[i].getNombre() + " Identificacion: "+ profesores[i].getiD()+"\n"
            + "Dicta las materias: \n" + profesores[i].getM1().getNombre() + " , "+ profesores[i].getM2().getNombre() + " , "+ profesores[i].getM3().getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null,mensajeprofesores);


    }



}
