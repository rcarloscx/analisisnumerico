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
        indices = new double[2][3];
        indices[0][0] = 0.0;
        indices[0][1] = 1.0;
        indices[0][2] = 2.0;
        indices[1][0] = 2.0;
        indices[1][1] = 0.0;
        indices[1][2] = 3.0;
    }

    public Polinomio lindice(int grado, int indice) {
        inicializar();
        numeradores = new ArrayList<>();
        denominadores = new ArrayList<>();
        Polinomio resultadoN = new Polinomio();
        Polinomio resultadoD;
        Polinomio numerador;
        Polinomio denominador;
        for (int i = 0; i <= grado; i++) {
            if (i != indice) {
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
            //for (int i = 0; i < numeradores.size(); i++) {
            int contador = 0;
            int cantidad = 0;
            do {
                numeradores.add(Operaciones.multiplicar(numeradores.get(contador), numeradores.get(contador + 1)));
                denominadores.add(Operaciones.multiplicar(denominadores.get(contador), denominadores.get(contador + 1)));
                cantidad = cantidad + 1;
                contador = contador + 2;
            } while (grado <= contador);
            Polinomio temp1 = new Polinomio();
            Polinomio temp2 = new Polinomio();
            for (int i = 0; i < grado - 1; i++) {
                //temp1 = 
            }
            //resultadoN = Operaciones.multiplicar(numeradores.get(0), numeradores.get(1));
            //System.out.println("reduccion 1: "+Operaciones.reducir(denominadores.get(1)).toString());
            //resultadoD = Operaciones.multiplicar(denominadores.get(0), denominadores.get(1));
            //}
            //Denominador
            System.out.println("resultado numerador: " + resultadoN.toString());
            //System.out.println("resultado denominador: " + resultadoD.toString());
            //System.out.println("RESULTADOR FINAL: " + Operaciones.dividirNumero(resultadoN, resultadoD.getCoeficiente(0)).toString());
        }
        return resultadoN;
    }

}
