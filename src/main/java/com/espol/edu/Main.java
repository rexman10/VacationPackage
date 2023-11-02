//// Copyright (C) 2020
package com.espol.edu;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("PMD.UseUtilityClass")
public class Main {

   /**
     * @param dest
     * @param people
     * @param days
     * @return acumulado
     *
     * Function that calculates the total value
     * of a vacation package given the inputs.*/
    public static float calcCost(final String dest, final int people, final int days) {
        final int base = 1000;
        int acumulado = 0 + base;

        final int parisFee = 500;
        final int nycFee = 600;
        final int penaltyFee = 200;
        final int travelerLimit1 = 2;
        final int travelerLimit2 = 7;
        final int travelerLimit3 = 4;
        final int travelerLimit4 = 10;
        final int daysLimit = 30;
        final float discount1 = 0.9f;
        final float discount2 = 0.8f;

        final Destination dest1 = new Destination("Paris", true, parisFee);
        final Destination dest2 = new Destination("New York City", true, nycFee);

        final Aditional adit1 = new Aditional("All-Inclusive Package", 200);
        final Aditional adit2 = new Aditional("Adventure Activities Package", 150);
        final Aditional adit3 = new Aditional("Spa and Wellness Package", 100);

        final List<Aditional> adicionales = new LinkedList<>();
        adicionales.add(adit1);
        adicionales.add(adit2);
        adicionales.add(adit3);

        final List<Destination> listado = new LinkedList<>();
        listado.add(dest1);
        listado.add(dest2);

        final Destination tmp = new Destination(dest);

        for (int i = 0; i < listado.size(); i++) {
            final Destination cursor = listado.get(i);
            if (cursor.equals(tmp)) {
                acumulado += cursor.getExtraFee();
            }
        }

        if (days < travelerLimit2) {
            acumulado += penaltyFee;
        } else if (days > daysLimit || people == travelerLimit1) {
            acumulado -= penaltyFee;
        }

        if (people > travelerLimit3 && people < travelerLimit4) {
            acumulado *= discount1;
        } else if (people > travelerLimit4) {
            acumulado *= discount2;
        }


        return acumulado;
//CHECKSTYLE:OFF
    }
    /**@param args default param of main method.
     * Main method for calculation. */
    public static void main(final String[] args) {
        final int max = 80;

        Scanner input = new Scanner(System.in); // NOPMD by alex_ on 11/1/23, 10:25 PM
        System.out.print("Ingrese la ciudad de Destino: ");
        final String busqueda = input.nextLine();

        System.out.print("Ingrese la cantidad de viajeros: ");
        Integer numero = Integer.valueOf(input.nextLine());
        while (numero > max) {
            System.out.println("Ha ingresado un valor muy elevado");
            System.out.print("Ingrese la cantidad de viajeros: ");
            numero = Integer.valueOf(input.nextLine());
        }

        System.out.print("Ingrese la cantidad de dias: ");
        Integer dias = Integer.valueOf(input.nextLine());
        while (dias < 1) {
            System.out.println("Ha ingresado un valor invalido");
            System.out.print("Ingrese la cantidad de dias: ");
            dias = Integer.valueOf(input.nextLine());
        }

        float total = calcCost(busqueda, numero, dias);
        
        System.out.print("Desea agregar un adicional? (Si/No): ");
        String eleccion = input.next(); // NOPMD by alex_ on 11/1/23, 10:25 PM
        if ("No".equals(eleccion)) {
        	System.out.println("Total calculado es de: $" + total);
        } else {
            System.out.println("Elija un adicional: ");
            System.out.println("1. All-Inclusive Package");
            System.out.println("2. Adventure Activities Package");
            System.out.println("3. Spa and Wellness Package");
            Integer adicional = Integer.valueOf(input.nextLine());
            while (adicional < 1 || adicional > 3) {
                System.out.println("Ha ingresado un valor invalido");
                System.out.println("Elija un adicional: ");
                System.out.println("1. All-Inclusive Package");
                System.out.println("2. Adventure Activities Package");
                System.out.println("3. Spa and Wellness Package");
                adicional = Integer.valueOf(input.nextLine());
            }
            if (adicional == 1) {
                total += 200;
            } else if (adicional == 2) {
                total += 150;
            } else {
                total += 100;
            }
            System.out.println("Total calculado es de: $" + total);
        }
        input.close();

    }
}
//CHECKSTYLE:ON
