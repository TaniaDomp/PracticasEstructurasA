package coeficientesbinomialesnk;

/**
 *
 * @author tania
 */
public class CoeficientesBinomialesNK {

    int n;
    int k;
    int numCas;
    int coeficientes[];
    
    public CoeficientesBinomialesNK(int n, int k){
        this.n = n;
        this.k = k;
        this.numCas = k + 1;
        this.coeficientes = new int[n+1]; //se quita el primer espacio del arreglo
    }
    
    public int calculaCoeficiente(int n, int k){
        int coef = 1;
        int potencia = n;
        
        for(int i = 1; i <= this.numCas; i++){
            coeficientes[i] = coef;
            coef = coef * potencia / i;
            potencia--;
        }
        return coeficientes[this.numCas];
    }
    
    public static void main(String[] args) {
        long t0, t1, deltaT;
        int n = 10;
        int k = 5;
        int coef;
        CoeficientesBinomialesNK objCoef;
        
        if(args.length > 1){
            n = Integer.valueOf(args[0]);
            k = Integer.valueOf(args[1]);
        }
        objCoef = new CoeficientesBinomialesNK(n, k);
        t0 = System.nanoTime();
        coef = objCoef.calculaCoeficiente(n, k);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println(coef + "," + n + "," + k + "," + deltaT + ", nanoSeg");
    }
    
}
