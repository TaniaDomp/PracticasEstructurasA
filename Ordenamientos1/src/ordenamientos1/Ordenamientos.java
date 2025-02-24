/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos1;

import java.util.Arrays;
import triangulos.Triangulos;

/**
 *
 * @author RGAMBOAH
 */
public class Ordenamientos {

    /**
     * @param args the command line arguments
     */
    public <E extends Comparable<? super E>> void ordSelDta(E arr[])
    {
        int n = arr.length;
        int j,k,h;
        E t,menor;
        
        for(h = 0; h < n; h++)
        {
            k     = h;
            menor = arr[h];
            for(j = h+1; j < n; j++)
            {
                if( arr[j].compareTo(menor) < 0)
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
    
    public <E extends Comparable<? super E>> int busLugBin(E a[],int i0,int i1, E x)
    {
        int im, ix;
        if(x.compareTo(a[i0]) < 0 ) return 0;
        if(x.compareTo(a[i1]) > 0 ) return i1 + 1;
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
            if( x.compareTo(a[im]) < 0)
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
    
    public <E extends Comparable<? super E>>void ordInsDta(E arr[])
    {
      int n = arr.length;
      int i_sig,j,i_lug;
      E x;
    
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
    
    public <E extends Comparable<? super E>> int split(int i0,int i1,E a[])
    {
        int h, i_crec, i_decr;
        E v;
        
        h = i0;
        v = a[i0];
        i_crec = i0 + 1;
        i_decr = i1;
        
        while( i_crec <= i_decr)
        {
            while((v.compareTo(a[i_decr])) <= 0 && (h < i_decr)) i_decr--;
            if( i_crec <= i_decr)
            {
                a[h] = a[i_decr];
                h    = i_decr;
                i_decr--;
                
                while((a[i_crec].compareTo(v)) <= 0 &&(h > i_crec)) i_crec++;
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
    
    public <E extends Comparable<? super E>> void quicksort( int i0, int i1, E a[])
    {
        int iq;
        if( i0 < i1 )
        {
            iq = split(i0,i1,a);
            quicksort(i0,iq-1,a);
            quicksort(iq+1,i1,a);
        }
    }
    
    public <E extends Comparable<? super E>> E[] copia_dbls(E a[])
    {
        return Arrays.copyOf(a, a.length);
    }
    
    public <E extends Comparable<? super E>> void ordQuickSort(E arr[])
    {
        int n = arr.length-1;
        quicksort(0,n,arr);
    }
    
    <E extends Comparable<? super E>> boolean verif_E(E arr[])
    {
        int     n = arr.length;
        int     i = 0;
        boolean ban = true;
        while( ban & i < n - 1 )
        {
            ban = arr[i].compareTo(arr[i+1]) < 0;
            i++;
        }
        return ban;
    }
    
    public static void main(String[] args) 
    {
        Ordenamientos objServ = new Ordenamientos();
        int n = 10000;
        long t0,t1,deltaT;
        if( args.length > 0)
            n = Integer.valueOf(args[0]);
        
        triangulos.Triangulos asd[] = triangulos.Triangulos.generaTriangulos(n);
        //double aid[] = objServ.copia_dbls(asd);
        //double aqs[] = objServ.copia_dbls(asd);
        
        t0 = System.nanoTime();
        objServ.ordSelDta(asd);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("SelDta n:" + n + "," +( objServ.verif_E(asd)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");

        /*t0 = System.nanoTime();
        objServ.ordInsDta(aid);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("InsDta n:" + n + "," +( objServ.verif_ord(aid)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");
        
        t0 = System.nanoTime();
        objServ.ordQuickSort(aqs);
        t1 = System.nanoTime();
        deltaT = t1 - t0;
        System.out.println("QSort n:" + n + "," +( objServ.verif_ord(aqs)? "se " : "NO SE ") + "ordenaron en," + deltaT + ",nanoSeg");
        */
        
    }
    
}
