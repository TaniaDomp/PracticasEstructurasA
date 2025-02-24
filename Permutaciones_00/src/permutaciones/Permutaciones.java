package permutaciones;
import java.util.Arrays;

/**
 *
 * @author tania
 */
public class Permutaciones {

    //variables de instancia
    
    int     n;
    int     permutaciones[];
    boolean libre[];
    int     cuantas;
    boolean IMPRIME = true;
    
    public Permutaciones(int n){
        this.n = n;
        /*
        Se desperdicia el priemr lugar de los arreglos
        */
        this.permutaciones = new int[this.n+1];
        this.libre         = new boolean[this.n+1];
        this.cuantas      = 0;
        Arrays.fill(libre, true);
    }
    
    public void obtenPermutaciones(int sig){
        if(sig > this.n){
            if(this.IMPRIME){
                this.cuantas++;
                System.out.print("Permutacion[" + this.cuantas + "]: ");
                for(int t = 1; t <= this.n; t++){
                System.out.print(this.permutaciones[t] + " ");
                System.out.println();
                }
            }
            return;
        }
        //ocupo el siguiente lugar
        for(int t = 1; t <= this.n; t++){
            if(this.libre[t]){
                this.libre[t] = false;
                this.permutaciones[sig] = t;
                this.obtenPermutaciones(sig+1);
                this.libre[t] = true;
            }
        }
        
    }
    
    public static void main(String[] args) {
        long t0, t1, deltaT;
        int n = 5;
        if(args.length > 0){
            n = Integer.valueOf(args[0]);
        }
        Permutaciones objPermut = new Permutaciones(n);
        objPermut.IMPRIME = false;
        t0 = System.nanoTime();
        
        objPermut.obtenPermutaciones(1);
        t1 = System.nanoTime();
        deltaT= t1 - t0;//nanosegundos
        System.out.println(n + "," + deltaT + ", nanoSeg");
    }
    
}
