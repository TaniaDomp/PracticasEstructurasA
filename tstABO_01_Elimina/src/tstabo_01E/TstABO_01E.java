package tstabo_01E;

/**
 *
 * @author psdist
 */


public class TstABO_01E 
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
        int CUANTOS_DATOS = 150;
        int x[] = new int[1];
        int w;
        
        AB_0E ab = new AB_0E();
        
        ALEATORIZA = true;
        long estado = 42;
        java.util.Random rnd_gen = iniciaGenerador(estado);
        try
        {
        ab.agrega(8);
        ab.agrega(-3);
        ab.agrega(2);
        ab.agrega(80);
        ab.agrega(25);
        ab.agrega(4);
        }
        catch (Exception e)
        {}
        
        for( int k = 1; k <= CUANTOS_DATOS; k++)
        {
           w = rnd_gen.nextInt(200);
           if(ab.contiene(w))
                System.out.println("El arbol ya contiene la llave " + w );
           else
             try
             {
                System.out.println("Se agrega " + w);
                ab.agrega(w);
             }
             catch (Exception e)
             {
               System.out.println(e.toString());
             }
           
           ab.menor(x);
           System.out.println("menor:" + x[0]);
           ab.mayor(x);
           System.out.println("mayor:" + x[0]);
           System.out.println("Son " +ab.cuantasClaves() + " claves");
        }
        
        System.out.println(ab);
        
        for( int k = 1; k <= 5; k++)
        {
          if(ab.eliminaMenor(x))
            System.out.println("Se eliminó el " + x[0]);
          else
            System.out.println("No hay datos en el arbol...");
        }
        System.out.println("\nABO en recorrido ascendente:" + ab);

        for( int k = 1; k <= 5; k++)
        {
          if(ab.eliminaMayor(x))
            System.out.println("Se eliminó el " + x[0]);
          else
            System.out.println("No hay datos en el arbol...");
        }
        System.out.println("\nABO en recorrido ascendente:" + ab);

        System.out.println("Son " + ab.cuantasClaves() + " llaves");
        int z[] = {56,102,119,1372,125};
        for( int k = 0; k < z.length; k++)
          if(ab.elimina(z[k]))
            System.out.println("Se eliminó el " + z[k]);
        else
            System.out.println("No existe el " + z[k]);
        
        System.out.println("\nABO en recorrido ascendente:" + ab);
        System.out.println("Son " + ab.cuantasClaves() + " llaves");
        
        System.out.println("-------------------------------------------");
        int y[] =ab.obtenArreglo();
        for( int k = 0; k < y.length; k++)
            System.out.println("y[" + k + "]:" + y[k]);
        
        //System.out.println("ABO en recorrido descendente:" + ab.toStringRev());
        //System.out.println("ABO en recorrido inFijoRID:" + ab.toStringIn());
        //System.out.println( ab.toStringBreadth());
        
        
    }
    
}
