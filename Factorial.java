/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Oriol Casanova i Palmer
 * Mòdul 3 - Exercici lectura/escriptura
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int factorial;
        int numero;
        Scanner llegir = /*new Scanner(System.out)*/new Scanner(System.in);
        
        System.out.print("Introdueix un valor: ");
        numero = llegir.nextInt();
        llegir.nextLine();
        factorial = 1;
        /*i = numero; Al final no farà falta fer servir la i*/
        do{
           factorial = factorial * numero; 
           //i--; 
           numero--;
        }while(numero>1);
        
        System.out.println("El factorial és: "+factorial);         
    } 
}