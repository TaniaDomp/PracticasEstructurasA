/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 * Tania Ariadna Dominguez Palma 200267
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
 * Para obtener el numero de clientes que terminaron el proceso tenemos que contar cuandos clientes salieron de la estacion, asi que podemos
 * contarlos en el switch que identifica que tipo de evento se registra en el simulador (solo se cuentan los SALIDA_DE_ESTACION).
 * 
 * Para obtener el promedio del tiempo que los clientes estuvieron en el sistema podemos medir el tiempo en que el evento se crea como un arribo
 * y en el que se crea como una salida, hacemos la resta entre los dos y eso lo sumamos a una variable que mida el tiempo de todos los eventos
 * , posteriormente se divide entre el total de clientes que terminaron el proceso (ClsEvento)
 * 
 * Para el tiempo maximo y minimo podemos guardar la resta de los tiempos y compararla con los tiempos de los otros eventos.
 * 
 * **desviacion estandar
 * 
 * [0.5] 1.2) Explique las herramientas y los detalles a utilizar:
 * Para el numero de clientes que terminan se forman en la cola contamos los clientes que no pasaron a una estacion desocupada (ClsColaClientes)
 * 
 * Para obtener el promedio se añaden tres variables double que midan el tiempo de creacion, salida de cada evento y la resta de ambas, tambien se
 * crea un contador para sumar estos tiempos y al final se divide entre los clientes totales (clase ClsSim).
 * 
 * Se compara la variable de la resta de los eventos y se compara con los demas (clase ClsSim).
 * 
 * [1.5] 1.3) Programe lo solicitado. (cambios en la clase ClsSim y ClsEvento)
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
 * Para el numero de clientes que terminan se forman en la cola contamos los clientes que usaron el metodo forma (ClsColaClientes)
 * 
 * Cuando el cliente se atienda (ClsEstacion) recuperamos el tiempo en el que saldra y lo sumamos en un contador, posteriormente lo dividimos
 * entre el numero de clientes que entran a la cola
 * 
 * Guardamos el tiempo que tarda en atender el cliente y lo comparamos con variables que guarden el tiempo menor y mayor
 * 
 * **desv estandar
 * 
 * 
 * [0.5] 2.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * Usamos un contador en ClsColaCltes y si la cola no esta desocupada tenemos que contar al cliente
 * 
 * En la clase ClsEstacion servicio generamos una variable que regrese el tiempo, lo contamos y luego hacemos un metodo que divida le tiempo
 * entre los cleientes de la cola
 * 
 * Hacemos una comparacion entre la resta de las variables del tiempo y definimos cual es mayor y cual menor
 * 
 * 
 * [1.5] 2.3) Programe lo solicitado.
 * 
 * *****************************************************************************
 * Ejercicio 3) Similar al ejercicio 2 pero para los clientes que realmente
 *              esperaron en cola.
 * 
 * [1.0] 3.1) Describa en este espacio la estrategia para obtener lo solicitado:
 * Para el numero de clientes que terminan se forman en la cola contamos los clientes que no pasaron a una estacion desocupada (ClsColaClientes)
 * 
 * Cuando el cliente entre a la cola guardamos el dato en el cliente, cuando la cola se desocupe restamos al tiempo actual el tiempo de entrada 
 * con un contador lo guardamos y lo dividimos entre los clientes que estuvieron en la cola.
 * 
 * Guardamos el dato de la resta en una variable y luego comparamos con los demas tiempos en cola (para maximo y minimo)
 * 
 * [0.5] 3.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * En la clase ClsEstacion Servicio usamos un contador que regrese los clientes que entran
 * 
 * Cuando se obtenga el tiempo de espera se mete a un contador y lo dividimos entre el total de clientes. 
 * 
 * Se hace una comparacion entrelas variables del tiempo maximo y minimo 
 * 
 * **desv estandar
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
 * Se registran los cambios que entran en la cola, cuando la cola se llena se registra el evento
 * 
 * [0.25] 4.2) Explique las técnicas y herramientas a utilizar para tal objetivo:
 * En un Array se guardan los eventos solicitados, se imprime en el Main para mandarlo a un archivo
 * 
 * [1.0] 4.3) Programe lo solicitado.
 * 
 * 
 *  ===========================================================================
 *                 FIN DE LA NARRATIVA DE LOS EJERCICIOS
 * ============================================================================
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      double dblTiempoLimite        = 480.0;
      double deltaTPromedioLlegadas = 1.0;
      double deltaTPromedioAtencion = 0.75;

      if(args.length > 1){
          deltaTPromedioLlegadas = Double.parseDouble(args[0]);
          deltaTPromedioAtencion = Double.parseDouble(args[1]);
      }
      ClsSim_MM1 mm1 = new ClsSim_MM1(dblTiempoLimite); // tiempo límite de 20.0 unidades
      mm1.asignaDeltaTArribos(deltaTPromedioLlegadas);
      mm1.asignaDeltaTAtenciones(deltaTPromedioAtencion);

      mm1.simula();

      
    }

}
