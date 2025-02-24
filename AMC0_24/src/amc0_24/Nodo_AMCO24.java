/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amc0_24;

/**
 *
 * @author RGAMBOAH
 */
public class Nodo_AMCO24 
{
    static int CAPACIDAD = 3;
    int ocupados;
    int arr_k[];
    Nodo_AMCO24 arr_ap[];
    
    public Nodo_AMCO24()
    {
       ocupados = 0; 
       arr_k  = new int[CAPACIDAD + 1]; // para crecomiento temporal
       arr_ap = new Nodo_AMCO24[CAPACIDAD + 2];
    }
    
    private boolean agrega_arr(int x,int idx, Nodo_AMCO24 ap_izq[],Nodo_AMCO24 ap_der[])
    {
        int t;
        //
        // x va en el lugar idx
        //
        if( ocupados < CAPACIDAD & arr_k[idx] == x)
        {
           return false; // colisión
        }
        else // lo agrego al arreglo
        {
            for(t = ocupados;t > idx; t--)
            {
               if( t > CAPACIDAD )
               {
                    System.out.println("t:" + t + ", ocupados:" + ocupados + ", Capacidad:" + CAPACIDAD);
                    System.out.println("*****************************************");
               }
               arr_k[t] = arr_k[t-1];
               arr_ap[t+1] = arr_ap[t];
            }
            arr_k[idx]    = x;
            arr_ap[idx]   = ap_izq[0];
            arr_ap[idx+1] = ap_der[0];
            this.ocupados++;
            ap_izq[0] = null;
            ap_der[0] = null;
            return true;
        }  
    }
    
    public boolean agrega( int x[], Nodo_AMCO24 ap_izq[], Nodo_AMCO24 ap_der[])
    {
        int idx = 0;
        boolean ban = true;
        boolean blnRes = false;
        if(this.ocupados == 0)
        {
            arr_k[0] = x[0];
            ap_izq[0] = null;  // indica que todo está estable
            ap_der[0] = null;
            this.ocupados = 1;
            return true;
        }
        
        while( ban & idx < this.ocupados )
        {
            if( arr_k[idx] < x[0] )
                idx++;
            else
                ban = false;
        }
        if( idx < 0 | idx > CAPACIDAD)
        {
            System.out.println("idx:" + idx + ", ocupados:" + ocupados + ", CAPACIDAD:" + CAPACIDAD);
            System.out.println("++++++++++++++++++++++++++++++++");
        }
        if( arr_k[idx] == x[0] ) return false; // colisión
        
        // si hay un hijo posible envío el agrega por ahí
        if( arr_ap[idx] != null )
        {
            blnRes = arr_ap[idx].agrega(x, ap_izq, ap_der);
            if( ap_izq[0] != null | ap_der[0] != null )
            {
              this.agrega_arr(x[0], idx,ap_izq, ap_der);// de regreso hay que alojar la llave x[0] y los apuntadores anexos  
            }    
        }    
        else
        { 
          blnRes = this.agrega_arr( x[0], idx, ap_izq, ap_der );
        }
          // reviso la estabilidad al regresar
          if( ocupados > CAPACIDAD )
          {
            // se debe hacer un split y avisar al nodo padre de que debe guardar
            // la llave y sus apuntadores.
            x[0] = arr_k[2];
            Nodo_AMCO24 nvoNodo = new Nodo_AMCO24();
            ap_izq[0] = this;
            ap_der[0] = nvoNodo;
            nvoNodo.arr_k[0]  = this.arr_k[3];
            nvoNodo.arr_ap[0] = this.arr_ap[3];
            nvoNodo.arr_ap[1] = this.arr_ap[4];
            nvoNodo.ocupados  = 1;
            this.ocupados     = 2;
          }
          
        return blnRes;
    }
    
    @Override
    public String toString()
    {
        String strRes = "";
        
        for(int t = 0; t < this.ocupados; t++)
        {
            if(this.arr_ap[t]!=null) 
                strRes += this.arr_ap[t].toString();
            strRes += this.arr_k[t] + "\n";
            //System.out.println("this.arr_k[t]:" + this.arr_k[t]);
        }
        if(this.arr_ap[this.ocupados]!=null) 
            strRes += this.arr_ap[this.ocupados].toString();
        return strRes;
    }
        
}
