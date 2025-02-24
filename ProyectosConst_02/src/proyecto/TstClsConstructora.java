/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author RGGH
 */
public class TstClsConstructora
{
    public static void main(String args[])
    {
       ClsConstructora ica = new ClsConstructora("ICA S.A.");

        ica.agregaProyecto(1,"Casa No. 1",1);
        ica.agregaAct(1,1,2,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        ica.agregaAct(1,2,4,"Levantar muros y colar firme del piso",26,4,24325,5);
        ica.agregaAct(1,4,6,"Cimbra y armado de techo",25,3,9500,2);
        ica.agregaAct(1,2,10,"Colocar registros y drenaje exterior",21,2,57800,4);
        ica.agregaAct(1,4,8,"Instalación hidráulica y sanitaria",23,1,17325,5);
        ica.agregaAct(1,6,3,"Colar loza techo",50,2,12500,12);
        ica.agregaAct(1,1,3,"Acometida eléctrica",32,1,500,5);
        ica.agregaAct(1,3,5,"Ventanas y puertas",35,2,17500,14);
        ica.agregaAct(1,5,8,"Pintar muros y techo",36,3,3500,2);
        ica.agregaAct(1,7,5,"Permiso de color",0,1,0,3);
        ica.agregaAct(1,7,9,"Acometida de agua",23,1,2500,1);
        ica.agregaAct(1,9,4,"Conexión de agua",23,1,1500,1);
        ica.agregaAct(1,9,10,"Acometida de drenaje",21,2,2000,2);


        ica.agregaProyecto(2,"Casa No. 2",10);
        ica.agregaAct(2,2,4,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        ica.agregaAct(2,4,8,"Levantar muros y colar firme del piso",26,4,24325,5);
        ica.agregaAct(2,8,12,"Cimbra y armado de techo",25,3,9500,2);
        ica.agregaAct(2,4,20,"Colocar registros y drenaje exterior",21,2,57800,4);
        ica.agregaAct(2,8,16,"Instalación hidráulica y sanitaria",23,1,17325,5);
        ica.agregaAct(2,12,6,"Colar loza techo",50,2,12500,12);
        ica.agregaAct(2,2,6,"Acometida eléctrica",32,1,500,5);
        ica.agregaAct(2,6,10,"Ventanas y puertas",35,2,17500,14);
        ica.agregaAct(2,10,16,"Pintar muros y techo",36,3,3500,2);
        ica.agregaAct(2,14,10,"Permiso de color",0,1,0,3);
        ica.agregaAct(2,14,18,"Acometida de agua",23,1,2500,1);
        ica.agregaAct(2,18,8,"Conexión de agua",23,1,1500,1);
        ica.agregaAct(2,18,20,"Acometida de drenaje",21,2,2000,2);

        ica.agregaProyecto(3,"Casa No. 3",15);
        ica.agregaAct(3,3,6,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        ica.agregaAct(3,6,12,"Levantar muros y colar firme del piso",26,4,24325,5);
        ica.agregaAct(3,12,18,"Cimbra y armado de techo",25,3,9500,2);
        ica.agregaAct(3,6,30,"Colocar registros y drenaje exterior",21,2,57800,4);
        ica.agregaAct(3,12,24,"Instalación hidráulica y sanitaria",23,1,17325,5);
        ica.agregaAct(3,18,9,"Colar loza techo",50,2,12500,12);
        ica.agregaAct(3,3,9,"Acometida eléctrica",32,1,500,5);
        ica.agregaAct(3,9,15,"Ventanas y puertas",35,2,17500,14);
        ica.agregaAct(3,15,24,"Pintar muros y techo",36,3,3500,2);
        ica.agregaAct(3,21,15,"Permiso de color",0,1,0,3);
        ica.agregaAct(3,21,27,"Acometida de agua",23,1,2500,1);
        ica.agregaAct(3,27,12,"Conexión de agua",23,1,1500,1);
        ica.agregaAct(3,27,30,"Acometida de drenaje",21,2,2000,2);

        ica.agregaProyecto(4,"Casa No. 4",30);
        ica.agregaAct(4,1,2,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        ica.agregaAct(4,2,4,"Levantar muros y colar firme del piso",26,4,24325,5);
        ica.agregaAct(4,4,6,"Cimbra y armado de techo",25,3,9500,2);
        ica.agregaAct(4,2,10,"Colocar registros y drenaje exterior",21,2,57800,4);
        ica.agregaAct(4,4,8,"Instalación hidráulica y sanitaria",23,1,17325,5);
        ica.agregaAct(4,6,3,"Colar loza techo",50,2,12500,12);
        ica.agregaAct(4,1,3,"Acometida eléctrica",32,1,500,5);
        ica.agregaAct(4,3,5,"Ventanas y puertas",35,2,17500,14);
        ica.agregaAct(4,5,8,"Pintar muros y techo",36,3,3500,2);
        ica.agregaAct(4,7,5,"Permiso de color",0,1,0,3);
        ica.agregaAct(4,7,9,"Acometida de agua",23,1,2500,1);
        ica.agregaAct(4,9,4,"Conexión de agua",23,1,1500,1);
        ica.agregaAct(4,9,10,"Acometida de drenaje",21,2,2000,2);

        ica.agregaProyecto(5,"Casa No. 5",25);
        ica.agregaAct(5,2,4,"Excavación de zanjas y colocar cimientos y drenaje interior",21,4,50567,12);
        ica.agregaAct(5,4,8,"Levantar muros y colar firme del piso",26,4,24325,5);
        ica.agregaAct(5,8,12,"Cimbra y armado de techo",25,3,9500,2);
        ica.agregaAct(5,4,20,"Colocar registros y drenaje exterior",21,2,57800,4);
        ica.agregaAct(5,8,16,"Instalación hidráulica y sanitaria",23,1,17325,5);
        ica.agregaAct(5,12,6,"Colar loza techo",50,2,12500,12);
        ica.agregaAct(5,2,6,"Acometida eléctrica",32,1,500,5);
        ica.agregaAct(5,6,10,"Ventanas y puertas",35,2,17500,14);
        ica.agregaAct(5,10,16,"Pintar muros y techo",36,3,3500,2);
        ica.agregaAct(5,14,10,"Permiso de color",0,1,0,3);
        ica.agregaAct(5,14,18,"Acometida de agua",23,1,2500,1);
        ica.agregaAct(5,18,8,"Conexión de agua",23,1,1500,1);
        ica.agregaAct(5,18,20,"Acometida de drenaje",21,2,2000,2);


        ica.ordenaProyectos();

        // al imprimir los proyectos eliminar los letreros de infraestructura
        System.out.println("---------------------------------------------\n");
        System.out.println(ica);
        System.out.println("---------------------------------------------\n");

        
        double proporcionAlFinal = 0.75; //porque se paga 50(inicio de actividades) - 50(fin de actividades)
        ClsFlujoDeEfectivo fet = ica.obtenFE( proporcionAlFinal, true );
        System.out.println(fet);

        System.out.println(">>>>>>>>>>>>>>>>>> Van los Recursos <<<<<<<<<<<<<<<<");
        ClsUsoDeRecursos   urt = ica.obtenUR();
        System.out.println(urt);
        System.out.println(">>>>>>>>>>>>>>>>> Fin de Recursos <<<<<<<<<<<<<<<<<<");
/*
        System.out.println("\nCosto por proyecto:\n" + ica.imprimeCostoPorProyecto());
        System.out.println("\nCosto Total de las obras:" + ica.obtenCostoTotal());
*/      
    }
}
