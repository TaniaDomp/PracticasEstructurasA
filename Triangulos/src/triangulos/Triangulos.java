/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulos;

/**
 *
 * @author RGAMBOAH
 */
public class Triangulos implements Comparable
{
    double a,b,c;
    double area;
    /**
     * @param args the command line arguments
     */
    public Triangulos( double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        double s = 0.5 * ( a + b + c);
        this.area = Math.sqrt( s * ( s - a ) * ( s - b ) * ( s - c));
    }
    
    
    public int compareTo(Object obj) 
    {
       int res = 0; 
       if( obj == null) return -1;
       else
       {
         if(this.area <   ((Triangulos)obj).area ) 
             res = -1;
         else
           if(this.area ==  ((Triangulos)obj).area )
               res =  0;
           else
               res =  1;
       }
       return res;            
    }
    
    public static Triangulos generaTriangulo()
    {
        double a,b,c;
        a = 0.0;
        b = 0.0;
        c = 0.0;
        while((a + b <= c) || (b + c <= a ) || (a + c <= b ))
        {
          a = 10.0 * Math.random() + 1.0;
          b = 10.0 * Math.random() + 1.0;
          c = 10.0 * Math.random() + 1.0;
        }
        return new Triangulos(a,b,c);
    }
   
    public static Triangulos[] generaTriangulos(int n)
    {
        Triangulos ts[] = new Triangulos[n];
        for(int k = 0; k < n; k++)
            ts[k] = Triangulos.generaTriangulo();
        return ts;
    }
    
    public static void main( String args[])
    {
        Triangulos t1 = new Triangulos( 2.0,2.0,3.5);
        Triangulos t2 = new Triangulos( 4.0,4.0,7.0);
        System.out.println("Areas: t1:" + t1.area + ", t2:" + t2.area);
    }
    
    public String toString()
    {
        return "" + this.area;
    }
}
