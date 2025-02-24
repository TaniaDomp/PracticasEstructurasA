/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsComparaEventos implements java.util.Comparator<ClsEvento>
{
    public int compare( ClsEvento e1, ClsEvento e2 )
    {
        double e1t = e1.getTiempo();
        double e2t = e2.getTiempo();

        return ( e1t - e2t > 0 ? 1 : ( e1t == e2t ? 0: -1));

    }

}
