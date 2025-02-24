/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsTemporizador
{
    // el tiempo actual lo lleva el temporizador como variable static
    public static double tiempoActual;

    java.util.PriorityQueue< ClsEvento> scheduler ;

    ClsTemporizador()
    {
        scheduler = new java.util.PriorityQueue<ClsEvento>(100,new ClsComparaEventos());
        tiempoActual = 0.0;
    }

    public void siembra(ClsEvento e)
    {
        scheduler.add(e);
    }

    public ClsEvento sigEvento()
    {
        ClsEvento ev;
        ev = scheduler.poll();
        if(ev != null)
            tiempoActual = ev.getTiempo();
        return ev;
    }

    public boolean hayEventos()
    {
        return !scheduler.isEmpty();
    }

   public static void main(String args[])
   {
      // Test del scheduler
      ClsEvento e;
      int i,n;
      ClsTemporizador temporizador = new ClsTemporizador();


      n = 100;
      for(i = 1; i <= n; i++ )
      {
          if( Math.random() < 0.5 )
             e = ClsEvento.eventoSalidaDeEstacion(250.0 * Math.random());
          else
             e = ClsEvento.eventoArribo(250.0 * Math.random());

          temporizador.siembra(e);
          System.out.println("Sembrando el evento " + i + "-ésimo: " + e );
      }
      System.out.println("========= Obteniendo eventos del temporizador =========");
      e = temporizador.sigEvento();
      i = 0;
      while( e != null )
      {
          i++;
          System.out.println( i + " Se obtuvo el evento " + e);
          e = temporizador.sigEvento();
      }

       System.out.println("========== fin de la extracción ========================");
       
       
   }


}
