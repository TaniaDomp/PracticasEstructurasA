/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenayotros;

import java.util.Arrays;

/**
 *
 * @author RGAMBOAH
 */
public class Ordenamientos {

    /**
     * @param args the command line arguments
     */
    void ordSelDta(double arr[])
    {
        int n = arr.length;
        int j,k,h;
        double t,menor;
        
        for(h = 0; h < n; h++)
        {
            k     = h;
            menor = arr[h];
            for(j = h+1; j < n; j++)
            {
                if( arr[j] < menor )
                {
                    k     = j;
                    menor = arr[k];
                }
            }
            t      = arr[h];
            arr[h] = menor;
            arr[k] = t;
        }    
    }   
    
    int busLugBin(double a[],int i0,int i1, double x)
    {
        int im, ix;
        if(x < a[i0] ) return 0;
        if(x > a[i1] ) return i1 + 1;
        while( i0 < i1 -1 )
        {
            im = ( i0 + i1 ) / 2;
            if(x == a[im])
            {
               ix = im;
               System.out.println("Datos repetidos"); 
               System.exit(im);
               return ix;
            }
            if( x < a[im])
            {
                i1 = im;
            }
            else
            {
                i0 = im;
            }
        }
        ix = i1;
        return ix;
    }
    
    void ordInsDta(double arr[])
    {
      int n = arr.length;
      int i_sig,j,i_lug;
      double x;
    
      for(i_sig = 1; i_sig < n; i_sig++ )
      {
          x = arr[i_sig];
          i_lug = busLugBin(arr,0,i_sig-1,x);
          // recorro del i_lug al i_sig
          for( j = i_sig; j > i_lug; j--)
              arr[j] = arr[j-1];
          arr[i_lug] = x;
      }
    
    }
    
    public int split(int i0,int i1,double a[])
    {
        int h, i_crec, i_decr;
        double v;
        
        h = i0;
        v = a[i0];
        i_crec = i0 + 1;
        i_decr = i1;
        
        while( i_crec <= i_decr)
        {
            while((v <= a[i_decr]) && (h < i_decr)) i_decr--;
            if( i_crec <= i_decr)
            {
                a[h] = a[i_decr];
                h    = i_decr;
                i_decr--;
                
                while((a[i_crec] <= v) &&(h > i_crec)) i_crec++;
                if(i_crec <= i_decr)
                {
                    a[h] = a[i_crec];
                    h = i_crec;
                    i_crec++;
                }
            }
            
        }
        a[h] = v;
        return h;
    }
    
    public void quicksort( int i0, int i1, double a[])
    {
        int iq;
        if( i0 < i1 )
        {
            iq = split(i0,i1,a);
            quicksort(i0,iq-1,a);
            quicksort(iq+1,i1,a);
        }
    }
    
    double[] copia_dbls(double a[])
    {
        return Arrays.copyOf(a, a.length);
    }
    public void ordQuickSort(double arr[])
    {
        int n = arr.length-1;
        quicksort(0,n,arr);
    }
    
    boolean verif_ord(double arr[])
    {
        int     n = arr.length;
        int     i = 0;
        boolean ban = true;
        while( ban & i < n - 1 )
        {
            ban = arr[i] < arr[i+1];
            i++;
        }
        return ban;
    }
    
    double[] genera_dbls(int n)
    {
        double x[] = new double[n];
        for(int i= 0; i < n; i++)
            x[i] = 1.0e6 * Math.random();
        return x;
    }
            
    public static void main(String[] args) 
    {
        Ordenamientos objServ = new Ordenamientos();
        int n = 10000;
        long t0,t1,deltaT;
        if( args.length > 0)
            n = Integer.valueOf(args[0]);
        
        double asd[] = objServ.genera_dbls(n);
        double aid[] = objServ.copia_dbls(asd);
        double aqs[] = objServ.copia_dbls(asd);
        
        t0 = System.nanoTime();
        objServ.ordSelDta(asd);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("SelDta n:" + n + "," +( objServ.verif_ord(asd)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");

        t0 = System.nanoTime();
        objServ.ordInsDta(aid);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("InsDta n:" + n + "," +( objServ.verif_ord(aid)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");
        
        t0 = System.nanoTime();
        objServ.ordQuickSort(aqs);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("QSort n:" + n + "," +( objServ.verif_ord(aqs)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");
        
        
    }
    
}
