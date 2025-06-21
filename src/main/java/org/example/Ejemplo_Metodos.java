package org.example;

public class Ejemplo_Metodos {
    public static void main(String[] args) {
        int resultadoSuma = suma(20,30);
        System.out.println(resultadoSuma);

        int resultadoSuma2 = suma(400,36);
        System.out.println(resultadoSuma2);

        int resultadoSuma3 = suma(340,334);
        System.out.println(resultadoSuma3);

        int resultadoSuma4 = suma(34,334, 44);
        System.out.println(resultadoSuma4);

    }

    public static int suma(int a, int b){
        int c = a + b;
        return c;
    }

    public static int suma(int a, int b, int c){
        int d = a + b + c;
        return d;
    }

}
