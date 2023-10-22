import javax.swing.*;

public class Profesor extends Persona {

    private Materia m1 = null;
    private Materia m2 = null;
    private Materia m3 = null;
    private String nombre;

    private Profesor liga;


    public Profesor() {
        liga = null;
    }

    public  Profesor(Materia m1,Materia m2,Materia m3){

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = "Prof. " + nombre;
    }

    public Profesor getLiga() {
        return liga;
    }

    public void setLiga(Profesor liga) {
        this.liga = liga;
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




}
