/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import proyecto.IComparable;

/**
 *
 * @author RGGH
 */
public class ClsDiaMontoT implements IComparable
{
    int dia;
    double monto;

    ClsDiaMontoT( int unDia, double unMonto )
    {
        dia = unDia;
        monto = unMonto;
    }

    public void acumula(double unMonto )
    {
        monto += unMonto;
    }

   public int comparaCon( Object t)
   {
       return this.dia - ((ClsDiaMontoT)t).dia;
   }

    public int comparaCon( int x )
    {
       return this.dia - x; 
    }

    public int getDia()
    {
        return dia;
    }

    public double getMonto()
    {
        return monto;
    }

    public String toString()
    {
        return "Dia: " + this.dia + " monto: " + monto + '\n';
    }

}
