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
        for (int i = 0; i < multiplicando.getTamanio(); i++) {
            for (int j = 0; j < multiplicador.getTamanio(); j++) {
                c = multiplicador.getCoeficiente(i) * multiplicando.getCoeficiente(j);
                g = multiplicador.getGrado(i) + multiplicador.getGrado(j);
                resultado.add(c, g);
            }
        }
        return resultado;
    }

    public static Polinomio reducir(Polinomio polinomio) {
        Polinomio salida = new Polinomio();
        double suma;
        for (int i = 0; i < polinomio.getTamanio(); i++) {
            suma = polinomio.getCoeficiente(i);
            for (int j = 0; j < polinomio.getTamanio(); j++) {
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

}
