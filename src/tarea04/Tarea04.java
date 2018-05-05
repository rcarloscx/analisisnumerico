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
        // compilamos el patron
        Pattern patron = Pattern.compile("-[1-9]*x2");
        //Pattern patron = Pattern.compile("x\\^3");
        //Pattern patron = Pattern.compile("-[1-9]*x2");
        // creamos el Matcher a partir del patron, la cadena como parametro
        Matcher encaja = patron.matcher("-33x2-4x2+3x^3");
        while (encaja.find()) {
            System.out.println(encaja.group());
        }
        // invocamos el metodo replaceAll
        String resultado = encaja.replaceAll("");
        System.out.println(resultado);
    }

}
