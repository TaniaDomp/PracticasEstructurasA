/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_00;

/**
 *
 * @author RGAMBOAH
 */
public class Cola_00 {

    /**
     * @param args the command line arguments
     */
    private int[] A;
    private int N;
    private int Libres;
    private int idxE;  // siguiente orden libre
    private int idxS;  // primero en la cola (siguiente a salir)
    
    public Cola_00(int n)
    {
      this.N      = n;  
      this.A      = new int[n];
      this.Libres = n;
      this.idxE   = this.idxS = 0;
    }
    public boolean agrega(int x)
    {
        boolean blnRes = this.Libres > 0;
        if( blnRes )
        {
            this.A[this.idxE % this.N] = x;
            this.idxE++;
            this.Libres--;
        }
        return blnRes;
    }
    
    public boolean salida(int dato[])
    {
        boolean blnRes = this.Libres < this.N;
        if( blnRes )
        {
            dato[0] = this.A[idxS % this.N];
            this.idxS++;
            this.Libres++;
        }
        return blnRes;
    }
    
    public boolean vacia()
    {
        return this.Libres == this.N;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Cola con " + ( this.idxE - this.idxS ) + " elementos:\n");
        if(this.vacia())
            sb.append("Vacía...");
        else
            for(int k = this.idxS; k < this.idxE; k++)
                sb.append(" " + this.A[k%this.N]);
            sb.append('\n');
        return new String(sb);
    }
    
    public static void main(String[] args) 
    {
      boolean ALEATORIZA = false;
      long estado;
      if(ALEATORIZA)
          estado = (long)(1000.0 * Math.random()+1.0);
      else
          estado = 42;
      java.util.Random rndGen = new java.util.Random(estado); 
        
       int x[] = new int[1]; 
       double p = (float) 0.75; 
       Cola_00 c = new Cola_00(20);
       
       for(int k = 1; k <= 100; k++)
       {    
         if(rndGen.nextDouble()< p || c.vacia())
         {
           if(c.agrega(k))
               System.out.println("Se agregó el " + k);
           else
               System.out.println("NO se pudo agregar el " + k);
         }
         else
         {
               if( c.salida(x))
                 System.out.println("Sale el " + x[0]);
               else
                   System.out.println("No hay dato para extraer");
         }
           System.out.println(c);
       }
    }
    
}
