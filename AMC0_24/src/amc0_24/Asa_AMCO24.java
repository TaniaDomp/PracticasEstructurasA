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
public class Asa_AMCO24 
{
      Nodo_AMCO24 raiz;
    
    public Asa_AMCO24()
    {
        raiz = new Nodo_AMCO24();
    }

    public boolean agrega(int llave)
    {   
        boolean blnRes;
        int x[] = new int[1];
        Nodo_AMCO24 ap_izq[] = new Nodo_AMCO24[1];
        Nodo_AMCO24 ap_der[] = new Nodo_AMCO24[1];
        Nodo_AMCO24 nva_raiz;
        x[0]      = llave;
        ap_izq[0] = null;
        ap_der[0] = null;
        blnRes = raiz.agrega(x,ap_izq,ap_der);
        if( ap_izq[0] != null | ap_der[0] != null)
        {
            nva_raiz = new Nodo_AMCO24();
            nva_raiz.arr_ap[0] = ap_izq[0];
            nva_raiz.arr_ap[1] = ap_der[0];
            nva_raiz.arr_k[0]  = x[0];
            nva_raiz.ocupados = 1;
            raiz = nva_raiz;
        }
        return blnRes;
    } 
    
    public String toString()
    {
        return this.getClass().getName() + ":" + raiz.toString();
    }
}
