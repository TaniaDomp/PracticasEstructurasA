/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tstabo_01;
import cola_00.Cola_01;

/**
 *
 * @author psdist
 */
public class AB_00 
{
   private Nodo_AB raiz; 
   
   public AB_00()
   {
       this.raiz = null;
   }
   
   public void agrega( int x)
   {
       if(this.raiz != null)
           this.raiz.agrega(x);
       else
           this.raiz = new Nodo_AB(x);
   }
   
   public boolean menor(int a[])
   {
       // implementar y ver alternativas al boolean...
       
       return false;
   }

   public boolean mayor(int a[])
   {
       // implementar
       return false;
   }
   
   public boolean eliminaMayor(int a[])
   {
       if(this.raiz == null){ //AB vacio
           return false;
       }
       else{
          if(this.raiz.der  == null){ //raiz sin hijo izquierdo
              a[0] = this.raiz.dato;
              this.raiz = this.raiz.izq;
          }
          else{ //la raiz tiene hijo izquierdo
              this.raiz.eliminaMayor(a);
          }
          return true;
       }
   }
    
   public boolean eliminaMenor(int a[])
   {
       if(this.raiz == null){ //AB vacio
           return false;
       }
       else{
          if(this.raiz.izq  == null){ //raiz sin hijo izquierdo
              a[0] = this.raiz.dato;
              this.raiz = this.raiz.der;
          }
          else{ //la raiz tiene hijo izquierdo
              this.raiz.eliminaMenor(a);
          }
          return true;
       }
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
                   Nodo_AB izq_derechoso = raiz.izq.derechoso();
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
   
   public String toString()
   {
      String strRes = "ABO_00:\n"; 
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
      Cola_01 c = new Cola_01<Nodo_AB>(20);
      Nodo_AB ar[] = new Nodo_AB[1];
      Nodo_AB nodo_ab;
      
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
