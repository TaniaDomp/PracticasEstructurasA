/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abobal;

/**
 *
 * @author rggh
 */
public class AsaAbo
{
  private NodoAbo raiz;

  public boolean agrega( int id )
  {
      boolean blnRes;
      if( raiz == null )
      {
          raiz = new NodoAbo(id);
          blnRes = true;
      }
      else
      {
          blnRes = raiz.agrega(id);
          if( blnRes )
              raiz = NodoAbo.verificaYEquilibra(raiz);

      }
      return blnRes;
  }

  public NodoAbo busca( int id )
  {
      if( raiz == null )
          return null;
      else
          return raiz.busca(id);
  }

  public int h(){ return raiz.h() + 1;}

  public boolean verificaAlturas()
  {
      boolean blnRes = true;
      System.out.println("Verificando alturas...");
      if( raiz != null ) blnRes = raiz.verificaAlturas();
      return blnRes;
  }
  
  public String toString()
  {
      StringBuilder sb = new StringBuilder();
      if( raiz == null )
          sb.append("Abo sin Nodos\n");
      else
      {
          sb.append("Abo conteniendo:\n" + 
                    "raiz: " + raiz.id() + " des(raiz): " + raiz.des() + '\n');
          raiz.toStringBuider(sb);
      }
      return new String(sb);
  }

    // ========================================================================

  public long numNodos()
  {
      long lngRes = 0;

      if( raiz != null ) lngRes += raiz.numNodos();

      return lngRes;
  }
  
  // ========================================================================

}
