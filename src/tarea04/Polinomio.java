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
public class Polinomio {

    private List<Double> coeficientes;
    private List<Double> grado;

    public Polinomio() {
        coeficientes = new ArrayList<>();
        grado = new ArrayList<>();
    }

    public void add(double coeficiente, double grado) {
        this.coeficientes.add(coeficiente);
        this.grado.add(grado);
    }

    public Double getCoeficiente(int i) {
        return coeficientes.get(i);
    }

    public void setCoeficiente(int i, double valor) {
        this.coeficientes.set(i, valor);
    }

    public Double getGrado(int i) {
        return grado.get(i);
    }

    public void setGrado(int i, double valor) {
        this.grado.set(i, valor);
    }

    public int getTamanio() {
        return coeficientes.size() - 1;
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i <= this.getTamanio(); i++) {
            if (this.getGrado(i) > 1) {
                if (this.getCoeficiente(i) > 1) {
                    if (i == 0) {
                        salida = salida+ " +" + this.getCoeficiente(i) + "x^" + Math.round(this.getGrado(i));
                    } else{
                        salida = salida+ " +" + this.getCoeficiente(i) + "x^" + Math.round(this.getGrado(i));
                    }
                } else if (this.getCoeficiente(i) == 1) {
                    salida = salida+ " +" + "x^" + Math.round(this.getGrado(i));
                } else if (this.getCoeficiente(i) > 0) {
                    salida = salida+" +" + this.getCoeficiente(i) + "x^" + Math.round(this.getGrado(i));
                } else{
                    salida = salida+" "+ this.getCoeficiente(i) + "x^" + Math.round(this.getGrado(i));
                }
            } else if (this.getGrado(i) == 1) {
                if (this.getCoeficiente(i) > 1) {
                    if (i == 0) {
                        salida = salida+" +" + this.getCoeficiente(i) + "x";
                    } else {
                        salida = salida + " +" + this.getCoeficiente(i) + "x";
                    }
                } else if (this.getCoeficiente(i) == 1) {
                    salida = salida+" +" + "x";
                } else {
                    salida = salida+" " + this.getCoeficiente(i) + "x";
                }
            } else if (this.getGrado(i) == 0) {
                salida += " +" + this.getCoeficiente(i);
            } else {
                salida += " error ";
            }
        }
        return salida;
    }

    public String salidaPolinomio() {
        String polinomio="";
        for (int i = 0; i <= this.getTamanio(); i++) {
             if (this.getGrado(i) > 1) {
                if (this.getCoeficiente(i) > 1) {
                    if (i == 0) {
                        polinomio = polinomio+ "+((+" + this.getCoeficiente(i) + ")*(x^" + this.getGrado(i)+"))";
                    } else{
                        polinomio = polinomio+ "+((+" + this.getCoeficiente(i) + ")*(x^" + this.getGrado(i)+"))";
                    }
                } else if (this.getCoeficiente(i) == 1) {
                    polinomio = polinomio+ "+((+" + ")*(x^" + this.getGrado(i)+"))";
                } else if (this.getCoeficiente(i) > 0) {
                    polinomio = polinomio+"+((+" + this.getCoeficiente(i) + ")*(x^" + this.getGrado(i)+"))";
                } else{
                    polinomio = polinomio+"+(("+ this.getCoeficiente(i) + ")*(x^" + this.getGrado(i)+"))";
                }
            } else if (this.getGrado(i) == 1) {
                if (this.getCoeficiente(i) > 1) {
                    if (i == 0) {
                        polinomio = polinomio+"+((+" + this.getCoeficiente(i) + ")*(x))";
                    } else {
                        polinomio = polinomio + "+((+" + this.getCoeficiente(i) + ")*(x))";
                    }
                } else if (this.getCoeficiente(i) == 1) {
                    polinomio = polinomio+"+((+" + ")x)";
                } else {
                    polinomio = polinomio+"+((" + this.getCoeficiente(i) + ")*(x))";
                }
            } else if (this.getGrado(i) == 0) {
                polinomio += "(+" + this.getCoeficiente(i)+")";
            } else {
                polinomio += " error ";
            }
        }
        return polinomio;
    }
}
