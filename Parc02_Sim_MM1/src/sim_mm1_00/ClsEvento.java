/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsEvento
{
   private TipoEvento tipoDeEvento;

   private double tiempo;

   private ClsEvento( double aQueHora )
   {
       tiempo = aQueHora;
   }

   public static ClsEvento eventoArribo( double aQueTiempo)
   {
       ClsEvento evento = new ClsEvento( aQueTiempo );
       evento.tipoDeEvento = TipoEvento.ARRIBO;
       return evento;
   }


   public static ClsEvento eventoSalidaDeEstacion( double aQueTiempo)
   {
       ClsEvento evento = new ClsEvento( aQueTiempo );
       evento.tipoDeEvento = TipoEvento.SALIDA_DE_ESTACION;
       return evento;
   }

   public double getTiempo()
   {
       return tiempo;
   }

   public TipoEvento queEvento()
   {
       return tipoDeEvento;
   }
   public String toString()
   {
       return "Evento " + this.tipoDeEvento + " a las " + this.tiempo;
   }

}
