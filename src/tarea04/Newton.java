/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea04;

/**
 *
 * @author rcarlos
 */
public class Newton {

    public double[][] pOrdenados;

    public Newton(double[][] vector) {
        this.pOrdenados = new double[vector[0].length + 1][vector[0].length];
        int posicion = vector[0].length - 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                pOrdenados[i][j] = vector[i][posicion];
                posicion = posicion - 1;
            }
            posicion = vector[0].length - 1;
        }
    }

    public void diferenciasDivididas() {
        int diferencia = 1;
        int cantidad = pOrdenados[0].length - 1;
        double numerador;
        double denominador;
        System.out.println("tamanio: " + cantidad);
        for (int i = 2; i < pOrdenados.length; i++) {
            for (int j = 0; j < cantidad; j++) {
                numerador = pOrdenados[i - 1][j] - pOrdenados[i - 1][j + 1];
                denominador = pOrdenados[0][j] - pOrdenados[0][j + diferencia];
                pOrdenados[i][j] = numerador / denominador;
            }
            diferencia = diferencia + 1;
            cantidad = cantidad - 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("" + pOrdenados[i][j] + "\t\t\t");
            }
            System.out.println("\n");
        }
        
    }

}
