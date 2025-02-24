/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import proyecto.IComparable.*;
/**
 *
 * @author RGGH
 */
public class ClsProyectoT implements proyecto.IComparable
{
   int        idProyecto;
   String     strNombre;
   EstrucTopo st;
   int        diaDeInicio;

   public ClsProyectoT( int id, String nombre , int diaDeInicio )
   {
       this.idProyecto  = id;
       this.st          = new EstrucTopo();
       this.strNombre   = nombre;
       this.diaDeInicio = diaDeInicio;
   }

   public void setDiaDeInicio( int unDiaDeInicio)
   {
       diaDeInicio = unDiaDeInicio;
   }

   public int comparaCon( Object t)
   {
      ClsProyectoT x = (ClsProyectoT) t;
      return ( this.idProyecto - x.idProyecto);
   }

   public int comparaCon(int x)
   {
        return this.idProyecto - x;
   }

   public void agregaAct( int id_Pred, int id_Suc, String strNomActividad,
                           int idTipoDeRecurso, int numRecursos,
                           double costo, int duracion )
   {
        st.agregaAct(id_Pred, id_Suc, strNomActividad,
                     idTipoDeRecurso,numRecursos,
                     costo, duracion);
   }

   public void ordena()
   {
        st = st.ordena();
   }

// nueva funcionalidad 13 oct 2010
   public ClsFlujoDeEfectivo obtenFlujoDeEfectivoT(double porcionCostoAlFinal)
   {
       return st.diasCostoT(this.strNombre, porcionCostoAlFinal, diaDeInicio);  
   }

 // nueva funcionalidad 14 de oct 2010
   public ClsUsoDeRecursos obtenUR( int numDiaMax  )
   {
      return st.obtenUsoDeRecursos( this.strNombre, numDiaMax, this.diaDeInicio );
   }

    @Override
   public String toString()
   {
        return "\n\n---------->Proyecto con Id:" + this.idProyecto + ", " +
                this.strNombre + "; inicio al dia:" + this.diaDeInicio +  '\n' +
                st.toString();
   }
}
