package org.example;

public class Main {

    public static int digito(int rut) {
        int revesRut = 0;
        int verif = 0;
        while (rut != 0) {
            int digit = rut % 10;
            revesRut = revesRut * 10 + digit;
            rut /= 10;
        }
        String numeroComoCadena = Integer.toString(revesRut);
        for (int i = 0; i < numeroComoCadena.length(); i++) {
            int[] cadena = {2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
            char digitoComoCaracter = numeroComoCadena.charAt(i);
            int digito = (Character.getNumericValue(digitoComoCaracter)) * (cadena[i]);
            verif = verif + digito;
        }
        int suma = verif / 11;
        int multiplicacion = suma * 11;
        int resta = verif - multiplicacion;
        if (resta < 0) {
            resta = resta * -1;
        }
        verif = 11 - resta;
        return verif;
    }
}