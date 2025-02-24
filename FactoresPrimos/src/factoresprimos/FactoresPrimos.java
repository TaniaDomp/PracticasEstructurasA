package factoresprimos;
/**
 *
 * @author tania
 */
public class FactoresPrimos {
    int num;
    boolean IMPRIME = true;
    
    public FactoresPrimos(int num){
        this.num = num;
    }
    
    public void sacaPrimos(int num){
        int div = 2;
        
        while(num != 1){
            while(num % div == 0){
                if(IMPRIME){
                    System.out.println(div);
                }
                num /= div;
            }
            if(div == 2){
                div = 3;
            }
            else{
                div += 2;
            }
        }
    }
    
    public static void main(String[] args) {
        FactoresPrimos objFac;
        int num = 100;
        boolean imp = false;
        long t0, t1, deltaT;
        
        if(args.length > 0){
            num = Integer.valueOf(args[0]);
        }
        objFac = new FactoresPrimos(num);
        objFac.IMPRIME = imp;
        t0 = System.nanoTime();
        objFac.sacaPrimos(num);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println(num + ", " + deltaT + ", nanoSeg");
    }
    
}
