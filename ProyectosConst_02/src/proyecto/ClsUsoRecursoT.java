/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author RGGH
 */
public class ClsUsoRecursoT implements IComparable
{
    int idRecurso;
    int arr_numRecPorDia[];
    int numDiaMax;

    ClsUsoRecursoT( int idRec, int unNumDiaMax )
    {
        idRecurso = idRec;
        numDiaMax = unNumDiaMax;
        arr_numRecPorDia = new int[numDiaMax+1];
        for( int i = 0; i <= numDiaMax; i++ ) arr_numRecPorDia[i] = 0;

        //System.out.println("Se crea el ClsUsoRecursoT para " + idRecurso + " de 0 a " + numDiaMax);
    }

    public void agrega( int diaInicio, int duracion, int numRec)
    {
        for( int i = diaInicio; i < diaInicio + duracion; i++)
          arr_numRecPorDia[i] += numRec;
    }

    public void agrega( ClsUsoRecursoT ur )
    {
        for(int i = 0; i <= numDiaMax; i++ )
            this.arr_numRecPorDia[i] += ur.arr_numRecPorDia[i];
    }

    public int comparaCon(Object t)
    {
          return this.idRecurso - ((ClsUsoRecursoT) t).idRecurso;
    }

    public int comparaCon(int x)
    {
       return this.idRecurso - x;
    }

    @Override
    public String toString()
    {
        String str;
        int numTotRec = 0;
        StringBuilder sb = new StringBuilder(
                               "------------------------- \n" +
                               "  Uso del recurso id:" + idRecurso + '\n' +
                               "------------------------- \n");
        for( int i = 0; i <= numDiaMax; i++ )
          if( arr_numRecPorDia[i] != 0 )
          {
            numTotRec += arr_numRecPorDia[i];
            str = "    " + i;
            str = str.substring(str.length()- 4);
            sb.append("Día:" + str + "     numRec:" + arr_numRecPorDia[i] + '\n');
          }
            str = "       " + this.idRecurso;
            str = str.substring(str.length()- 6);
          sb.append("idRecurso " + str + ", Total de recurso - dia: " + numTotRec + '\n');
        return new String(sb);
    }
}
