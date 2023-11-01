//// Copyright (C) 2020
package com.espol.edu;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

   /**
     * @param dest
     * @param people
     * @param days
     * @return acumulado
     *
     * Function that calculates the total value
     * of a vacation package given the inputs.*/
    public static float calcCost(final String dest, int people, int days) {
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

        Destination c1 = new Destination("Paris", true, parisFee);
        Destination c2 = new Destination("New York City", true, nycFee);

        LinkedList<Destination> listado = new LinkedList<Destination>();
        listado.add(c1);
        listado.add(c2);

        Destination tmp = new Destination(dest);

        for (int i = 0; i < listado.size(); i++) {
            Destination cursor = listado.get(i);
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

        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la ciudad de Destino: ");
        String busqueda = input.nextLine();

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

        float total = Main.calcCost(busqueda, numero, dias);
        System.out.println("Total calculado es de: $" + total);

    }
}
//CHECKSTYLE:ON
