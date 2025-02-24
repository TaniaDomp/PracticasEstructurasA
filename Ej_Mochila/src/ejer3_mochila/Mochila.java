/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3_mochila;

/**
 *
 * @author Su 200267, Tania Ariadna Dominguez Palma.
 * El ejercicio consiste en:
 * 3.1) Completar el ejercicio para aplicar la maximización del valor
 *      considerando el límite de carga y los artículos pivote, para ello:
 * [2.0] 3.1.1) Explique aquí en prosa y en grandes bloques lo que hará tomado
 *        en consideración este código.
 * En el metodo Combinacion debemos evaluar si la combinacion tiene los objetos solicitados (si en la conversion se tienen los 1 correspondientes)
 * si es asi entonces lo guardamos dentro del ArrayList
 * [2.0] 3.1.2) Explicar los detalles para no considerar las combinaciones que 
 *        no tienen los tres artículos previamente convenidos.
 * Se pone un if en donde se indica si la commbinacion creada tiene los articulos, si es asi pasa el filtro
 * [1.0] 3.1.3) Explicar los detalles para no considerar las combinaciones que transgreden
 *        la restricción de peso máximo.
 * Se pone un if en donde se indica si el peso de la combinacion creada es menor o igual al peso, si es asi pasa el filtro
 * [3.0] 3.2)   Llevar a cabo las modificaciones comentando brevemente los cambios.
 * [1.0] 3.3)   Ejecutar el código en una ventana de dos y mandar la salida a un
 *        archivo de texto con el nombre Ejer3:Iniciales_AAAAMMDD_HHMMSS.txt
 * [1.0] 3.4)   Modificar el parámetro de aleatorización y proporcionar dos ejecuciones
 *        para 8 objetos;
 */
public class Mochila 
{
    // NOTA: Este valor se puede modificar en el main
    public static boolean ALEATORIZA = true;

    public static double[] generaDatos( int n, double datMin, double datMax)
    {
      long estado;

      if(ALEATORIZA)
          estado = (long)(1000.0 * Math.random()+1.0);
      else
          estado = 42;
      java.util.Random rndGen = new java.util.Random(estado);

      double datos[]   = new double[n];
      double deltaDat = datMax - datMin;
      for( int k = 0; k < n; k++)
          datos[k] = Math.floor(datMin + deltaDat * rndGen.nextDouble());
      return datos;
    }     
    
    public static void impArr(String strLetrero,double a[])
    {
        System.out.println("------------------------------");
        System.out.println("        " + strLetrero);
        System.out.println("------------------------------");
        for(int k = 0; k < a.length; k++)
        {
            System.out.print(strLetrero);
            System.out.printf("[%6d]:%8.0f",k+1,a[k]);
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String args[])
    {
        long t0,t1,delta_t; 
        int n, artiObj1, artiObj2, artiObj3;
        
        Mochila.ALEATORIZA = true;

        if( args.length > 3){
            n = Integer.valueOf(args[0]);
            artiObj1 = Integer.valueOf(args[1]);
            artiObj2 = Integer.valueOf(args[2]);;
            artiObj3 = Integer.valueOf(args[3]);;
        } 
        else{
            n = 5;
            artiObj1 = 4;
            artiObj2 = 2;
            artiObj3 = 3;
        }
           
        
        double pesos[]   = Mochila.generaDatos(n, 50.0, 200.0); //{1.0,2.0,3.0,4.0};
        double valores[] = Mochila.generaDatos(n,100.0,500.0); //{10.0,20.0,30.0,40.0};
        double capMax    = 550.0;

        Mochila.impArr("Pesos", pesos);
        Mochila.impArr("Valores", valores);
        
        Combinacion.asigna_pesos_valores_articulos(valores, pesos, capMax, artiObj1, artiObj2, artiObj3);
        
        for( int k = 1; k < (int)(Math.pow(2.0,n)); k++)
            Combinacion.agregaCombinacion(k);

       System.out.println("------------------------------------------");
       System.out.println("                Pre Ordenamiento");
       System.out.println("------------------------------------------"); 
       Combinacion.imprimeColComb();
       t0 = System.nanoTime();
       java.util.Collections.sort(Combinacion.col_combinaciones);
       t1 = System.nanoTime();
       delta_t = t1 - t0;
       System.out.println("------------------------------------------");
       System.out.println("                Post Ordenamiento");
       System.out.println("------------------------------------------"); 
       Combinacion.imprimeColComb();
       System.out.println("n:" + n + ",Delta_t:" + delta_t + " nanoSeg");
        
    }
    
}
