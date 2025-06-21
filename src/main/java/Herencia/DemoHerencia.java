package Herencia;

public class DemoHerencia {
    public static void main(String[] args) {
        Abuelo nicolas = new Abuelo(1.80);
        System.out.println("Nicolas tiene " + nicolas.colorOjos() + " y su estatura es: " + nicolas.getEstatura());

        Hijo arturo = new Hijo(1.78);
        System.out.println("Arturo tiene " + arturo.colorOjos() + " y su estatura es: " + arturo.getEstatura());

        Nieto rodrigo = new Nieto(1.75);
        System.out.println("Rodrigo tiene " + rodrigo.colorOjos());
    }
}
