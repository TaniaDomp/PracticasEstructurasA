/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author RGGH
 */
public class ClsUsoDeRecursos
{
    String strDescripcion;
    int numDiaMax;
    java.util.TreeMap<Integer,ClsUsoRecursoT> recursos;

    public ClsUsoDeRecursos( String unaDescripcion, int unNumDiaMax )
    {
        strDescripcion = unaDescripcion;
        numDiaMax      = unNumDiaMax;
        recursos       = new java.util.TreeMap<Integer,ClsUsoRecursoT>();
        //System.out.println("Se creará el objeto para el uso de recursos de " + strDescripcion);
    }

    public void acumula( int idRecurso, int diaInicial, int duracion, int numRec )
    {
      
        ClsUsoRecursoT t = this.recursos.get(new Integer(idRecurso));
        if( t == null )
        {
            t = new ClsUsoRecursoT( idRecurso, numDiaMax );
            recursos.put(new Integer(idRecurso),t);
        }
        t.agrega(diaInicial, duracion, numRec);
    }

    public void acumula( ClsUsoRecursoT urt )
    {
        ClsUsoRecursoT t = this.recursos.get(new Integer(urt.idRecurso));
        if( t == null )
        {
            t = new ClsUsoRecursoT( urt.idRecurso, numDiaMax );
            recursos.put(new Integer(urt.idRecurso),t);
        }
        t.agrega(urt);
    }

    public void acumula( ClsUsoDeRecursos urs )
    {
        for( ClsUsoRecursoT urt : urs.recursos.values())
        {
            this.acumula( urt );
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( strDescripcion + '\n');
        for( ClsUsoRecursoT urt : recursos.values())
            sb.append( urt );

        return new String(sb);
    }
}
