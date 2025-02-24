/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsGenExponenciales {
   private double dblDeltaTpromGen;
   private java.util.Random rndGen;
   
   ClsGenExponenciales( double deltaTProm)
   {
       dblDeltaTpromGen = deltaTProm;
   }

   public void asignaDeltaTpromedio( double deltaTProm,java.util.Random genRandom)
   {
      this.dblDeltaTpromGen = deltaTProm;
      this.rndGen = genRandom;
   }
   
   public double deltaT()
   {
       return - dblDeltaTpromGen * Math.log(rndGen.nextDouble());
   }

}
