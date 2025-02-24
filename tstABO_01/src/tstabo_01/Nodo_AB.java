/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tstabo_01;
/**
 *
 * @author psdist
 */
public class Nodo_AB implements Comparable
{
   protected int dato;
   protected Nodo_AB izq;
   protected Nodo_AB der;
   
   public Nodo_AB(int dato)
   {
       this.dato = dato;
       izq = null;
       der = null;
   }
   
   public void agrega( int x)
   {
       if(x < this.dato)
       {
           if( this.izq != null)
               this.izq.agrega(x);
           else
               this.izq = new Nodo_AB(x);
       }
       else
       {
           if( this.der != null)
               this.der.agrega(x);
           else
               this.der = new Nodo_AB(x);   
       }
   }
   
   public void eliminaMenor(int[] a){
       if(this.izq.izq == null){
           a[0] = this.izq.dato;
           this.izq = this.izq.der;
           //delete(this.izq)
       }
       else{
           this.izq.eliminaMenor(a);
       }
   }
   
   public void eliminaMayor(int[] a){
       if(this.der.der == null){
           a[0] = this.der.dato;
           this.der = this.der.izq;
           //delete(this.der)
       }
       else{
           this.izq.eliminaMenor(a);
       }
   }
   
   public Nodo_AB derechoso()
   {
       if(this.der == null)
           return this;
       else
           return this.der.derechoso();
   }

   public Nodo_AB izquierdoso()
   {
       if(this.izq == null)
           return this;
       else
           return this.izq.izquierdoso();
   }
   
   public boolean elimina(int x)
   {
       // NOTA: Si este nodo recibe la ejecución de este método es debido a que su dato no es x y x puede estar 
       // en alguno de sus sub-árboles
       boolean blnRes;
       
       if( x < this.dato ) // va por la izquierda
       {
          if( this.izq != null)
          {
            if( x == this.izq.dato ) // es el nodo de la izquierda, lo elimino
            {
              blnRes = true;
              if(this.izq.izq != null)
              {
                 Nodo_AB izq_derechoso = this.izq.izq.derechoso();
                 izq_derechoso.der = this.izq.der;
                 this.izq = this.izq.izq;
              }
              else
              {
                  this.izq = this.izq.der;
              }
            }
            else
            {
                blnRes = this.izq.elimina(x);
            }
          }
          else
          {
            // el dato debería estar por la rama izquierda pero no hay tal, no está.
            return false;
          }        
       }
       else // va por la derecha
       {
          if( this.der != null)
          {
            if( x == this.der.dato ) // es el nodo de la derecha, lo elimino
            {
              blnRes = true;
              if(this.der.izq != null)
              {
                 Nodo_AB der_izq_derechoso = this.der.izq.derechoso();
                 der_izq_derechoso.der = this.der.der;
                 this.der = this.der.izq;
              }
              else
              {
                  this.der = this.der.der;
              }
            }
            else
            {
                blnRes = this.der.elimina(x);
            }
          }
          else
          {
            // el dato debería estar por la rama derecha pero no hay tal, no está.
            return false;
          }                  
       }      
       return blnRes;
   }
   
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      
      if( this.izq != null) sb.append(this.izq.toString());
      sb.append(" ").append(this.dato).append('\n');
      if( this.der != null) sb.append(this.der.toString()); 
      return new String(sb);
   }
   
   public String toStringRev()
   {
      StringBuilder sb = new StringBuilder();
      if( this.der != null) sb.append(this.der.toStringRev());
      sb.append(" ").append(this.dato).append('\n');
      if( this.izq != null) sb.append(this.izq.toStringRev()); 
      return new String(sb);
   }
   
   public String toStringIn()
   {
      StringBuilder sb = new StringBuilder();
      
      sb.append(" ").append(this.dato).append('\n');
      if( this.izq != null) sb.append(this.izq.toStringIn()); 
      if( this.der != null) sb.append(this.der.toStringIn());
 
      return new String(sb);
   }

   public String toStringSolo()
   {
      return  this.dato + " ";
   }
   
    @Override
    public int compareTo(Object otro) 
    {
        int res = 1;
        if( otro instanceof Nodo_AB)
        {
            res = this.dato - ((Nodo_AB)otro).dato;
        
            if( res > 0)
                res = 1;
            else
               if(res < 0)
                  res = -1;
        }
        return res;
    }
           
}
