/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 * 
  * ===========================================================================
 *           COM 11103 EDA, SEGUNDO EXAMEN PARCIAL
 *           TEMA: Simulador simple
 * ============================================================================
 * COM 11103 Estructuras de Datos Avanzadas
 * Semestre agosto - diciembre 2022
 * Grupo 01
 * Segundo examen Parcial
 * Miércoles 19 de octubre de 2022
 * Duracion: 1:20 hr
 * 
 * Instrucciones:
 * 0) Trabaje todo en un solo directorio o carpeta, Al finalizar su trabajo o
 *    al terminarse el tiempo disponible empaque el directorio de trabajo en un
 *    .zip, .7z o .rar y súbalo a canvas.
 * 1) Para cada ejercicio usted debe narrar la idea, las herramientas y los
 *    detalles para implementar lo solicitado.
 * Tema: Simulador de una cola con una estación de servicio.
 * *****************************************************************************
 * NOTA: Para obtener estadísticas confiables debe tener al menos 250 casos.
 * *****************************************************************************
 * Ejercicio 1) Considere el tiempo que los clientes están en el sistema
 *              cola - estación de servicio, obtenga:
 *                      número de clientes que terminaron el proceso;
 *                      el tiempo promedio;
 *                      el tiempo máximo;
 *                      el tiempo mínimo;
 *                      la desviación estandar.
 * 
 * [0.5] 1.1) Describa en este espacio la estrategia para obtener lo solicitado:
 * 
 * 
 * [0.5] 1.2) Explique las herramientas y los detalles a utilizar:
 * Se toma el tiempo inicial desde ClsGeneraArribos(metodo arribaCliente)
 * Se toma el tiempo final desde ClsEstacionServicio(metodo atiendeCliente)
 * 
 * [1.5] 1.3) Programe lo solicitado.
 * 
 * *****************************************************************************
 * Ejercicio 2) Considere los tiempos de los clientes que entraron a la cola y
 *              que pasaron a ser atendidos en la estación.
 *              Obtenga:
 *              Cantidad de clientes en cola que pasaron a ser atendidos;
 *              tiempo promedio en cola;
 *              tiempo máximo en cola;
 *              tiempo mínimo en cola;
 *              desv estandar del tiempo en cola.
 * 
 * [0.5] 2.1) Describa en este espacio la estrategia para obtener lo solicitado:
 * 
 * 
 * [0.5] 2.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * Se toma el tiempo inicial desde ClsEstacionServicio(metodo atiendeCliente)
 * Se toma el tiempo final desde ClsEstacionServicio(metodo atiendeCliente)
 * 
 * [1.5] 2.3) Programe lo solicitado.
 * 
 * *****************************************************************************
 * Ejercicio 3) Similar al ejercicio 2 pero para los clientes que realmente
 *              esperaron en cola.
 * 
 * [1.0] 3.1) Describa en este espacio la estrategia para obtener lo solicitado:
 * 
 * 
 * [0.5] 3.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * 
 * 
 * [2.0] 3.3) Programe lo solicitado.
 * 
 * ***************************************************************************** 
 * Ejercicio 4) Obtenga el histórico de clientes en cola cada que ocurre
 *              algo en el sistema, en un reporte como el que sigue:
 *              Tiempo: 105.4, Cantidad de clientes en cola: 3
 *              Tiempo: 109.75, Cantidad de clientes en cola: 4
 *              etc.
 *              Nótese que de antemano no conoce la cantidad de registros que
 *              se tendrán, esta cantidad depende de la cantidad de eventos
 *              simulados.
 * 
 * [0.25] 4.1) Describa en este espacio la estrategia para obtener lo solicitado:
 * 
 * 
 * [0.25] 4.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * 
 * 
 * [1.0] 4.3) Programe lo solicitado.
 * El reporte se imprime en paralelo a los movimientos de la cola
 * 
 *  ===========================================================================
 *                 FIN DE LA NARRATIVA DE LOS EJERCICIOS
 * ============================================================================
 */
public class Main 
{
    // ==============================================================
    //  Asignar su CU y su nombre en las variables correspondientes
    // ==============================================================
    public static String strCU     = "200267";
    public static String strNomApp = "Tania Ariadna Dominguez Palma";
    // ==============================================================      
       
    public static boolean ALEATORIZA;
    public static boolean INFORMA = false;
        
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
      Main.ALEATORIZA = false;
      Main.INFORMA    = true;
        
      java.util.Random rndLlegadas   = Main.iniciaGenerador(42L);
      java.util.Random rndAtenciones = Main.iniciaGenerador(43L);
      
      double dblTiempoLimite        = 480.0;
      double deltaTPromedioLlegadas = 1.0;
      double deltaTPromedioAtencion = 0.75;

      ClsSim_MM1 mm1 = new ClsSim_MM1(dblTiempoLimite); // tiempo límite de 20.0 unidades
      mm1.asignaDeltaTArribos(deltaTPromedioLlegadas,rndLlegadas);
      mm1.asignaDeltaTAtenciones(deltaTPromedioAtencion,rndAtenciones);
      mm1.informa(Main.INFORMA);
      mm1.simula();
      
      System.out.println("--------------------------------------------------");
      System.out.println("Simulación terminada");
      System.out.println("==================================================");
      System.out.println("   CU:" + strCU + " ... " + strNomApp);
      System.out.println("==================================================");
      
      //calculo de las estadisticas
      System.out.println("======================INICIO DE LAS ESTADISTICAS========================");
      System.out.println("Numero de clientes que entraron en el sistema: " + mm1.clientesEnSis());
      System.out.println("Numero de clientes que esperaron en la cola: " + mm1.clientesConEspera());
      System.out.println("Numero de clientes que no esperaron en la cola: " + mm1.clientesEnSinEspera());
      System.out.println("Tiempo promedio en sistema: " + mm1.tiempoPromSis());
      System.out.println("Tiempo promedio de clientes que esperaron en la cola: " + mm1.tiempoPromCE());
      System.out.println("Tiempo promedio de clientes que no esperaron en la cola: " + mm1.tiempoPromSE());
      System.out.println("Tiempo maximo en el sistema: " + mm1.tiempoMaxSis());
      System.out.println("Tiempo minimo en el sistema: " + mm1.tiempoMinSis());
      System.out.println("Tiempo maximo en la cola: " + mm1.tiempoMaxCE());
      System.out.println("Tiempo minimo en la cola: " + mm1.tiempoMinCE());
      System.out.println("Tiempo maximo sin espera: " + mm1.tiempoMaxSE());
      System.out.println("Tiempo minimo sin espera: " + mm1.tiempoMinSE());
      System.out.println("Desviacion estandar en sistema: " + mm1.desvEstSis(mm1.tiempoPromSis()));
      System.out.println("Desviacion estandar en cola con espera: " + mm1.desvEstCE(mm1.tiempoPromCE()));
      System.out.println("Desviacion estandar en cola sin espera: " + mm1.desvEstSE(mm1.tiempoPromSE()));
    }

}
