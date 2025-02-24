/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abobal;

/**
 *
 * @author rggh
 */
public class NodoAbo
{
  private int id;
  private NodoAbo izq,der;
  private int hizq, hder, des;

  public NodoAbo( int id )
  {
      this.id = id;
      der = null;
      izq = null;
      hizq = 0;
      hder = 0;
      des = 0;
  }

public static NodoAbo rotacionDerecha( NodoAbo ap)
{
    NodoAbo a,b,c;
    System.out.println("Rotación Derecha sobre el " + ap.id());

    a = ap;
    b = ap.izq;
    c = ap.izq.der;

    ap    = b;
    a.izq = c;
    b.der = a;

    ap.der.hizq = ap.der.izq != null ? ap.der.izq.h()+1: 0;
    ap.der.des = ap.der.hder - ap.der.hizq;
    ap.hder = ap.der.h() + 1;
    ap.des = ap.hder - ap.hizq;

    return ap;
}

public static NodoAbo rotacionIzquierda( NodoAbo ap)
{
    NodoAbo a,b,c;
    System.out.println("Rotación Izquierda sobre el " + ap.id());

    a = ap;
    b = ap.der;
    c = ap.der.izq;

    ap    = b;
    a.der = c;
    b.izq = a;

    ap.izq.hder = ap.izq.der != null ? ap.izq.der.h()+1: 0;
    ap.izq.des = ap.izq.hder - ap.izq.hizq;
    ap.hizq = ap.izq.h() + 1;
    ap.des = ap.hder - ap.hizq;

    return ap;
}
public static NodoAbo rotacionIzquierdaDerecha( NodoAbo ap)
{
  System.out.println("Rotación izquierdaDerecha sobre el " + ap.id());
  ap.izq = NodoAbo.rotacionIzquierda(ap.izq);
  ap = NodoAbo.rotacionDerecha(ap);
  return ap;
}

public static NodoAbo rotacionDerechaIzquierda( NodoAbo ap)
{
  System.out.println("Rotación DerechaIzquierda sobre el " + ap.id());
  ap.der = NodoAbo.rotacionDerecha(ap.der);
  ap = NodoAbo.rotacionIzquierda(ap);
  return ap;
}

public static NodoAbo verificaYEquilibra( NodoAbo ap )
{
  if( ap.des() == -2 )
  {
    if( ap.izq.des() == -1 )
        ap = NodoAbo.rotacionDerecha(ap);
    else
        if( ap.izq.des() == 1 )
            ap = NodoAbo.rotacionIzquierdaDerecha(ap);
  }
  else
    if( ap.des() == 2 )
    {
      if( ap.der.des() == 1  )
          ap = NodoAbo.rotacionIzquierda(ap);
      else
          if( ap.der.des() == -1 )
              ap = NodoAbo.rotacionDerechaIzquierda(ap);
    }
  return ap;
}

  public boolean agrega(int id)
  {
      boolean blnRes = false;
      if( this.id != id )
          if( id < this.id )
          {
              if( izq != null )
                  blnRes = izq.agrega(id);
              else
              {
                izq = new NodoAbo(id);
                blnRes = true;
              }
              if( blnRes )
              {
                  izq = verificaYEquilibra(izq);
                  hizq = izq.h() + 1;
                  des = hder - hizq;                
              }
          }
          else
          {
              if( der != null )
                  blnRes = der.agrega(id);
              else
              {
                 der = new NodoAbo(id);
                 blnRes = true;
              }
              if( blnRes )
              {
                  der = verificaYEquilibra(der);
                  hder = der.h()+1;
                  des = hder - hizq;                  
              }
          }
      return blnRes;
  }

  public NodoAbo busca(int id)
  {
      NodoAbo apRes = null;
      if( this.id == id )
          apRes = this;
      else
      {
          if( id < this.id )
          {
              if( izq != null )
                apRes = izq.busca(id);
          }
          else
          {
            if( der != null )
                apRes = der.busca(id);
          }
      }
      return apRes;
  }

  public int id() { return id;}

  public int des() { return hder - hizq; }

  public int h()
  {
      return hder > hizq ? hder : hizq;
  }

  boolean verificaAlturas()
  {
      boolean blnRes, blnIzq = true, blnDer = true;
      int hizq_v,hder_v;

      if( izq != null ) blnIzq = izq.verificaAlturas();
      if( der != null ) blnDer = der.verificaAlturas();

      hizq_v = izq != null ? (izq.h() + 1 ): 0;
      hder_v = der != null ? (der.h() + 1 ): 0;

      blnRes = blnIzq && blnDer;
      if ( hizq != hizq_v || hder != hder_v )
      {
          blnRes = false;
          System.out.println("Diferencia en alturas en el nodo " + id +
                             "hizq:" + hizq + ", hizq_v:" + hizq_v + '\n' +
                             "hder:" + hder + ", hder_v:" + hder_v);
      }
      if( des >= 2 || des <= -2 )
      {
          blnRes = false;
          System.out.println("Desequilibrio en el nodo " + id +
                             " des: " + des + ", hder: " + hder + ", hizq: " + hizq);
      }

      return blnRes;
  }

  public void toStringBuider( StringBuilder sb )
  {
     if( izq != null )
         izq.toStringBuider(sb);

     sb.append(this.getClass().getName() + " con contenido:" + id +
             ", hizq:" + hizq + ", hder:" + hder + ", des: " + this.des() +
             (izq != null ? ", izq.id:" + izq.id() : "   ") +
             (der != null ? ". der.id:" + der.id() : "   ") + '\n');

     if( der != null )
         der.toStringBuider(sb);

  }

  // ========================================================================

  public long numNodos()
  {
      long lngRes = 1;

      if( izq != null ) lngRes += izq.numNodos();
      if( der != null ) lngRes += der.numNodos();

      return lngRes;
  }

  // ========================================================================
}
