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
public class Tarea04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double[][] pares = new double[2][3];
        pares[0][0] = 0;
        pares[0][1] = 1;
        pares[0][2] = 2;
        pares[1][0] = 2;
        pares[1][1] = 0;
        pares[1][2] = 3;

        Lagrange l = new Lagrange(pares, 2);
        l.metodo();
    }

}
