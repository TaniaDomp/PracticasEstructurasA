/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim_mm1_00;

/**
 *
 * @author RGGH
 */
public class ClsComparaClientes implements java.util.Comparator<ClsCliente>
{
    public int compare( ClsCliente c1, ClsCliente c2 )
    {
        double c1n = c1.getNum();
        double c2n = c2.getNum();

        return ( c1n - c2n > 0 ? 1 : ( c1n == c2n ? 0: -1));

    }

}
