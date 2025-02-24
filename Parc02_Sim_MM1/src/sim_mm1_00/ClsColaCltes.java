/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

import java.util.ArrayList;

/**
 *
 * @author RGGH
 */
public class ClsColaCltes
{
    boolean blnInforma = true;
    
    java.util.PriorityQueue< ClsCliente> cola ;
    public ClsEstacionServicio estacion;

    ClsColaCltes()
    {
        cola = new java.util.PriorityQueue<ClsCliente>(100,new ClsComparaClientes());
    }

    public void informa(boolean informa)
    {
        this.blnInforma = informa;
    }
    
    public void forma(ClsCliente clte)
    {        
        if( this.blnInforma) System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Cola, formándose el " + clte);
        cola.add(clte);
        System.out.println("Tiempo: " + ClsTemporizador.tiempoActual + " Cantidad de clientes en cola: " + cola.size());
        if( estacion.desocupada() ){
            estacion.atiendeClte(cola.poll());
        }  
    }

    public ClsCliente sigClte()
    {
        return cola.poll();
    }

   public static void main(String args[])
   {
      // Test del scheduler
      ClsCliente c;
      int i,n;
      ClsColaCltes colaCltes = new ClsColaCltes();


      n = 100;
      for(i = 1; i <= n; i++ )
      {
          c = new ClsCliente(i);
          colaCltes.forma(c);
          System.out.println("Agregando a cola el cliente " + i + "-ésimo: " + c );
      }
       System.out.println("========= Vaciando la cola de clientes =========");

      i = 0;
      c = colaCltes.sigClte();
      while( c != null )
      {
          i++;
          System.out.println( i + " Se obtuvo el " + c);
          c = colaCltes.sigClte();
      }

       System.out.println("========== fin de la extracción ========================");

   }


}
