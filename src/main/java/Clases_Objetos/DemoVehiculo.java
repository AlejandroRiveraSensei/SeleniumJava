package Clases_Objetos;

public class DemoVehiculo {
    public static void main(String[] args) {
        Vehiculo minivan = new Vehiculo();

        int rango;

        minivan.pasajeros =  9;
        minivan.capacidad = 15;
        minivan.kmh = 20;

        //Calcular el rango asumiento un tanque lleno
        /*
        Calcular el rango asumiento un tanque lleno
         */
        rango = minivan.capacidad * minivan.kmh;

        System.out.println("La minivan puede llevar " + minivan.pasajeros + " pasajeros con un rango de " + rango + " kilometros");

        Vehiculo carro = new Vehiculo();
        carro.pasajeros =  5;
        System.out.println("Numero en pasajeros en carro es: " + carro.pasajeros);

    }
}
