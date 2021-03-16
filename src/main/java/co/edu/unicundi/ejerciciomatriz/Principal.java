/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.ejerciciomatriz;

import co.edu.unicundi.ejerciciomatriz.vista.Vista;

/**
 *
 * Clase encargada de ejecutar la aplicación.
 * @author  César Rodríguez
 * @author  Diego Cobos
 * @since   1.0
 * @version 1.0.1
 * 
 */
public class Principal {
    /**
    * Este método se encarga de iniciar la ejecución del programar
    * @param args[] es un arreglo con los parámetros que el reciba por consola
    */
    public static void main(String[] args) {
        Vista vista = new Vista();
        vista.menu();
    }
}
