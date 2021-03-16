/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.ejerciciomatriz.modelo;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * Clase que contiene todos los métodos necesarios para generar una matriz 
 * y su respectiva inversa.
 * @author  César Rodríguez
 * @author  Diego Cobos
 * @since   1.0
 * @version 1.0.8
 * 
 */
public class Matriz {
    // Inicializamos y creamos el espacio en memoria de un arreglo(matriz) 3x3.
    /**
     * Inicialización del arreglo (matriz) principal y su respectiva longitud.
     */
    double[][] matriz = new double[3][3];
    
    // Inicializamos la variable que contendra el determinante de la matriz.
    /**
     * Indica el determinante de la matriz
     */
    double determinante;
    
    // Se inicializa la variable con la que se realizará el "casting".
    /**
     * Indica el valor resultante de un "casting" (double a int).
     */
    int conversionEntero = 0;
    
    // En esta sección de la clase, se crean los diferentes métodos para la matriz.
    /* El método "crearMatriz" contendra 2 ciclos "for" para capturar y llenar la matriz
    con los datos que el usuario ingrese. Además, será de tipo "String"*/
    /**
     * Método que recibe los valores ingresados por el usuario (consola)
     * y crea una matriz 3x3 con los mismos.
     */
    public void crear(){
        // Creamos un objeto de la clase "Scanner" para usar la lectura de datos por consola.
        Scanner consola = new Scanner(System.in);
        // Primer ciclo "for", el cuál, recorre las filas de la matriz.
        for(byte fila = 0; fila < matriz.length; fila++){
            System.out.println("*************************\nFila: "+fila);
            // Segundo ciclo "for", el cuál, recorre las columnas de la matriz.
            for(byte columna = 0; columna < matriz[fila].length; columna++){
                // Se solicita cada valor..
                System.out.println("Columna ["+columna+"] : ");
                // Se guarda cada valor en la posición correspondiente de la matriz.
                matriz[fila][columna] = consola.nextByte();
                if(((matriz[fila][columna])=='-')||((matriz[fila][columna])==' ')){
                    System.out.println("El valor ingresado no es un número");
                }
            }
        }
    }
    
    /* El método "mostrarMatrizOriginal" contendra 2 ciclos "for" para recorrer y mostrar 
    los datos de la matriz. Además, será de tipo "String"*/
    /**
     * Método que muestra la matriz 3x3 generada en el método "crear()".
     */
    public void mostrarOriginal(){
        // Primer ciclo "for", el cuál, recorre las filas de la matriz.
        for(byte fila = 0; fila < matriz.length; fila++){
            // Segundo ciclo "for", el cuál, recorre las columnas de la matriz.
            for(byte columna = 0; columna < matriz[fila].length; columna++){
                // Se muestra cada valor de la matriz.
                System.out.print("["+matriz[fila][columna]+"]");
            }
            System.out.println("");
        }
    }
    
    /**
     * Método que realiza el cálculo para hallar el determinante de la matriz.
     */
    public void calcularDeterminante(){
        double[][] matrizDet = new double[5][3];
        // Primer ciclo "for", el cuál, recorre las filas de la matriz.
        for(byte fila = 0; fila < matrizDet.length; fila++){
            // Segundo ciclo "for", el cuál, recorre las columnas de la matriz.
            for(byte columna = 0; columna < matrizDet[fila].length; columna++){
                /* En ésta sección se ingresan los valores de la matriz original
                en una matriz auxiliar, a través de un switch.*/
                switch(fila){
                    /* Nota: Ya que la matriz auxiliar tiene dos filas más
                    que la matriz original, se opta por duplicar las dos primeras
                    filas al final. Es decir, la fila tres y cuatro de la auxiliar
                    contienen los valores de la fila uno y dos de la original.*/
                    case 3:
                        matrizDet[fila][0] = matriz[0][0];
                        matrizDet[fila][1] = matriz[0][1];
                        matrizDet[fila][2] = matriz[0][2];
                        break;
                    case 4:
                        matrizDet[fila][0] = matriz[1][0];
                        matrizDet[fila][1] = matriz[1][1];
                        matrizDet[fila][2] = matriz[1][2];
                        break;
                    default:
                        matrizDet[fila][columna] = matriz[fila][columna];
                        break;
                }
            }
        }
        
        /* Se inicializan las variables correspondiente para guardar los valores
        para la determinante.*/
        double diagonalDescendente; 
        double diagonalAscendente;
        
        /*Se realizan las operaciones correspondientes de las diagonales 
        descendente de la matriz.*/
        diagonalDescendente = ((matrizDet[0][0]*matrizDet[1][1]*matrizDet[2][2])+
                               (matrizDet[1][0]*matrizDet[2][1]*matrizDet[3][2])+
                               (matrizDet[2][0]*matrizDet[3][1]*matrizDet[4][2]));
        /*Se realizan las operaciones correspondientes de las diagonales 
        ascendentes de la matriz.*/
        diagonalAscendente = ((matrizDet[4][0]*matrizDet[3][1]*matrizDet[2][2])+
                              (matrizDet[3][0]*matrizDet[2][1]*matrizDet[1][2])+
                              (matrizDet[2][0]*matrizDet[1][1]*matrizDet[0][2]));
        //Se realiza la resta entre las dos operaciones anteriores.
        determinante = (diagonalDescendente)-(diagonalAscendente);
        
        System.out.println("Determinante: "+Math.round(determinante));
    }
    
    /**
     * Método que encuentra la matriz inversa a través del sistema de determinantes.
     * Además, muestra dicha matriz.
     */
    public void generarInversa(){
        /* Creamos un objeto de la clase "DecimalFormat" para reducir la cantidad de 
           valores decimales*/
        DecimalFormat conversion = new DecimalFormat("###.##");
        
        double[][] inversa = new double[3][3];
        
        /*Aloja el valor de la inversa en la posición correspondiente y permite
        realizar la condición del "cero negativo"*/
        double solucionCeroNegativo;
        
        /* Si la determinante de la matriz original es cero, no se realiza
        la inversa de la misma.*/
        if( determinante!=0 ){
            // Encontramos la adjunta de la matriz de 3x3 y  se divide en la determiante.
            inversa[0][0]=((matriz[1][1]*matriz[2][2]-matriz[2][1]*matriz[1][2]));
            inversa[0][1] =(-(matriz[1][0]*matriz[2][2]-matriz[2][0]*matriz[1][2]));
            inversa[0][2] =((matriz[1][0]*matriz[2][1]-matriz[2][0]*matriz[1][1]));
            inversa[1][0]=(-(matriz[0][1]*matriz[2][2]-matriz[2][1]*matriz[0][2]));
            inversa[1][1]=((matriz[0][0]*matriz[2][2]-matriz[2][0]*matriz[0][2]));
            inversa[1][2]=(-(matriz[0][0]*matriz[2][1]-matriz[2][0]*matriz[0][1]));
            inversa[2][0]=((matriz[0][1]*matriz[1][2]-matriz[1][1]*matriz[0][2]));
            inversa[2][1]=(-(matriz[0][0]*matriz[1][2]-matriz[1][0]*matriz[0][2]));
            inversa[2][2]=((matriz[0][0]*matriz[1][1]-matriz[1][0]*matriz[0][1]));
        }else{
            System.out.println("La matriz ingresada no tiene inversa.");
        }
        //Se muestra la matriz inversa a través de dos ciclos "for".
        for (byte fila = 0; fila < inversa.length; fila++) {
            for (byte columna = 0; columna < inversa[fila].length; columna++) {
                /*Si el valor en la posición actual es entero y positivo, se realiza
                el "casting" de dicho valor a entero.*/
                if((( inversa[fila][columna] / determinante) % 1 == 0) && (( inversa[fila][columna] / determinante) > 0)){
                    /* Se realiza un "casting" de los números de la matriz a tipo "Entero"*/ 
                    conversionEntero = (int)(inversa[columna][fila]/determinante);
                    if(conversionEntero == (-0))
                        conversionEntero = 0;
                    System.out.print("["+(conversionEntero)+"]");
                }else{
                    /*Se encuentra el valor de la inversa de la posición actual*/
                    solucionCeroNegativo = inversa[columna][fila]/determinante;
                    /*Se evalúa si el valor actual es "-0" para cambiarlo por "0"*/
                    if(solucionCeroNegativo == (-0)){
                        solucionCeroNegativo = 0;
                    }
                    System.out.print("["+conversion.format(solucionCeroNegativo)+"]");
                }
                    
            }
            System.out.println();
        }
    }
    
}