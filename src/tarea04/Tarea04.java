/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea04;

import java.util.regex.*;

/**
 *
 * @author rcarlos
 */
public class Tarea04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polinomio t = new Polinomio();
        t.add(1, 1);
        t.add(3, 0);
        System.out.println("multiplicando : "+t.toString());
        Polinomio t2 = new Polinomio();
        t2.add(1, 1);
        t2.add(3, 0);
        System.out.println("multiplicador : "+t2.toString());
        Polinomio resultado;
        resultado = Operaciones.multiplicar(t, t2);
        resultado.setCoeficiente(1, -3);//solo para probar la correcta reduccion
        resultado = Operaciones.reducir(resultado);

        System.out.println("polinomio: "+resultado.toString());
    }

}
