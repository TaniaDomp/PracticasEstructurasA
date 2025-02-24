/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amc0_24;

/**
 *
 * @author RGAMBOAH
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Asa_AMCO24 asa = new Asa_AMCO24();
       
       /*
       int k[] = {8,-2,200,34,-50,22,70,1000,235};
       for(int t = 0;t < k.length; t++)
           asa.agrega(k[t]);
        System.out.println("asa:" + asa);
        */
       int colisiones  = 0;
       int almacenados = 0;
       int INTENTOS    = 10000;
        for( int t = 0; t < INTENTOS; t++)
            if(asa.agrega((int)( 100000.0 * ( -1.0 + 2.0 * Math.random()))))
                almacenados++;
            else
                colisiones++;
        
        System.out.println("        Almacenados:" + almacenados);
        System.out.println("         Colisiones:" + colisiones);
        System.out.println("              Total:" + (almacenados + colisiones));
        System.out.println("Intentos realizados:" + INTENTOS);
        
        //System.out.println("asa:" + asa);
    }
    
}
