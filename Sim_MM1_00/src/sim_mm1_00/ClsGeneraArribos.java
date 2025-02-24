/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsGeneraArribos
{
    public ClsGenExponenciales genArribos;
    public ClsTemporizador temporizador;
    public ClsColaCltes colaCltes;
    private int cuantosCltes;
    public double tiempoLimite;

    ClsGeneraArribos()
    {
        cuantosCltes = 0;
        tiempoLimite = 0.0; // para evitar que se utilice sin este dato
    }

    public void generaArribo()
    {
        double tiempoArribo = ClsTemporizador.tiempoActual + genArribos.deltaT();
        temporizador.siembra(ClsEvento.eventoArribo(tiempoArribo));
    }

    public void arribaClte()
    {
       if( ClsTemporizador.tiempoActual <= this.tiempoLimite  )
       {
           generaArribo();
       }

       cuantosCltes++;
       ClsCliente clte = new ClsCliente(cuantosCltes);
       System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " llegada del " + clte );
       colaCltes.forma(clte);
    }
    
    public double promedioT(){
        double tiempo = ClsTemporizador.tiempoActual;
        double promedio = tiempo / cuantosCltes;
        return promedio;
    }
}
