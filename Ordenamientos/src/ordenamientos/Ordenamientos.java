package ordenamientos;

/**
 *
 * @author tania
 */
public class Ordenamientos {

    public void selDta(double a[]){
        int    k, n;
        double menor,t;
        n = a.length;
        
        for(int h = 0; h < n; h++)
        {
            menor = a[h];
            k     = h;
            
            for(int j = h + 1; j < n; j++)
            {
                if(a[j] < menor)
                {
                    menor = a[j];
                    k = j;
                }
            }
            //intercambio a[h] con a[k]
            t = a[h];
            a[h] = menor;
            a[k] = t;
        }
    }
    
    public void insDta(double a[]){
        int pos;
        double val;
        
        for(int i = 0; i < a.length; i++){
            pos = i;
            val = a[i];
            while(pos > 0 && val < a[pos - 1]){
                a[pos] = a[pos - 1];
                pos--;
            }
            a[pos] = val;
        }
    }
    
    private void quickSort(double a[], int primero, int ultimo){
        double pivote = a[primero];
        int i = primero;
        int j = ultimo;
        double auxiliar;
        
        while(i < j){
            while(a[i] < pivote){
                i++;
            }
            while(a[j] > pivote){
                j--;
            }
            if(i <= j){
                auxiliar = a[i];
                a[i] = a[j];
                a[j] = auxiliar;
                i++;
                j--;
            }
        }
        if(primero < j){
            quickSort(a, primero, j);
        }
        if(i < ultimo){
            quickSort(a, i, ultimo);
        }
    }
    
    public void quickSort(double a[]){
        quickSort(a, 0, a.length-1);
    }
    
    public boolean revisaOrden(double a[]){
        boolean rev = true;
        int i = 0;
        
        while(i < (a.length - 1) && rev){
            rev = a[i] <= a[i + 1];
            i++;
        }
        return rev;
    }
    
    public void llenaaArreglo(double a[], double v){
        double numero;
        
        for(int i = 0; i < a.length; i++){
            numero = (Double) v * Math.random();
            a[i] = numero;
        }
    }
    
    public void imprimeArreglo(double a[]){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    
    public long tiempoEjecucionsSelDta(double a[], Ordenamientos objOr, double v){
        long tiempoTotal = 0;
        long t1, t0, deltaT;
        
        for(int i = 0; i < 20; i++){
            objOr.llenaaArreglo(a, v);
            t0 = System.nanoTime();
            objOr.selDta(a);
            t1 = System.nanoTime();
            deltaT = t1 - t0;
            tiempoTotal += deltaT;
        }
        return tiempoTotal;
    }
    
    public long tiempoEjecucionsInsDta(double a[], Ordenamientos objOr, double v){
        long tiempoTotal = 0;
        long t1, t0, deltaT;
        
        for(int i = 0; i < 20; i++){
            objOr.llenaaArreglo(a, v);
            t0 = System.nanoTime();
            objOr.insDta(a);
            t1 = System.nanoTime();
            deltaT = t1 - t0;
            tiempoTotal += deltaT;
        }
        return tiempoTotal;
    }
    
    public long tiempoEjecucionsQuickSort(double a[], Ordenamientos objOr, double v){
        long tiempoTotal = 0;
        long t1, t0, deltaT;
        
        for(int i = 0; i < 20; i++){
            objOr.llenaaArreglo(a, v);
            t0 = System.nanoTime();
            objOr.quickSort(a);
            t1 = System.nanoTime();
            deltaT = t1 - t0;
            tiempoTotal += deltaT;
        }
        return tiempoTotal;
    }
    
    public static void main(String[] args) 
    {
        double v = 10;
        int numCas = 100;
        double a[];
        long medicionSelDta, medicionInsDta, medicionQuickSort;
        
        if(args.length > 0){
            v = Double.valueOf(args[0]);
            numCas = Integer.valueOf(args[1]);
        }
        a = new double [numCas];
        Ordenamientos objOr = new Ordenamientos();
        /*objOr.llenaaArreglo(a, v);
        objOr.selDta(a);
        objOr.insDta(a);
        objOr.quickSort(a);
        objOr.imprimeArreglo(a);
        System.out.println(objOr.revisaOrden(a));*/
        medicionQuickSort = objOr.tiempoEjecucionsQuickSort(a, objOr, v);
        medicionSelDta = objOr.tiempoEjecucionsSelDta(a, objOr, v);
        medicionInsDta = objOr.tiempoEjecucionsInsDta(a, objOr, v);
        System.out.println(v + "," + medicionQuickSort + "," +medicionSelDta + "," + medicionInsDta);
    }
    
}