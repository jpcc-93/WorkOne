import javax.swing.*;

public class Materia {

    private String nombre;
    private int codigoMateria;
    private String descripcion;
    private float nota;
    private Materia liga;




    public Materia(){
        liga = null;
        this.nota = 0;
        this.descripcion = "salon bonito";
        this.codigoMateria = 0;
    }

    public Materia getLiga() {
        return liga;
    }

    public void setLiga(Materia liga) {
        this.liga = liga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }




}
