package problemasprepar;
import java.util.ArrayList;
import ordenamientos1.Ordenamientos;
/**
 *
 * @author tania
 */
public class ProblemasPrePar {

    public void convierteBinario(int[][] combinaciones, int filas, int columnas)
    {  
        int num;
        for(int j = 1; j <= filas; j++){
            num = j;
            for(int i = columnas; i > 0; i--){
                combinaciones[j][i] = num%2;
                num/=2;
            }
        }
    }
    
        public String artiMoch(double[] valores, double[] pesos, double pesoMoch, int ar1, int ar2, int ar3){
        StringBuilder cad = new StringBuilder();
        StringBuilder num = new StringBuilder();
        int[][] combinaciones;
        double contP, contV;
        int n, comb, control = 0;
        Articulo[] combinaPos;
        Articulo[] aux;
        Articulo arti;
        Ordenamientos ordena = new Ordenamientos();
        
        n = valores.length;
        comb = ((int) Math.pow(2, n)) - 1;
        combinaciones = new int[comb+1][n+1];
        combinaPos = new Articulo[comb + 1];
        convierteBinario(combinaciones, comb, n);
        for(int j = 1; j <= comb; j++){
            contP = 0;
            contV = 0;
            if(combinaciones[j][ar1] == 1 && combinaciones[j][ar2] == 1 && combinaciones[j][ar3] == 1){
                for(int i = 1; i <= n; i++){
                    if(combinaciones[j][i] == 1){
                        contP += pesos[i-1]; //se pone i - 1 porque los indices de los arreglos pesos y valores solo llegan a n-1
                        contV += valores[i-1]; //mientras que los arreglos de la combinacion llegan hasta n
                    }
                    num.append(combinaciones[j][i]);
                }
                if(pesoMoch > contP){
                    arti = new Articulo(String.valueOf(contV), String.valueOf(contP), num.toString());
                    combinaPos[control] = arti;
                    control++;
                }
            }
            num.delete(0, n);
        }
        //se imprimen todas las combinaciones posibles
        int i = 0;
        while(combinaPos[i] != null){
            cad.append(combinaPos[i].toString());
            i++;
        }
        //ordena las combinaciones de mayor de acuerdo al valor de la combinacion
        aux = new Articulo[i];
        
        
        return cad.toString();
    }
    
    public static void main(String[] args) {
        double[] valores = {5, 3, 8, 9, 10};
        double[] pesos = {11, 4, 3, 5, 10};
        ProblemasPrePar objProb1 = new ProblemasPrePar();

        System.out.println(objProb1.artiMoch(valores, pesos, 30, 1, 2, 3));
    }
    
    
}
