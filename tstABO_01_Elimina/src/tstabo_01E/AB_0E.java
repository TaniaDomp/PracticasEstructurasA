/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tstabo_01E;
import cola_00.Cola_01;

/**
 *
 * @author psdist
 */
public class AB_0E 
{
   private Nodo_ABE raiz; 
   public AB_0E()
   {
       this.raiz = null;
   }
   
   public void agrega( int x) throws Exception
   {
       if(this.raiz != null)
           this.raiz.agrega(x);
       else
           this.raiz = new Nodo_ABE(x);
   }
   
   public boolean contiene(int x)
   {
       if(raiz == null)
           return false;
       else
           return raiz.contiene(x);
   }
   
   public boolean menor(int a[])
   {
       if(raiz == null)
           return false;
       if(raiz.izq == null)
           a[0] = raiz.dato;
       else
           raiz.menor(a);
       return true;
   }

   public boolean mayor(int a[])
   {
       if(raiz==null)
           return false;
       if(raiz.der == null)
           a[0] = raiz.dato;
       else
           raiz.mayor(a);
       return false;
   }
 
   public boolean eliminaMayor(int a[])
   {
       if( raiz == null )
         return false;
       else
         if( raiz.der == null) // eliminar raiz  
         {   a[0] = raiz.dato;
            raiz.der = raiz.izq;
            return true;
         }
         else  // la raiz tiene hijo derecho
           return raiz.eliminaMayor(a);  
   }
   
   public boolean eliminaMenor(int a[])
   {
       if( raiz == null )
         return false;
       else
         if( raiz.izq == null) // eliminar raiz  
         { a[0] = raiz.dato;
            raiz = raiz.der;
            return true;
         }
         else // la raiz tiene hijo izquierdo
           return raiz.eliminaMenor(a);  
   } 
   
   public boolean elimina(int x)
   {
       boolean blnRes;
       if( raiz == null)
           return false;
       else
       {
           if(raiz.dato == x )  // hay que eliminar la raíz
           {
               blnRes = true;
               if( raiz.izq == null ) // raiz no tiene nodo izquierdo
               {
                   raiz = raiz.der;
               }
               else // la raiz tiene nodo izquierdo
               {
                   Nodo_ABE izq_derechoso = raiz.izq.derechoso();
                   izq_derechoso.der = raiz.der;
                   raiz = raiz.izq;    
               }
           }
           else
           {
              blnRes = raiz.elimina(x);
           }           
       }
       return blnRes;        
   }
   
   public int cuantasClaves()
   {
       if(raiz == null)
           return 0;
       else
           return raiz.cuentaClaves();
   }
   
   public int[] obtenArreglo()
   {
       if(raiz == null)
           return new int[0];
       else
       {
           int x[]   = new int[raiz.cuentaClaves()];
           int van[] = new int[1];
           raiz.rellenaIRD(x,van);
           return x;
       }
   }

   public String toString()
   {
      String strRes = "\n----------------------------------\nABO_00:\n"; 
      if( this.raiz != null)
          strRes +=  raiz.toString();
      else
          strRes += "Vacío\n";
      return strRes;
   }

   public String toStringRev()
   {
      String strRes = "ABO_00:\n"; 
      if( this.raiz != null)
          strRes +=  raiz.toStringRev();
      else
          strRes += "Vacío\n";
      return strRes;
   }

   public String toStringIn()
   {
      String strRes = "ABO_00:\n"; 
      if( this.raiz != null)
          strRes +=  raiz.toStringIn();
      else
          strRes += "Vacío\n";
      return strRes;
   }
   
   
   public String toStringBreadth()
   {
      Cola_01 c = new Cola_01<Nodo_ABE>(20);
      Nodo_ABE ar[] = new Nodo_ABE[1];
      Nodo_ABE nodo_ab;
      
      String strRes = "Recorrido en amplitud del ABO_00:\n";
      
      if( this.raiz != null)
      {
        c.agrega(raiz);
        while(!c.vacia())
        {
            c.salida(ar);
            nodo_ab = ar[0];
            strRes += nodo_ab.toStringSolo();
            if( nodo_ab.izq != null) c.agrega(nodo_ab.izq);
            if( nodo_ab.der != null) c.agrega(nodo_ab.der);
        }
      }  
      else
          strRes += "Vacío\n";
      return strRes;
     
       
   }
   


}
