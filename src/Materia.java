import javax.swing.*;

public class Materia {

    private String nombre;
    private int codigoMateria;
    private String descripcion;
    private float nota;




    public Materia(){
        this.nota = 0;
        this.descripcion = "salon bonito";
        this.codigoMateria = 0;
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

    public void mostrarTodas(Materia[] materias){
        String mensajematerias = "Lista Materias: \n";
        for (int i = 0; i < 10; i++){
            mensajematerias +=  "Nonbre: " +materias[i].getNombre() + " Codigo materia: "+ materias[i].codigoMateria+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,mensajematerias);


    }

//    public float promedioTodas(Materia[] materias){
//        float promedio = 0;
//        for(int i = 0; i < materias.length; i++){
//            promedio =+ materias[i].getNota();
//        }
//        promedio = promedio/materias.length;
//        return promedio;
//    }



}
