/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mochila;

/**
 *
 * @author tania
 */
public class Proueba {

    public static void main(String[] args) {
        double[] valores = {5, 3, 8, 9, 10};
        double[] pesos = {11, 4, 3, 5, 10};
        Combinaciones objCom = new Combinaciones();
        
        System.out.println(objCom.mejoresCombinaciones(pesos, valores, 30, 1, 2, 3, 1));
    }
    
}
