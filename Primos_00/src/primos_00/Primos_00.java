/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primos_00;

/**
 *
 * @author tania
 */
public class Primos_00 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int w;
        int VECES;
        int vez;
        long n, c, r, d = 0, intentos;
        double dblMin,dblMax,dblDeltaNum;
        boolean bln_es_primo;
        
        if(args.length == 0 || args.length == 1){
            System.out.println("Uso: \n" + "java -jar ...\\Primos_00" + " potencia de 2 para generar los numeros");
        }
        else{
            System.out.println("Vez,num,intentos,deltaT,decision");
            w = Integer.valueOf(args[0]);
            VECES = Integer.valueOf(args[1]);
            dblMin = Math.pow(2.0, (double)w-1);
            dblMax = Math.pow(2.0, (double)w);
            dblDeltaNum = dblMax - dblMin;
            long t0, t1;
            long deltaT;
            for (vez = 1; vez <= VECES; vez++){
                
                n = (long)(dblMin + dblDeltaNum * Math.random());
                if(n % 2 == 0){
                    n++;
                }
                /*
                //Proceso a probar
                */
                c        = 2;
                r        = 1;
                intentos = 0;
                t0 = System.nanoTime();
                while((r > 0) & (c*c <= n)){
                    intentos++;
                    r = n % c;
                    d = c;
                    if(c == 2){
                        c = 3;
                    }
                    else{
                        c+=2;
                    }
                }
                t1 = System.nanoTime();
                deltaT = t1 - t0;
                
                bln_es_primo = (r != 0);
                System.out.print(vez + "," + n + "," + intentos + "," + deltaT + ",");
                if(bln_es_primo)
                    System.out.println("Primo");
                else
                    System.out.println("No Primo pues lo divide " + d);
            }
        }
        
    }
    
}
