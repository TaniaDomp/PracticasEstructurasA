/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author RGGH
 */
public class ClsSim_MM1 
{
    private boolean blnInforma = true;
    
    public double dblDeltaTLlegadas; // Tiempo promedio entre llegadas
    public double dblDeltaT_Mu;      // Duración promedio de servicio en la estación de servicio
    private double dblLapsoTiempo;

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
    }

    public void informa(boolean informa)
    {
        this.blnInforma = informa;
        estacion.informa(informa);
        colaCltes.informa(informa);
        entrada.informa(informa);
        
    }
    
    
    public void asignaDeltaTArribos( double deltaT,java.util.Random rndLlegadas )
    {
        dblDeltaTLlegadas = deltaT;
        genArribos.asignaDeltaTpromedio(deltaT,rndLlegadas);
    }

    public void asignaDeltaTAtenciones( double deltaT,java.util.Random rndAtenciones )
    {
       dblDeltaT_Mu = deltaT;
       genAtenciones.asignaDeltaTpromedio(deltaT,rndAtenciones);
    }

    public void simula()
    {
      // se siembra el primer evento (a qué hora llega el primer cliente )
     ClsEvento ev;
     TipoEvento te;

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
                   break;
        }
     }
   }
    
    public int clientesEnSis(){
        return estacion.clientesEnSistema.size();
    }
    
    public int clientesEnSinEspera(){ 
        return estacion.clientesESCola.size();
    }
    
    public int clientesConEspera(){
        return estacion.clientesECCola.size();
    }
    
    public double tiempoPromSis(){
        double tiempoT = 0;
        
        for(int i = 0; i < estacion.clientesEnSistema.size(); i++){
            tiempoT += estacion.clientesEnSistema.get(i);
        }
        return tiempoT / estacion.clientesEnSistema.size();
    }
    
    public double tiempoPromCE(){
        double tiempoT = 0;
        
        for(int i = 0; i < estacion.clientesECCola.size(); i++){
            tiempoT += estacion.clientesECCola.get(i);
        }
        return tiempoT / estacion.clientesECCola.size();
    }
    
    public double tiempoPromSE(){
        double tiempoT = 0;
        
        for(int i = 0; i < estacion.clientesESCola.size(); i++){
            tiempoT += estacion.clientesESCola.get(i);
        }
        return tiempoT / estacion.clientesESCola.size();
    }
    
    public double tiempoMaxSis(){
        return Collections.max(estacion.clientesEnSistema);
    }
    
    public double tiempoMinSis(){
        return Collections.min(estacion.clientesEnSistema);
    }
    
    public double tiempoMaxCE(){
        return Collections.max(estacion.clientesECCola);
    }
    
    public double tiempoMinCE(){
        return Collections.min(estacion.clientesECCola);
    }
    
    public double tiempoMaxSE(){
        return Collections.min(estacion.clientesESCola);
    }
    
    public double tiempoMinSE(){
        return Collections.min(estacion.clientesESCola);
    }
    
    public double desvEstSis(double tiempoPromSis){
        double resul = -1;
        
        if(estacion.clientesEnSistema.size() > 0){
            resul = 0;
            double elem, resta;
            
            for(int i = 0; i < estacion.clientesEnSistema.size(); i++){
                resta = estacion.clientesEnSistema.get(i) - tiempoPromSis;
                elem = Math.pow(resta, 2);
                resul += elem;
            }
            resul /= (estacion.clientesEnSistema.size()-1);
            resul = Math.sqrt(resul);
        }
        return resul;
    }
    
    public double desvEstCE(double tiempoPromCE){
        double resul = -1;
        
        if(estacion.clientesECCola.size() > 0){
            resul = 0;
            double elem, resta;
            
            for(int i = 0; i < estacion.clientesECCola.size(); i++){
                resta = estacion.clientesECCola.get(i) - tiempoPromCE;
                elem = Math.pow(resta, 2);
                resul += elem;
            }
            resul /= (estacion.clientesECCola.size()-1);
            resul = Math.sqrt(resul);
        }
        return resul;
    }
    
    public double desvEstSE(double tiempoPromSE){
        double resul = -1;
        
        if(estacion.clientesESCola.size() > 0){
            resul = 0;
            double elem, resta;
            
            for(int i = 0; i < estacion.clientesESCola.size(); i++){
                resta = estacion.clientesESCola.get(i) - tiempoPromSE;
                elem = Math.pow(resta, 2);
                resul += elem;
            }
            resul /= (estacion.clientesESCola.size()-1);
            resul = Math.sqrt(resul);
        }
        return resul;
    }
}
