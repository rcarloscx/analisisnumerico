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

    public double[][] tabla;
    public double[] diferencias;
    public double[][] pares;

    public Newton(double[][] vector) {
        this.tabla = new double[vector[0].length + 1][vector[0].length];
        this.pares = vector;
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
                tabla[i][j] = numerador / denominador;
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
        for (double[] tabla1 : tabla) {
            for (int j = 0; j < tabla[0].length; j++) {
                System.out.print("" + tabla1[j] + "\t\t");
            }
            System.out.println("\n");
        }
        for (int i = 0; i < this.diferencias.length; i++) {
            System.out.println("diferencia " + i + " :" + this.diferencias[i]);
        }
        System.out.println("\n");
        return this.diferencias;
    }

    public double diferencia(int n) {
        double dif = 0.0;
        int inicio = 0;
        int fin = 0 + n;
        if (n == 2) {
            dif = (pares[1][fin]-pares[1][inicio]) / (1);
        } else {

        }
        return 0.0;
    }

    public Polinomio parametro(int n) {
        Polinomio salida = new Polinomio();
        for (int i = n - 1; i >= 0; i--) {
            salida.add(pares[1][i], 0);
        }
        return salida;
    }

    public double getX(double eval) {
        double x = 0.0;
        for (int i = 0; i < pares[0].length; i++) {
            if (eval == pares[1][i]) {
                x = pares[1][i];
            }
        }
        return x;
    }

    public String metodo() {
        Polinomio salida = new Polinomio();
        for (int i = 0; i < this.diferencias.length; i++) {
            Polinomio devuelto = operador(i);
            salida = Operaciones.reducir(Operaciones.sumar(salida, Operaciones.multiplicarNumero(devuelto, this.diferencias[i])));
        }
        return salida.toString();
    }

    public Polinomio operador(int n) {
        Polinomio salida = new Polinomio();
        Polinomio numerador;
        for (int i = 0; i < n; i++) {
            numerador = new Polinomio();
            numerador.add(1, 1);
            numerador.add(-tabla[0][tabla[0].length - i - 1], 0);
            salida = Operaciones.reducir(Operaciones.multiplicar(salida, numerador));
        }
        if (n == 0) {
            salida.add(1, 0);
        }
        return salida;
    }

    public double error(double x) {
        double error;
        double acomulador = 1;
        int posicion = tabla[0].length - 1;
        for (int i = 0; i < diferencias.length; i++) {
            acomulador = acomulador * (x - tabla[0][posicion]);
            posicion = posicion - 1;
        }
        error = diferencias[diferencias.length - 1] * acomulador;
        return error;
    }
}
