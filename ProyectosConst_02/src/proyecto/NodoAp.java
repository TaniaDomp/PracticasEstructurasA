/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author rggh
 */
public class NodoAp
{
    NodoTopo nt;
    NodoAp   sigAp;
    String   strNomAct;
    int      idTipoDeRecurso;
    int      numRecursos;
    double   costo;
    int      duracion;

   NodoAp( NodoTopo nt )
   {
      this.nt  = nt;
      sigAp    = null;
      costo    = 0.0;
      duracion = 0;
   }

   // funcionalidad agregada
   NodoAp( NodoTopo nt, double costo, int duracion )
   {
      this.nt       = nt;
      sigAp         = null;
      this.costo    = costo;
      this.duracion = duracion;
   }

   NodoAp( NodoTopo nt, String nomAct, int idTipoRec, int numDeRec,double costo, int duracion )
   {
      this.nt              = nt;
      sigAp                = null;
      this.strNomAct       = nomAct;
      this.idTipoDeRecurso = idTipoRec;
      this.numRecursos     = numDeRec;
      this.costo           = costo;
      this.duracion        = duracion;
   }



   public void costoDiasT(ClsFlujoDeEfectivo fe, int diasNodoTopo, double porcCostoAlFinal )
   {
       double costoAlFinal = porcCostoAlFinal * this.costo;

       if( costoAlFinal != 0.0 )
         fe.acumula(diasNodoTopo + this.duracion - 1, costoAlFinal);

       if( this.sigAp != null )
           sigAp.costoDiasT(fe, diasNodoTopo, porcCostoAlFinal);
   }

   public void usoDeRecursos( ClsUsoDeRecursos ur, int diaInicio )
   {
       // este es el que realmente hace el rabajo:
       ur.acumula(this.idTipoDeRecurso, diaInicio, duracion, numRecursos);

       if( this.sigAp != null ) sigAp.usoDeRecursos(ur,diaInicio);
   }

// funcionalidad agregada
   public void actualizaDiaDeInicioDeNodoSucesor( int diasInicioNodoPredecesor )
   {
      nt.actualizaInicio(diasInicioNodoPredecesor + duracion);
      if( sigAp != null )
          sigAp.actualizaDiaDeInicioDeNodoSucesor(diasInicioNodoPredecesor);
   }

/*
// funcionalidad agregada
   public NodoAp getSigAp()
   {
       return this.sigAp;
   }
 */

// funcionalidad agregada
   public double getCosto()
   {
       return this.costo;
   }

// funcionalidad agregada
   public int getDuracion()
   {
       return this.duracion;
   }

   public void agrega( NodoTopo nt )
   {
       if( sigAp != null )
           sigAp.agrega(nt);
       else
       {
           sigAp = new NodoAp(nt);
           nt.numPred++;
       }
   }

   // funcionalidad agregada
   public void agrega( NodoTopo nt, double costo,int duracion )
   {
       if( sigAp != null )
           sigAp.agrega(nt,costo,duracion);
       else
       {
           sigAp = new NodoAp(nt,costo, duracion);
           nt.numPred++;
       }
   }


   public void agrega( NodoTopo nt, String nomAct, int idTipoRec, int numDeRec,
                       double costo,int duracion )
   {
       if( sigAp != null )
           sigAp.agrega(nt, nomAct, idTipoRec, numDeRec, costo, duracion);
       else
       {
           sigAp = new NodoAp(nt, nomAct, idTipoRec, numDeRec, costo, duracion);
           nt.numPred++;
       }
   }


   public void decrementa()
   {
       nt.numPred--;
       if( sigAp != null )
           sigAp.decrementa();
   }

    public void copiaRels( int idActual, EstrucTopo dest )
    {
        // copia las relaciones de this a dest
        dest.agregaAct(idActual,  nt.id, 
                       this.strNomAct, this.idTipoDeRecurso, this.numRecursos,
                       this.costo, this.duracion);
        if( sigAp != null )
            sigAp.copiaRels(idActual, dest);
    }


    @Override
   public String toString()
   {
       String strRes = nt.id + ", " + strNomAct + ", idRec:" + idTipoDeRecurso + 
                        ", numrec:" + this.numRecursos + 
                        ", Costo:" + costo + ", Dur(dias):" + duracion + '\n';
       if( sigAp != null )
           strRes = strRes + sigAp;
       return strRes;
   }
}
