/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsSim_MM1 {
    public double dblDeltaTLlegadas; // Tiempo promedio entre llegadas
    public double dblDeltaT_Mu;      // Duración promedio de servicio en la estación de servicio
    private double dblLapsoTiempo;
    private double tiempoProm;
    private double tiempoMay;
    private double tiempoMin;

    private ClsGenExponenciales genArribos;
    private ClsGenExponenciales genAtenciones;
    private ClsGeneraArribos    entrada;
    private ClsColaCltes        colaCltes;
    private ClsEstacionServicio estacion;
    private ClsTemporizador     temporizador;

    ClsSim_MM1(double lapsoTiempo) // lapsoTiempo es el lapso de duración de la simulación
    {                              // Las unidades de tiempo serán minutos.
      dblLapsoTiempo = lapsoTiempo;
      genArribos     = new ClsGenExponenciales(1.0); // tiempo default promedio entre arribos
      genAtenciones  = new ClsGenExponenciales(0.75); // tiempo default promedio de duración de la atención

      entrada        = new ClsGeneraArribos();
      entrada.genArribos = genArribos;

      estacion = new ClsEstacionServicio();
      estacion.genDeltaTServicio = genAtenciones;

      temporizador          = new ClsTemporizador();

      colaCltes             = new ClsColaCltes();

      entrada.temporizador  = temporizador;
      entrada.tiempoLimite  = dblLapsoTiempo;
      entrada.colaCltes     = colaCltes;
      estacion.temporizador = temporizador;

      colaCltes.estacion = estacion;
      estacion.colaCltes = colaCltes;
      
      tiempoProm = 0;
      tiempoMay = 100000; //cambio a primera entrada 
    }

    public void asignaDeltaTArribos( double deltaT )
    {
        dblDeltaTLlegadas = deltaT;
        genArribos.asignaDeltaTpromedio(deltaT);
    }

    public void asignaDeltaTAtenciones( double deltaT )
    {
       dblDeltaT_Mu = deltaT;
       genAtenciones.asignaDeltaTpromedio(deltaT);
    }

    public void simula()
    {
      // se siembra el primer evento (a qué hora llega el primer cliente )
     ClsEvento ev;
     TipoEvento te;
     double tiempoSis;

     entrada.generaArribo();

      while( temporizador.hayEventos() )
      {
        ev = temporizador.sigEvento();
        te = ev.queEvento();

        switch( te )
        {
           case ARRIBO:
                   entrada.arribaClte();
                   break;

           case SALIDA_DE_ESTACION:
                   estacion.liberaEstacion();
                   tiempoSis = ev.tiempoEnSis();
                   tiempoProm += tiempoSis;
                   if(tiempoSis > tiempoMay){
                       tiempoMay = tiempoSis;
                   }
                   if(tiempoSis < tiempoMin){
                       tiempoMin = tiempoSis;
                   }
                   break;
        }
     }
   }
    
    public double tiempoMayor(){
        return tiempoMay;
    }
    
    public double tiempoMenor(){
        return tiempoMin;
    }
    
    public double tiempoSis(){
        return tiempoProm;
    }
}
