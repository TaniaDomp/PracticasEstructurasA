/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
/**
 *
 * @author RGGH
 */
public class ClsFlujoDeEfectivo
{
    java.util.TreeMap<Integer,ClsDiaMontoT> abofe = new java.util.TreeMap<Integer,ClsDiaMontoT>();
    String strDescripcion;

    ClsFlujoDeEfectivo( String unaDescripcion )
    {
        strDescripcion = unaDescripcion;
    }

    public void acumula( int unDia, double unMonto )
    {
       ClsDiaMontoT t =  abofe.get(new Integer(unDia));
       if( t != null )
           t.acumula(unMonto);
       else
           abofe.put(new Integer(unDia),new ClsDiaMontoT(unDia,unMonto));
    }

    public void acumula( ClsFlujoDeEfectivo fe )
    {
        for( ClsDiaMontoT dm : fe.abofe.values())
        {
            this.acumula( dm.getDia(), dm.getMonto());
        }
    }

    @Override
    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      java.text.NumberFormat frm = java.text.NumberFormat.getCurrencyInstance();
      String strMonto, strDia;
      Double monto_total = 0.0;
      sb.append(strDescripcion + '\n' + "numDia,        monto\n");
      for( ClsDiaMontoT dm : abofe.values())
      {
        monto_total += dm.monto;
        strMonto = "                     " + frm.format(dm.monto);
        strDia = "     " + dm.dia;
        strDia = strDia.substring(strDia.length()-5);
        sb.append(strDia + ", " + strMonto.substring(strMonto.length()-15) + '\n' );
      }
      strMonto = "                     " + frm.format(monto_total);
      sb.append("Total:" + strMonto.substring(strMonto.length()-16) + '\n');
      return new String(sb);
    }

}
