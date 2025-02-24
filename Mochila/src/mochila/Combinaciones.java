package mochila;
import ordenamientos1.Ordenamientos;
/**
 *
 * @author tania
 */
public class Combinaciones {
    private int contador;
    private int[] comb;
    private Combinacion[] combinacionesFinales;
    private Combinacion[] combPosibles;
    private int totalComb;
    private int n;
    
    public Combinaciones(){
        this.contador = 0;
    }
    
    //
    private void creacYEvCombinaciones(double[] pesos, double[] valores, double pesoMoch, int ar1, int ar2, int ar3){
        this.n = pesos.length;
        this.totalComb = ((int) Math.pow(2, n)) - 1;
        this.comb = new int[this.n+1]; //para empezar desde el elemento n
        int num, k;
        double contP, contV;
        StringBuilder c = new StringBuilder();
        Combinacion arti;
        this.combPosibles = new Combinacion[this.totalComb]; 
        
        for(int j = 1; j <= this.totalComb; j++){
            num = j;
            contP = 0;
            contV = 0;
            for(int i = this.n; i > 0; i--){
                this.comb[i] = num%2;
                if(this.comb[i] == 1){
                    contP += pesos[i-1]; //se pone i - 1 porque los indices de los arreglos pesos y valores solo llegan a n-1
                    contV += valores[i-1];
                }
                c.append(String.valueOf(this.comb[i]));
                num/=2;
            }
            if(this.comb[ar1] == 1 && this.comb[ar2] == 1 && this.comb[ar3] == 1 && pesoMoch > contP){
                arti = new Combinacion(String.valueOf(contV), String.valueOf(contP), c.reverse().toString());
                this.combPosibles[this.contador] = arti;
                this.contador++;                
            }
            c.delete(0, this.n);
        }
    }
    
    private void invierteA(Combinacion[] com){
        Combinacion[] aux = new Combinacion[com.length];
        int i = 0;
        
        System.arraycopy(com, 0, aux, 0, com.length);
        for(int k = com.length-1; k >=0; k--){
            com[i] = aux[k];
            i++;
        }
    }
    
    public String mejoresCombinaciones(double[] pesos, double[] valores, double pesoMoch, int ar1, int ar2, int ar3, int mC){
        StringBuilder cad = new StringBuilder();
        Ordenamientos ordena = new Ordenamientos();
        int k;
        
        creacYEvCombinaciones(pesos, valores, pesoMoch, ar1, ar2, ar3);
        this.combinacionesFinales = new Combinacion[this.contador];
        System.arraycopy(this.combPosibles, 0, this.combinacionesFinales, 0, this.contador);
        ordena.ordQuickSort(this.combinacionesFinales);
        invierteA(this.combinacionesFinales);
        k = mC-1;
        if(k > this.contador){
            k = this.contador-1;
        }
        for(int c = 0; c <= k; c++){
            cad.append(this.combinacionesFinales[c].toString());
        }
        return cad.toString();
    }
}
