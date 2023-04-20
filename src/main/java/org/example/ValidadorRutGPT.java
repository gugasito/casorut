package org.example;
import java.util.Scanner;

public class ValidadorRutGPT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el rut sin dígito verificador: ");
        String rutSinDV = sc.nextLine();

        try {
            int[] rut = parseRut(rutSinDV);
            int dv = calculateDV(rut);
            System.out.print("El dígito verificador es: " + dv);
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
    }

    private static int[] parseRut(String rutSinDV) throws Exception {
        if (!rutSinDV.matches("\\d{1,3}(\\.\\d{3})*-\\w")) {
            throw new Exception("Formato de rut incorrecto");
        }

        String[] rutSplit = rutSinDV.split("[.\\-]");
        int[] rut = new int[rutSplit.length];

        for (int i = 0; i < rutSplit.length - 1; i++) {
            rut[i] = Integer.parseInt(rutSplit[i]);
        }

        return rut;
    }

    private static int calculateDV(int[] rut) {
        int suma = 0;
        int multiplicador = 2;

        for (int i = rut.length - 1; i >= 0; i--) {
            suma += rut[i] * multiplicador;
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        int dv = 11 - resto;

        if (dv == 11) {
            return 0;
        } else if (dv == 10) {
            return 'K';
        } else {
            return dv;
        }
    }
}