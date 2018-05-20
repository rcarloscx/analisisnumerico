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

        double[][] pares = new double[2][6];
        pares[0][0] = 0.15;
        pares[0][1] = 2.30;
        pares[0][2] = 3.15;
        pares[0][3] = 4.85;
        pares[0][4] = 6.25;
        pares[0][5] = 7.95;
        pares[1][0] = 0.15074;
        pares[1][1] = 2.1162;
        pares[1][2] = 3.1964;
        pares[1][3] = 3.1964;
        pares[1][4] = 2.9564;
        pares[1][5] = 1.9213;

        Lagrange l = new Lagrange(pares);
        l.metodo();
        System.out.println("error: " + l.error(0.5));

        System.out.println("\n\nPOLINOMIO DE NEWTON------------------------------------\n\n");
        Newton n = new Newton(pares);
        n.diferenciasDivididas();
        //n.metodo();
        
        Polinomio po= n.metodo(true);
        System.out.println(po.salidaPolinomio());
        Funcion f = new Funcion(po.salidaPolinomio());
        System.out.println("Evaluando el polinomio: "+f.eval(1.2));
        
    }

}
