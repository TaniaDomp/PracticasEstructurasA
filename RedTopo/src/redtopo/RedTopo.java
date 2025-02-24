/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package redtopo;
import java.util.ArrayList;
import java.util.Map;
import java.lang.Math;
import java.util.LinkedHashMap;
import org.javatuples.Pair;   //para ocupar la tupla de pares se debe agregar a las librerias el jar correspondiente
/**
 *
 * @author tania
 */
public class RedTopo {

    public static ArrayList<Pair> genRedTopo(int n, int m){ //genera los valores de la red, m = numero de relaciones y n = maximo numero de id
        ArrayList<Pair> red = new ArrayList<>();
        int k = 0;
        Pair<Integer, Integer> datos;
        int valor1, valor2;
        
        while(k < m){
            valor1 = (int)Math.floor(Math.random()*(n)+1); //genera valores del 1 al n
            valor2 = (int)Math.floor(Math.random()*(n)+1);
            datos = Pair.with(valor1, valor2);
            if(valor1 != valor2 && !red.contains(datos)){
                red.add(datos);
                k++;
            }
        }
        return red;
    }
    
    public static void main(String[] args) {
        //prueba de nodos
        /*NodoTopo nod1, nod2, nod3;
       
        nod1 = new NodoTopo(1);
        nod2 = new NodoTopo(2);
        nod3 = new NodoTopo(3);
       
        nod1.agregaSucesor(nod2);
        nod1.agregaSucesor(nod3);
        System.out.println(nod1);
        nod1.modificaPredSucesores();
        System.out.println(nod2);
        System.out.println(nod3);*/
        
        //prueba 1
        /*ArrayList<Pair> prueba = new ArrayList<>();
        Pair <Integer, Integer> p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17;

        p0 = Pair.with(9, 10);
        p1 = Pair.with(2, 4);
        p2 = Pair.with(1, 2);
        p3 = Pair.with(2, 7);
        p4 = Pair.with(5, 8);
        p5 = Pair.with(7, 10);
        p6 = Pair.with(6, 8);
        p7 = Pair.with(3, 7);
        p8 = Pair.with(2, 10);
        p9 = Pair.with(8, 10);
        p10 = Pair.with(5, 7);
        p11 = Pair.with(1, 4);
        p12 = Pair.with(2, 9);
        p13 = Pair.with(4, 5);
        p14 = Pair.with(3, 9);
        p15 = Pair.with(4, 8);
        p16 = Pair.with(1, 6);
        p17 = Pair.with(1, 3);
        prueba.add(p0);
        prueba.add(p1);
        prueba.add(p2);
        prueba.add(p3);
        prueba.add(p4);
        prueba.add(p5);
        prueba.add(p6);
        prueba.add(p7);
        prueba.add(p8);
        prueba.add(p9);
        prueba.add(p10);
        prueba.add(p11);
        prueba.add(p12);
        prueba.add(p13);
        prueba.add(p14);
        prueba.add(p15);
        prueba.add(p16);
        prueba.add(p17);
        RedTopologica r = new RedTopologica(prueba);
        System.out.println(r.toString());*/
        
        ArrayList<Pair> redN;
        redN = genRedTopo(15, 20);
        ArrayList<NodoTopo> lista = new ArrayList<>();
        
        //System.out.println(redN);
        RedTopologica r = new RedTopologica(redN);
        System.out.println(r.toString());
        
    }
    
}
