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
    java.util.PriorityQueue< ClsCliente> cola ;
    public ClsEstacionServicio estacion;
    private double contClientesEnCola;
    private double contClientesEntrantesCola;
    private double tiempoFinalEspera;
    private double tiempoCola;
    private ArrayList<String> eventos;

    ClsColaCltes()
    {
        cola = new java.util.PriorityQueue<ClsCliente>(100,new ClsComparaClientes());
        contClientesEnCola =0;
        eventos = new ArrayList<>();
    }

    public void forma(ClsCliente clte)
    {
        double tiempo;
        System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Cola, formándose el " + clte);
        cola.add(clte);
        contClientesEntrantesCola++;
        if( estacion.desocupada() ){
            estacion.atiendeClte(cola.poll());
             tiempo = cola.poll().tiempoEn() - ClsTemporizador.tiempoActual;
             tiempoFinalEspera += tiempo;
             
        } 
        else{
            contClientesEnCola++;
            clte.tiempoEntrada = ClsTemporizador.tiempoActual;
            eventos.add("Tiempo" + ClsTemporizador.tiempoActual + ";" + cola.size());
        }
        
     
    }

    public double promedioEnCola(){
        return tiempoFinalEspera/contClientesEnCola;
    }
    
    public double promedioCola(){
        return tiempoCola/contClientesEntrantesCola;
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
