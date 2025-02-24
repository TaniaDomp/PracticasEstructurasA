/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsEstacionServicio
{
    private ClsCliente clteEnAtencion;
    public ClsGenExponenciales genDeltaTServicio;
    public ClsTemporizador temporizador;
    public ClsColaCltes colaCltes;

    ClsEstacionServicio()
    {
        // inicializar aquí las estadísticas requeridas
        clteEnAtencion = null;
    }

    public void atiendeClte( ClsCliente clte )
    {
        double tiempoDeSalida;
        System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Estación de Servicio atendiendo al " + clte);
        // Se genera el tiempo a que saldrá este cliente
        tiempoDeSalida = ClsTemporizador.tiempoActual + genDeltaTServicio.deltaT();

        ClsEvento e = ClsEvento.eventoSalidaDeEstacion(tiempoDeSalida);
        temporizador.siembra(e);
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

        System.out.println("Tiempo " + ClsTemporizador.tiempoActual + " Estación de Servicio, liberada por el " + clteEnAtencion );
        clteEnAtencion = null;
        ClsCliente c = colaCltes.sigClte();
        if( c != null )
            this.atiendeClte(c);
    }
    
}
