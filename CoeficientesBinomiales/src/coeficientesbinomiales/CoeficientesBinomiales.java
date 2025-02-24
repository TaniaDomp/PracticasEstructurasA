package coeficientesbinomiales;

/**
 *
 * @author tania
 */
public class CoeficientesBinomiales {

    int n;
    int numCas;
    int coeficientes[];
    
    public CoeficientesBinomiales(int n){
        this.n = n;
        this.coeficientes = new int[this.n+1]; 
    }
    
    public void calculaCoeficientes(int n){
        int coef = 1;
        int potencia = n;
        
        coeficientes[0] = coef;
        for(int k = 1; k <= this.n; k++){
            coef = coef * potencia / k;
            coeficientes[k] = coef;
            potencia--;
        }
    }
    
    public String imprimeCoef(){
        StringBuilder cad = new StringBuilder();
        for(int k = 0; k <= this.n; k++){
            cad.append("Coeficiente " + k + ": " + this.coeficientes[k] + "\n");
        }
        return cad.toString();
    }
    
    public static void main(String[] args) {
        long t0, t1, deltaT;
        int n = 3;
        CoeficientesBinomiales objCoef;
        
        if(args.length > 0){
            n = Integer.valueOf(args[0]);
        }
        objCoef = new CoeficientesBinomiales(n);
        t0 = System.nanoTime();
        objCoef.calculaCoeficientes(n);
        t1 = System.nanoTime();
        //System.out.println(objCoef.imprimeCoef());
        deltaT = t1 - t0;
        System.out.println(n + "," + deltaT + ", nanoSeg");
    }
    
}
