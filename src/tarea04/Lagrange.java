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

    public double[][] pOrdenados;
    public List<Polinomio> lx;
    public int grado;
    public List<Polinomio> numeradores;
    public List<Polinomio> denominadores;

    public Lagrange(double[][] vector, int grado) {
        this.pOrdenados = vector;
        this.grado = grado;
        this.lx = new ArrayList<>();
    }

    private Polinomio lindice(int indice) {
        this.numeradores = new ArrayList<>();
        this.denominadores = new ArrayList<>();
        Polinomio resultado = new Polinomio();
        Polinomio numerador;
        Polinomio denominador;
        for (int i = 0; i <= this.grado; i++) {
            if (i != indice) {
                numerador = new Polinomio();
                denominador = new Polinomio();
                numerador.add(1, 1);
                denominador.add(this.pOrdenados[0][indice], 0);
                numerador.add(-this.pOrdenados[0][i], 0);
                denominador.add(-this.pOrdenados[0][i], 0);
                this.numeradores.add(Operaciones.reducir(numerador));
                this.denominadores.add(Operaciones.reducir(denominador));
            }
        }
        if (this.grado >= 2) {
            Polinomio temp1 = new Polinomio();
            Polinomio temp2 = new Polinomio();
            for (int i = 0; i < this.grado; i++) {
                temp1 = Operaciones.reducir(Operaciones.multiplicar(temp1, this.numeradores.get(i)));
                temp2 = Operaciones.reducir(Operaciones.multiplicar(Operaciones.reducir(temp2), this.denominadores.get(i)));
            }
            resultado = Operaciones.dividirNumero(temp1, temp2.getCoeficiente(0));
        }
        return resultado;
    }

    public void metodo() {
        Polinomio temp1 = new Polinomio();
        for (int i = 0; i <= this.grado; i++) {
            temp1 = Operaciones.reducir(Operaciones.sumar(temp1,Operaciones.multiplicarNumero(lindice(i), this.pOrdenados[1][i])));
            System.out.println("temporal: "+temp1.toString());
        }
        System.out.println("final: "+temp1.toString());
    }

}
