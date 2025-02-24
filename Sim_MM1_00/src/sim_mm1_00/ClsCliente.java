/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsCliente
{
   int numClte;
   double tiempoEntrada;

   public ClsCliente( int num )
   {
       numClte = num;
   }

   public int getNum()
   {
       return numClte;
   }

   public double tiempoEn(){
       return tiempoEntrada;
   }
   
    @Override
   public String toString()
   {
       return "Cliente No. " + this.numClte;
   }
}
