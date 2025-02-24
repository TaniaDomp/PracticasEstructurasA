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
public class ClsEstacionServicio
{
    private boolean blnInforma = true;
    
    private ClsCliente clteEnAtencion;
    public ClsGenExponenciales genDeltaTServicio;
    public ClsTemporizador temporizador;
    public ClsColaCltes colaCltes;
    public ArrayList<Double> clientesEnSistema;
    public ArrayList<Double> clientesECCola;
    public ArrayList<Double> clientesESCola;

    ClsEstacionServicio()
    {
        // inicializar aquí las estadísticas requeridas
        clientesEnSistema = new ArrayList(); //guarda los tiempos totales de los clientes
        clientesECCola = new ArrayList();
        clientesESCola = new ArrayList();
        clteEnAtencion = null;
    }
    
    public void informa(boolean informa)
    {
        this.blnInforma = informa;
    }

    public void atiendeClte( ClsCliente clte )
    {
        double tiempoDeSalida;
        
        if(this.blnInforma){
            System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Estación de Servicio atendiendo al " + clte);
            System.out.println("Tiempo: " + ClsTemporizador.tiempoActual + " Cantidad de clientes en cola: " + colaCltes.cola.size());
            clte.tiempoEntrada = ClsTemporizador.tiempoActual;
        }

        // Se genera el tiempo a que saldrá este cliente
        tiempoDeSalida = ClsTemporizador.tiempoActual + genDeltaTServicio.deltaT();

        ClsEvento e = ClsEvento.eventoSalidaDeEstacion(tiempoDeSalida);
        temporizador.siembra(e);
        
        clientesEnSistema.add(tiempoDeSalida - clte.tiempoInicial); //se guarda el tiempo total del cliente
        if(clte.tiempoEntrada == clte.tiempoInicial){
            clientesECCola.add(tiempoDeSalida - clte.tiempoEntrada);
        }
        else{
            clientesESCola.add(tiempoDeSalida - clte.tiempoEntrada);
        }
        clteEnAtencion = clte;
    }
    
    public boolean desocupada() { return (clteEnAtencion == null);}
    public boolean ocupada() { return !this.desocupada();}

    public void liberaEstacion()
    {
        //
        // ya se ha actualizado el tiempo actual
        // reviso si hay clientes en cola para ser atendidos:
        //

        if(this.blnInforma){
            System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Estación de Servicio, liberada por el " + clteEnAtencion );
            System.out.println("Tiempo: " + ClsTemporizador.tiempoActual +" Cantidad de clientes en cola: " + colaCltes.cola.size());
        }
        clteEnAtencion = null;
        ClsCliente c = colaCltes.sigClte();
        if( c != null )
            this.atiendeClte(c);
    }

}
