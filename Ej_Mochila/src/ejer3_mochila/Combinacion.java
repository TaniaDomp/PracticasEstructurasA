/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3_mochila;

import java.util.Arrays;

/**
 *
 * @author RGAMBOAH
 */
public class Combinacion implements Comparable 
{
    public static double[] valorArticulo;
    public static double[] pesoArticulo;
    public static int num_articulos;
    public static double dblCapacidadPesoMax;
    public static int articuloObligatorio1;
    public static int articuloObligatorio2;
    public static int articuloObligatorio3;
    
    public static java.util.ArrayList<Combinacion> col_combinaciones;
    
    public static void asigna_pesos_valores_articulos(double v[],
                                                      double w[],
                                                      double capMax,
                                                      int artiOb1,
                                                      int artiOb2,
                                                      int artiOb3)
    {
        valorArticulo       = Arrays.copyOf(v,v.length);
        pesoArticulo        = Arrays.copyOf(w,w.length);
        num_articulos       = v.length;
        dblCapacidadPesoMax = capMax;
        articuloObligatorio1 = artiOb1 - 1;
        articuloObligatorio2 = artiOb2 - 1;
        articuloObligatorio3 = artiOb3 - 1;
        col_combinaciones   = new java.util.ArrayList<Combinacion>();
    }
    
    public static void agregaCombinacion(int num)
    {
        Combinacion com = new Combinacion(num);
        if(!com.strCombinacion.contains("no valida")){   //se descartan las combinaciones que no cumplen con los requerimientos * 
            col_combinaciones.add(com);
        }
    }
    
    String strCombinacion;
    double peso,valor;
    
    public Combinacion(int num)
    {
       int m = num;
       int esta;
       peso  = 0.0;
       valor = 0.0;
       int intchr0 = (int)('0');
       StringBuilder sb = new StringBuilder();
       for(int k = 0; k < Combinacion.num_articulos; k++ )
       { 
           esta = m % 2;
           peso  += esta * pesoArticulo[k];
           valor += esta * valorArticulo[k]; 
           sb.append((char)(intchr0 + esta ));
           m /= 2;
       }
       if(String.valueOf(sb.charAt(articuloObligatorio1)).equals("1") && String.valueOf(sb.charAt(articuloObligatorio2)).equals("1") && String.valueOf(sb.charAt(articuloObligatorio3)).equals("1") && peso <= dblCapacidadPesoMax){
           strCombinacion = (new String(sb));
       }
       else{
           strCombinacion = "no valida"; //en este if se decide si la combinacion es valida o no
       }
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strCombinacion);
        sb.append(", peso:");
        sb.append(this.peso);
        sb.append(", valor:");
        sb.append(this.valor);
        
        return(new String(sb));
    }
    
    public static void imprimeColComb()
    {
        int k = 0;
        for(Combinacion c : col_combinaciones)
        {
            k++;
            System.out.printf("%6d --> ", k );
            System.out.println(c);
        }
    }
    @Override
    public int compareTo(Object obj) 
    {
       int res; 
       if( obj == null) return -1;
       else
       {
         if(this.valor <   ((Combinacion)obj).valor ) 
             res = -1;
         else
           if(this.valor ==  ((Combinacion)obj).valor )
               res =  0;
           else
               res =  1;
       }
       return res;               
    }

}
