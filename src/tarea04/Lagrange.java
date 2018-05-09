/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea04;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcarlos
 */
public class Lagrange {

    public double[][] indices;
    public String[] lx;
    List<Polinomio> numeradores;
    List<Polinomio> denominadores;

    public void inicializar() {
        indices = new double[2][5];
        indices[0][0] = 0.4;
        indices[0][1] = 2.5;
        indices[0][2] = 4.3;
        indices[0][3] = 5.0;
        indices[0][4] = 6.0;
        indices[1][0] = 2.0;
        indices[1][1] = 0.0;
        indices[1][2] = 3.0;
        indices[1][3] = 3.0;
        indices[1][4] = 3.0;
    }

    public Polinomio lindice(int grado, int indice) {
        inicializar();
        numeradores = new ArrayList<>();
        denominadores = new ArrayList<>();
        Polinomio resultado = new Polinomio();
        Polinomio numerador;
        Polinomio denominador;
        for (int i = 0; i <= grado; i++) {
            if (i != indice) {
                //System.out.println("i: "+i);
                numerador = new Polinomio();
                denominador = new Polinomio();
                numerador.add(1, 1);
                denominador.add(indices[0][indice], 0);
                numerador.add(-indices[0][i], 0);
                denominador.add(-indices[0][i], 0);
                numeradores.add(Operaciones.reducir(numerador));
                denominadores.add(Operaciones.reducir(denominador));
            }
        }

        if (grado >= 2) {
            Polinomio temp1 = new Polinomio();
            Polinomio temp2 = new Polinomio();
            for (int i = 0; i < grado; i++) {
                temp1 = Operaciones.reducir(Operaciones.multiplicar(temp1, numeradores.get(i)));
                temp2 = Operaciones.reducir(Operaciones.multiplicar(Operaciones.reducir(temp2), denominadores.get(i)));
            }
            System.out.println("L(" + indice + "): (" + temp1.toString() + ") / " + temp2.toString());
            resultado = Operaciones.dividirNumero(temp1, temp2.getCoeficiente(0));

        }
        return resultado;
    }

}
