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

        double[][] pares = new double[2][4];
        pares[0][0] = 1;
        pares[0][1] = 2;
        pares[0][2] = 4;
        pares[0][3] = 5;
        pares[1][0] = 0;
        pares[1][1] = 2;
        pares[1][2] = 12;
        pares[1][3] = 21;

        Lagrange l = new Lagrange(pares);
        l.metodo();
        System.out.println("error: " + l.error(0.5));

        Newton n = new Newton(pares);
        n.diferenciasDivididas();
    }

}
