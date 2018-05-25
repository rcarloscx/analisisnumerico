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

    public Lagrange(double[][] vector) {
        this.pOrdenados = vector;
        this.grado = vector[0].length - 1;
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

    public Polinomio metodo() {
        Polinomio salida = new Polinomio();
        for (int i = 0; i <= this.grado; i++) {
            salida = Operaciones.reducir(Operaciones.sumar(salida, Operaciones.multiplicarNumero(lindice(i), this.pOrdenados[1][i])));
        }
        return salida;
    }

    public double error(double x) {
        double er;
        double acomulador = 1;
        for (int i = 0; i <= this.grado; i++) {
            acomulador = acomulador * (x - pOrdenados[0][i]);
        }
        er = (pOrdenados[1][this.grado] / factorial(this.grado + 1)) * (acomulador);
        return er;
    }

    public int factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

}
