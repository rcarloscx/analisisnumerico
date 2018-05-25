/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea04;

import vistas.frmPrincipal;

/**
 *
 * @author rcarlos
 */
public class Tarea04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polinomio p = new Polinomio();
        p.add(2, 2);
        p.add(10, 0);
        p.add(5, 3);
        System.out.println(""+p.toString());
        
    }

}
