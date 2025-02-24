/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author rggh
 */
public class NodoTopo
{
  public  int      id;
  public  int      numPred;
  private NodoTopo sigNodoTopo;
  private NodoAp   primAp;
  private boolean  yaSalio;
  private double   costo_inicio;
  private int      inicio;

  public NodoTopo( int id )
  {
      this.id      = id;
      numPred      = 0;
      sigNodoTopo  = null;
      primAp       = null;
      yaSalio      = false;
      costo_inicio = 0.0;
      inicio       = 0;

  }

  public NodoTopo localizate( int id )
  {
      if( this.id == id )
          return this;
      else
          if( sigNodoTopo != null )
              return sigNodoTopo.localizate(id);
          else
          {
             sigNodoTopo = new NodoTopo(id);
             return sigNodoTopo;
          }
  }

  public void agrega( NodoTopo nt )
  {
      if( primAp != null )
          primAp.agrega(nt);
      else
      {
          primAp = new NodoAp( nt);
          nt.numPred++;
      }
  }
  public void agrega( NodoTopo nt, double costo, int duracion  )
  {
      if( primAp != null )
          primAp.agrega(nt, costo,duracion);
      else
      {
          primAp = new NodoAp( nt, costo, duracion);
          nt.numPred++;
      }
  }

  public void agrega( NodoTopo nt, String nomAct, int idTipoRec, int numDeRec,
                      double costo, int duracion  )
  {
      if( primAp != null )
          primAp.agrega(nt, nomAct, idTipoRec, numDeRec, costo, duracion);
      else
      {
          primAp = new NodoAp( nt, nomAct, idTipoRec, numDeRec, costo,duracion);
          nt.numPred++;
      }
  }

   public NodoTopo localizaNumPredCero()
   {
       if( this.numPred == 0 && !yaSalio )
       {
           yaSalio = true;
           return this;
       }
       else
           if( sigNodoTopo != null )
               return sigNodoTopo.localizaNumPredCero();
       return null;
   }

  public void decrementa()
  {
      if( primAp != null )
          primAp.decrementa();
  }

  public void actualizaInicio( int nvaDuracion )
  {
     if( nvaDuracion > this.inicio )
        this.inicio = nvaDuracion;
  }

  public void copiaRels( EstrucTopo dest )
  {
      if( primAp != null)
          primAp.copiaRels(this.id, dest);
      if( sigNodoTopo != null )
          sigNodoTopo.copiaRels(dest);
  }

  // Funcionalidad adicional
  public void calculaInicioNodo()
  {
      this.costo_inicio = 0.0;

      NodoAp ap = this.primAp;
      while( ap != null )
      {
          this.costo_inicio += ap.getCosto();
          ap = ap.sigAp;
      }
      if( sigNodoTopo != null )
          sigNodoTopo.calculaInicioNodo();
  }

 // Funcionalidad adicional
  public void actualizaInicioSucesores()
  {
      if( primAp != null )
          primAp.actualizaDiaDeInicioDeNodoSucesor(this.inicio);

      if( sigNodoTopo != null )
          sigNodoTopo.actualizaInicioSucesores();
  }

   public void costoDiasT(ClsFlujoDeEfectivo fe,  
                          double porcCostoAlFinal,
                          int diaInicioProyecto  )
   {
       double costo = ( 1.0 - porcCostoAlFinal ) * this.costo_inicio;

       if( costo != 0.0 )
           fe.acumula(this.inicio + diaInicioProyecto , costo );

       if( this.primAp != null )
           primAp.costoDiasT(fe, this.inicio + diaInicioProyecto, porcCostoAlFinal);

       if( sigNodoTopo != null )
           sigNodoTopo.costoDiasT(fe, porcCostoAlFinal, diaInicioProyecto);
   }

   public void usoDeRecursos( ClsUsoDeRecursos ur, int diaInicioProyecto )
   {
       if( primAp != null )
           primAp.usoDeRecursos( ur,this.inicio + diaInicioProyecto );

       if( sigNodoTopo != null )
           sigNodoTopo.usoDeRecursos(ur, diaInicioProyecto );
   }
    @Override
  public String toString()
  {
      String strRes;
      strRes = "\nNodoTopo con id " + id + " con " + 
               this.numPred + " predecesores, costo_inicio: " +
               this.costo_inicio + ", inicio: " + this.inicio + '\n';
      if( primAp != null )
          strRes = strRes + primAp.toString();
      if( sigNodoTopo !=  null )
          strRes +=  sigNodoTopo.toString();
      return strRes;
  }


}
