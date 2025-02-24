package coeficientesbinomialesnk2;
/**
 *
 * @author tania
 */
public class CoeficientesBinomialesNK2 {
    
    int n;
    int k;
    
    public CoeficientesBinomialesNK2(int n, int k){
        this.n = n;
        this.k = k;
    }
    
    public int calculaCoeficiente(int n, int k){
        int restaCo, arribDiv, abajDiv, numSup;
        
        restaCo = n - k;
        arribDiv = 1;
        abajDiv = 1;
        numSup = n;
        for(int i = 1; i <= restaCo; i++){
            arribDiv *= numSup;
            abajDiv *= i;
            numSup--;
        }
        return arribDiv / abajDiv;
    }
    
    public static void main(String[] args) {
        long t0, t1, deltaT;
        CoeficientesBinomialesNK2 objCoef;   
        int n = 10;
        int k = 5;
        int coef;
        
        if(args.length > 1){
            n = Integer.valueOf(args[0]);
            k = Integer.valueOf(args[1]);
        }
        objCoef = new CoeficientesBinomialesNK2(n, k);
        t0 = System.nanoTime();
        coef = objCoef.calculaCoeficiente(n, k);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        //System.out.println(coef);
        System.out.println(coef + "," + n + "," + k + "," + deltaT + ", nanoSeg");
    }
    
}
