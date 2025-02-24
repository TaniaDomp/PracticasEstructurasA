/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author rggh
 */
public class EstrucTopo
{
    NodoTopo prim;

    public EstrucTopo()
    {
       prim = null;
    }

    public EstrucTopo ordena()
    {
        EstrucTopo so = new EstrucTopo();
        NodoTopo nt;
        nt = localizaNumPredCero();
        while( nt != null )
        {
            so.localiza(nt.id); // para que lo agregue
            nt.decrementa();
            nt = this.localizaNumPredCero();
        }
        this.copiaRels(so);
        so.obtenTiemposDeInicio();
        return so;
    }

    public NodoTopo localizaNumPredCero()
    {
        NodoTopo nt = null;
        if( prim != null )
            nt = prim.localizaNumPredCero();
        return nt;
    }

    public void agrega( int id_Pred, int id_Suc )
    {
         NodoTopo ap_pred, ap_suc;

         ap_pred = this.localiza( id_Pred );
         ap_suc  = this.localiza( id_Suc  );
         ap_pred.agrega(ap_suc);
    }

    public void agregaAct( int id_Pred, int id_Suc, double costo, int duracion )
    {
         NodoTopo ap_pred, ap_suc;

         ap_pred = this.localiza( id_Pred );
         ap_suc  = this.localiza( id_Suc  );
         ap_pred.agrega(ap_suc, costo,duracion);
    }

    public void agregaAct( int id_Pred, int id_Suc, String strNomActividad,
                           int idTipoDeRecurso, int numRecursos,
                           double costo, int duracion )
    {
         NodoTopo ap_pred, ap_suc;

         ap_pred = this.localiza( id_Pred );
         ap_suc  = this.localiza( id_Suc  );
         ap_pred.agrega(ap_suc, strNomActividad,idTipoDeRecurso, numRecursos,
                        costo,duracion);

    }


    private NodoTopo localiza( int id )
    {
        if( prim != null )
            return prim.localizate(id);
        else
        {
            prim = new NodoTopo( id );
            return prim;
        }           
    }

    private void copiaRels( EstrucTopo dest )
    {
        // copia las relaciones de this a dest
        if( prim != null )
            prim.copiaRels(dest);
    }

    private void obtenTiemposDeInicio()
    {
         if( prim != null )
         {
             prim.calculaInicioNodo();
             prim.actualizaInicioSucesores();
         }
    }


    // nueva funcionalidad 13 oct 2010
    public ClsFlujoDeEfectivo diasCostoT( String desc, double porcCostoAlFinal, int diaInicio )
    {
        ClsFlujoDeEfectivo fe = new ClsFlujoDeEfectivo("Flujo de efectivo del proyecto " + desc );
        if( prim != null )
          prim.costoDiasT(fe, porcCostoAlFinal, diaInicio );
        //System.out.println("Costo por día:\n" + fe );
        return fe;
    }

    public ClsUsoDeRecursos obtenUsoDeRecursos( String desc, int numDiaMax, int diaInicioProyecto )
    {
        ClsUsoDeRecursos ur = new ClsUsoDeRecursos( desc, numDiaMax );

        if( prim != null )
            prim.usoDeRecursos(ur, diaInicioProyecto);

        return ur;
    }


    @Override
    public String toString()
    {
        if( prim == null )
            return "Estructura vacía\n";
        else
            return prim.toString();
    }

}
