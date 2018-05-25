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
public class Hermite {

    public double[][] tabla;
    public double[] diferencias;
    public double[][] deriv;
    public double[][] pares;

    public Hermite(double[][] vector, double[][] derivadas, double[][] pares) {
        this.tabla = new double[vector[0].length + 1][vector[0].length];
        this.deriv = derivadas;
        this.pares = pares;
        int posicion = vector[0].length - 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                tabla[i][j] = vector[i][posicion];
                posicion = posicion - 1;
            }
            posicion = vector[0].length - 1;
        }
        this.diferencias = new double[vector[0].length];
    }

    public double[] diferenciasDivididas() {
        int diferencia = 1;
        int cantidad = tabla[0].length - 1;
        double numerador;
        double denominador;
        for (int i = 2; i < tabla.length; i++) {
            for (int j = 0; j < cantidad; j++) {
                numerador = tabla[i - 1][j] - tabla[i - 1][j + 1];
                denominador = tabla[0][j] - tabla[0][j + diferencia];
                if (numerador == 0 && denominador == 0) {
                    tabla[i][j] = getDerivada(tabla[0][j]);
                } else {
                    tabla[i][j] = numerador / denominador;
                }
            }
            diferencia = diferencia + 1;
            cantidad = cantidad - 1;
        }
        cantidad = tabla[0].length - 1;
        for (int i = 1; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                this.diferencias[i - 1] = tabla[i][cantidad];
            }
            cantidad = cantidad - 1;
        }
        return this.diferencias;
    }

    public double getDerivada(double de) {
        double salida = 0;
        for (int i = 0; i < deriv[0].length; i++) {
            if (deriv[0][i] == de) {
                return deriv[1][i];
            }
        }
        return salida;
    }

    public List<Polinomio> pol(int n) {
        List<Polinomio> lista = new ArrayList<>();
        Polinomio multiplicador;
        int grado = 1;
        int x = 0;
        for (int i = 0; i < n; i++) {
            multiplicador = new Polinomio();
            multiplicador.add(1, 1);
            multiplicador.add(-pares[0][x], 0);
            multiplicador.setElevado(grado);
            if (grado == 2) {
                grado = 0;
                x = x + 1;
            }
            grado = grado + 1;
            lista.add(multiplicador);
        }
        lista = filtar(n, lista);
        return lista;
    }

    public List<Polinomio> filtar(int n, List<Polinomio> list) {
        List<Polinomio> lista = list;
        List<Polinomio> salida = new ArrayList<>();
        int posicion;
        for (int i = 0; i < lista.size(); i++) {
            posicion = i + 1;
            if ((posicion % 2) == 0) {
                salida.add(lista.get(posicion - 1));
            }
        }
        if (!((n % 2) == 0)) {
            salida.add(lista.get(n - 1));
        }
        return salida;
    }

    public Polinomio metodo() {
        Polinomio salida = new Polinomio();
        diferenciasDivididas();
        salida.add(this.diferencias[0], 0);
        for (int i = 1; i < this.diferencias.length; i++) {
            Polinomio devuelto = reducir(pol(i));
            salida = Operaciones.reducir(Operaciones.sumar(salida, Operaciones.multiplicarNumero(devuelto, this.diferencias[i])));
        }
        return salida;
    }

    public Polinomio reducir(List<Polinomio> lista) {
        Polinomio salida = new Polinomio();
        Polinomio potenciado;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getElevado() == 2) {
                potenciado = lista.get(i).resorverPotencia();
                salida = Operaciones.reducir(Operaciones.multiplicar(salida, potenciado));
            } else {
                salida = Operaciones.reducir(Operaciones.multiplicar(salida, lista.get(i)));
            }
        }
        return salida;
    }

    public double error(double x) {
        double er;
        double acomulador = 1;
        for (int i = 0; i < pares[0].length; i++) {
            acomulador = acomulador * (Math.pow(x - pares[0][i], 2));
        }
        er = (diferencias[diferencias.length - 1]) * (acomulador);
        return er;
    }

}
