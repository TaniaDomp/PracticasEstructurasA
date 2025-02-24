/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author RGGH
 */
public class TstClsProyectoT
{
public static void main(String[] args)
    {
        ClsProyectoT proy = new ClsProyectoT(1,"Proyecto 1", 10);
        

        System.out.println("Hola, uso de la clase ClsProyectoT");

        proy.agregaAct(1,2,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        proy.agregaAct(2,4,"Levantar muros y colar firme del piso",26,4,24325,5);
        proy.agregaAct(4,6,"Cimbra y armado de techo",25,3,9500,2);
        proy.agregaAct(2,10,"Colocar registros y drenaje exterior",21,2,57800,4);
        proy.agregaAct(4,8,"Instalación hidráulica y sanitaria",23,1,17325,5);
        proy.agregaAct(6,3,"Colar loza techo",50,2,12500,12);
        proy.agregaAct(1,3,"Acometida eléctrica",32,1,500,5);
        proy.agregaAct(3,5,"Ventanas y puertas",35,2,17500,14);
        proy.agregaAct(5,8,"Pintar muros y techo",36,3,3500,2);
        proy.agregaAct(7,5,"Permiso de color",0,1,0,3);
        proy.agregaAct(7,9,"Acometida de agua",23,1,2500,1);
        proy.agregaAct(9,4,"Conexión de agua",23,1,1500,1);
        proy.agregaAct(9,10,"Acometida de drenaje",21,2,2000,2);


        System.out.println("Estructura previa al ordenamiento:\n" + proy );
        //sal = st.ordena();
        proy.ordena();
        System.out.println("------------------------------------------");
        System.out.println("Estructura posterior al ordenamiento:\n" + proy );

        System.out.println("Estructura ordenada:\n" + proy );
        System.out.println("===========================================");
        double porcionCostoAlFinal = 0.50;
        System.out.println("Flujo de efectivo:\n" +
                            proy.obtenFlujoDeEfectivoT(porcionCostoAlFinal));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Flujo de efectivo por objeto ClsFlujoDeEfectivo:\n" +
                            proy.obtenFlujoDeEfectivoT(porcionCostoAlFinal));
        System.out.println("===========================================");
    }
}
