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

   ClsGenExponenciales( double deltaTProm)
   {
       dblDeltaTpromGen = deltaTProm;
   }

   public void asignaDeltaTpromedio( double deltaTProm )
   {
      dblDeltaTpromGen = deltaTProm;
   }

   public double deltaT()
   {
       return - dblDeltaTpromGen * Math.log(Math.random());
   }

}
