/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abobal;

/**  Estudio de densidades y eliminaciones
 *
 * @author rggh
 */
public class Main 
{
        public static boolean ALEATORIZA;

    public static java.util.Random iniciaGenerador(long edo)
    {
        long estado;
        if(ALEATORIZA)
          estado = (long)(1000.0 * Math.random()+1.0);
        else
          estado = edo;
        
        java.util.Random rndGen = new java.util.Random(estado);
        return rndGen;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       AsaAbo asa = new AsaAbo();
        
       ALEATORIZA = true;
       boolean EN_SECUENCIA = false;
       long estado = 42;
       java.util.Random rnd_gen = iniciaGenerador(estado); 

        // Caso base de rotación a la derecha:
/*
        asa.agrega(5);
        asa.agrega(6);
        asa.agrega(3);
        asa.agrega(4);
        asa.agrega(2);
        asa.agrega(1);
 */

        // Caso base de rotación a la izquierda
 /*
        asa.agrega(2);
        asa.agrega(1);
        asa.agrega(4);
        asa.agrega(3);
        asa.agrega(5);
        asa.agrega(6);
*/
        
        // Caso base de rotación Izquierda Derecha
/*
        asa.agrega(5);
        asa.agrega(2);
        asa.agrega(6);
        asa.agrega(1);
        asa.agrega(3);
        asa.agrega(4);
*/
       // Caso base de rotación Derecha Izquierda
/*
        asa.agrega(2);
        asa.agrega(1);
        asa.agrega(5);
        asa.agrega(4);
        asa.agrega(3);
        asa.agrega(6);
*/
        int n, i, A, B, x, numColisiones = 0;
        long numNodos;

       //int[] a = {220,24,2,378,313,212,222,409,105,405};
       // int[] a = {8,4,2,1,3,6,5,7,12,10,9,11,14,13,15};
       int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
       n = a.length;
       if( EN_SECUENCIA )
        for( i = 0; i < n; i++)
        {
              System.out.println("Se agregará el " + a[i] );
            asa.agrega(a[i]);
            //
            System.out.println(asa);
        }
        else
        {    
            n = 10000;
            A = 50000;
            B = 1;
        
            for (i = 1; i <= n; i++)
            {
                x = (int) (B + (A - B) * rnd_gen.nextDouble());
                if (!asa.agrega(x))
                {
                    System.out.println("Colisión al agregar el " + x);
                    numColisiones++;
                } else
                {
                    System.out.println("                              Se agreg+o el " + x);
                }
        }
    
       }   
           
       System.out.println(asa);
        System.out.println("--------------------------------------------------");
       if( asa.verificaAlturas())
            System.out.println("OK");
       else
            System.out.println("Problemas con las alturas...");

        numNodos = asa.numNodos();
        System.out.println("El AboBal tiene " + numNodos + " nodos");
        System.out.println("Se agregaron " + n + " nodos y hubo " + numColisiones + " colisiones.");
        System.out.println("numNodos + numColisiones: " + numNodos + " + " + numColisiones + " = " +
                           ( numNodos + numColisiones ) );
        System.out.println("Altura del arbol:" + asa.h());
              
    }

}
