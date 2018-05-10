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
public class Operaciones {

    public static Polinomio multiplicar(Polinomio multiplicando, Polinomio multiplicador) {
        Polinomio resultado = new Polinomio();
        double c;
        double g;
        for (int i = 0; i <= multiplicando.getTamanio(); i++) {
            for (int j = 0; j <= multiplicador.getTamanio(); j++) {
                c = multiplicando.getCoeficiente(i) * multiplicador.getCoeficiente(j);
                //g = multiplicador.getGrado(i) + multiplicador.getGrado(j);
                g = multiplicando.getGrado(i) + multiplicador.getGrado(j);
                resultado.add(c, g);
            }
        }
        if (multiplicando.getTamanio() == -1) {
            return multiplicador;
        } else {
            if (multiplicador.getTamanio() == -1) {
                return multiplicando;
            }
        }
        return Operaciones.reducir(resultado);
    }

    public static Polinomio reducir(Polinomio polinomio) {
        Polinomio salida = new Polinomio();
        double suma;
        for (int i = 0; i <= polinomio.getTamanio(); i++) {
            suma = polinomio.getCoeficiente(i);
            for (int j = 0; j <= polinomio.getTamanio(); j++) {
                if (i != j) {
                    if (polinomio.getGrado(i).equals(polinomio.getGrado(j)) && !polinomio.getGrado(i).equals(-1.0)) {
                        suma = suma + polinomio.getCoeficiente(j);
                        polinomio.setGrado(j, -1.0);
                    }
                }
            }
            if (!polinomio.getGrado(i).equals(-1.0) && suma != 0.0) {
                salida.add(suma, polinomio.getGrado(i));
            }
            polinomio.setGrado(i, -1.0);
        }
        return salida;
    }

    public static Polinomio dividirNumero(Polinomio polinomio, double divisor) {
        for (int i = 0; i <= polinomio.getTamanio(); i++) {
            polinomio.setCoeficiente(i, polinomio.getCoeficiente(i) / divisor);
        }
        return polinomio;
    }

    public static Polinomio multiplicarNumero(Polinomio polinomio, double multiplicador) {
        for (int i = 0; i <= polinomio.getTamanio(); i++) {
            polinomio.setCoeficiente(i, polinomio.getCoeficiente(i) * multiplicador);
        }
        return polinomio;
    }

    public static Polinomio sumar(Polinomio sumando1, Polinomio sumando2) {
        Polinomio salida = new Polinomio();
        for (int i = 0; i <= sumando1.getTamanio(); i++) {
            salida.add(sumando1.getCoeficiente(i), sumando1.getGrado(i));
        }
        for (int i = 0; i <= sumando2.getTamanio(); i++) {
            salida.add(sumando2.getCoeficiente(i), sumando2.getGrado(i));
        }
        return salida;
    }

}
