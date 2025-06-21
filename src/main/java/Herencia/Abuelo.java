package Herencia;

public class Abuelo {

    double estatura;

    public Abuelo(double estatura){
        this.estatura = estatura;
    }

    public String colorOjos(){
        return "Ojos color cafe";
    }

    /*
    Encapsulacion
     */

    //Metodo GET
    public double getEstatura(){
        return estatura;
    }

    //Metodo SET
    public void setEstatura(double estatura){
        this.estatura = estatura;
    }
}
