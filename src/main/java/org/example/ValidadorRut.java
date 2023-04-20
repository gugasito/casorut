package org.example;
import java.util.Scanner;
public class ValidadorRut {
    public static void main(String[] args) {
        System.out.println("El digito verificador es: " + dVerificador());
    }

    public static String digito(int verif) {
        String digVerif;
        if (verif == 11) {
            digVerif = "0";
        } else if (verif == 10) {
            digVerif = "K";
        }else{
            digVerif = String.valueOf(verif);
        }
        return digVerif;
    }

    public static int serie(String numeroComoCadena) {
        int verif = 0;
        for (int i = 0; i < numeroComoCadena.length(); i++) {
            int[] cadena = {2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
            char digitoComoCaracter = numeroComoCadena.charAt(i);
            int digito = (Character.getNumericValue(digitoComoCaracter)) * (cadena[i]);
            verif = verif + digito;
        }
        return verif;
    }

    public static int ingresarut() {
        Scanner s = new Scanner(System.in);
        System.out.println("ingresa el rut");
        return s.nextInt();
    }

    public static String dVerificador() {
        return digito(operaciones(serie(voltearInt(menu()))));
    }
    public static int operaciones(int verif){
        int suma = verif / 11;
        int multiplicacion = suma * 11;
        int resta = verif - multiplicacion;
        if (resta < 0) {
            resta = resta * -1;
        }
        verif = 11 - resta;
        return verif;
    }

    public static int menu() {
        boolean bien = false;
        int rut;
        do {
            try {
                rut = ingresarut();
                bien = true;
            } catch (Exception e) {
                System.out.println("Rut invalido ingrese nuevamente");
                rut = ingresarut();
            }
        } while (!bien);
        return rut;
    }

    public static String voltearInt(int rut) {
        int revesRut = 0;
        while (rut != 0) {
            int digit = rut % 10;
            revesRut = revesRut * 10 + digit;
            rut /= 10;
        }
        return Integer.toString(revesRut);
    }

}