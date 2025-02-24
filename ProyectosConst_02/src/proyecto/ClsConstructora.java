/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.util.TreeMap;

/**
 *
 * @author RGGH
 */
public class ClsConstructora
{
    private String nomCia;
    private TreeMap<Integer,ClsProyectoT> colProyectos;

    public ClsConstructora( String nomCia )
    {
        this.nomCia = nomCia;
        colProyectos = new TreeMap<Integer, ClsProyectoT>();
    }

    public void agregaProyecto( int idProyecto, String nomProyecto, int unDiaDeInicio )
    {
        colProyectos.put(new Integer(idProyecto),new ClsProyectoT(idProyecto,nomProyecto, unDiaDeInicio));
    }

    public void agregaAct( int idProyecto,
                           int id_Pred, int id_Suc, String strNomActividad,
                           int idTipoDeRecurso, int numRecursos,
                           double costo, int duracion )
    {
       ClsProyectoT proy = colProyectos.get(new Integer(idProyecto));
       if( proy != null )
           proy.agregaAct(id_Pred, id_Suc, strNomActividad, idTipoDeRecurso, numRecursos, costo, duracion);
       else
            System.out.println("*************************************************\n"+
                               "Error al localizar el proyecto con id " + idProyecto +
                               "*************************************************\n");
    }

    public void ordenaProyectos()
    {
        java.util.Collection<ClsProyectoT> col = colProyectos.values();
        for( ClsProyectoT proy : col )
        {
              proy.ordena();
        }
  
    }

    public ClsFlujoDeEfectivo obtenFE(double porcionCostoAlFinal,boolean blnImpr )
    {
        ClsFlujoDeEfectivo fec = new ClsFlujoDeEfectivo(
                            "Flujo de efectivo de la constructora " + nomCia );
        ClsFlujoDeEfectivo fep;
               
        for( ClsProyectoT proy : colProyectos.values() )
        {
            fep = proy.obtenFlujoDeEfectivoT(porcionCostoAlFinal);
            if( blnImpr )
            {
               System.out.println("############################################");
               System.out.print(fep);
               System.out.println("############################################\n");
            }
            fec.acumula(fep);
        }

        return fec;
    }

   public ClsUsoDeRecursos obtenUR()
   {
       int numDiaMax = this.obtenDiaMax();
       ClsUsoDeRecursos urc = new ClsUsoDeRecursos( "Uso de recursos de " +
                                                    this.nomCia, numDiaMax );
       ClsUsoDeRecursos urp = null;
       java.util.Collection<ClsProyectoT> col = colProyectos.values();
        for( ClsProyectoT proy : col )
        {
            urp = proy.obtenUR( numDiaMax );
            System.out.println("############################################\n");
            System.out.println("UR del proyecto:" + urp);
            System.out.println("############################################\n");
            urc.acumula(urp);
        }
        return urc;
   }

   public int obtenDiaMax( )
   {
       int diaMax;
       ClsFlujoDeEfectivo fec = this.obtenFE(0.50,false);
//       System.out.println("<<<<<<<<<<<<<<<< FE del proyecto, para fines del día mayor: <<<<<<<<<<<<<<<<<<<<<<<<<<<");
//       System.out.println(fec);
//       System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
       Integer lk = fec.abofe.lastKey();
       diaMax = lk.intValue();
       return diaMax;
   }

    @Override
   public String toString()
   {
       StringBuilder sb = new StringBuilder();
       sb.append(nomCia + ":\n" );
        java.util.Collection<ClsProyectoT> col = colProyectos.values();
        for( ClsProyectoT proy : col )
        {
          sb.append(proy);
        }
       return new String(sb);
   }
}
