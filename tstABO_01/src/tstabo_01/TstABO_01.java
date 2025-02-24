package tstabo_01;

/**
 *
 * @author psdist
 */
public class TstABO_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int x[] = new int[1];
        
        AB_00 ab = new AB_00();
        
        ab.agrega(8);
        ab.agrega(-3);
        ab.agrega(2);
        ab.agrega(800);
        ab.agrega(200);
        ab.agrega(4);
        
        //System.out.println(ab);
        
        //Prueba para eliminar el menor
        /*if(ab.eliminaMenor(x))
            System.out.println("Se eliminó el " + x[0]);
        else
            System.out.println("No hay datos en el arbol...");
        ab.eliminaMenor(x);
        System.out.println("ABO en recorrido ascendente:" + ab);*/
        //Prueba para eliminar el mayor
        /*if(ab.eliminaMayor(x))
            System.out.println("Se eliminó el " + x[0]);
        else
            System.out.println("No hay datos en el arbol...");
        ab.eliminaMenor(x);
        System.out.println("ABO en recorrido ascendente:" + ab);*/
        /*System.out.println("ABO en recorrido descendente:" + ab.toStringRev());
        System.out.println("ABO en recorrido inFijoRID:" + ab.toStringIn());
        System.out.println( ab.toStringBreadth());*/
        
    }
    
}
