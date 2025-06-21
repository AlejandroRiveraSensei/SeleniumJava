package polimorfismo;

public class DemoPolimorfismo {
    public static void main(String[] args){
        Animal alejandro = new Humano();
        alejandro.speak();

        alejandro = new Perro();
        alejandro.speak();

        Animal puppy = new Perro();
        puppy.speak();

        Animal garfield = new Gato();
        garfield.speak();
    }
}
