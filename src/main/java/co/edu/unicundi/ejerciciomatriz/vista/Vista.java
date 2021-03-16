/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.ejerciciomatriz.vista;

import co.edu.unicundi.ejerciciomatriz.modelo.Matriz;
import java.util.Scanner;

/**
 *
 * Clase que interactúa con el usuario.
 * @author  César Rodríguez
 * @author  Diego Cobos
 * @since   1.0
 * @version 1.0.4
 * 
 */
public class Vista {
   /* Creamos un método que representará la interacción con el usuario y mostrará 
   los métodos correspondientes del modelo*/
   /**
    * Método encargado de interactuar con el usuario (mostrar menú y matrices).
    */
   public void menu(){
        //Creamos un objeto de la clase "Scanner" para usar la lectura de datos por consola.
        Scanner consola = new Scanner(System.in);
   
        // Creamos un objeto de la clase "Matriz" para acceder a los métodos del mismo.
        Matriz modelo = new Matriz();
        
        /*Se inicializan las variables que contendran las respuestas para
        ejecutar el "switch" y "while"*/
        byte opcionSwitch;
        byte opcionWhile;
        
        System.out.println("!!!Bienvenido¡¡¡\nEl programa que se presentará a continuación"
                            + " te ayudará a hayar el determinante y la inversa de una matriz 3x3.\n"
                +             "Nota: Este programa es únicamente de uso académico. Solo se pueden ingresar valores enteros o decimales.");
        System.out.println("\nPara generar la matriz, por favor ingrese los valores de las "
                            + "siguentes posiciones:\n");
        
        //Se realiza un ciclo "do" para la funcionaidad del menú de usuario.
        do{
            /* Se accede, a través de una instacia de la clase "Matriz", al método
            "crear()."*/ 
            modelo.crear();

            /* Se accede, a través de una instacia de la clase "Matriz", al método
            "mostrarOriginal()."*/ 
            modelo.mostrarOriginal();

            /* Se accede, a través de una instacia de la clase "Matriz", al método
            "determinanteOriginal()."*/ 
            modelo.calcularDeterminante();
            
            /* Se proporciona un menú de opciones y se guarda la elección del usuario
            en la variable "opcionSwitch"*/
            System.out.println("Elija la opción que desee:\n\t1. Mostrar matriz inversa.\n\t2. ¿Desea repetir la matriz?.");
            
            /* Nota: Para capturar el dato ingresado por el usuario a través de 
            la consola, se usa el objeto "consola" (creado inicialmente) y el 
            método de "nextByte()" de la clase "Scanner"*/
            opcionSwitch = consola.nextByte(); 
            
            /*Se crea un switch para generar el menú*/
            switch(opcionSwitch){
                case 1:
                    modelo.generarInversa();
                    break;
                case 2:
                    modelo.crear();
                    modelo.mostrarOriginal();
                    modelo.calcularDeterminante();
                    break;
            }
            System.out.println("Desea ingresar otra matriz? 1. Si    2. No");
            opcionWhile = consola.nextByte();
        }while(opcionWhile == 1);
   }
}
