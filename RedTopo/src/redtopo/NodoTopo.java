package redtopo;
import java.util.ArrayList;

/**
 *
 * @author tania
 */
public class NodoTopo {
    private int id;
    private int numPred;
    private ArrayList<NodoTopo> sucesores;
    
    public NodoTopo(int id){
        this.id = id;
        this.numPred = 0;
        this.sucesores = new ArrayList<>();
    }
    
    public void agregaSucesor(NodoTopo nodo){
        this.sucesores.add(nodo);
        nodo.numPred++;
    }
    
    public int getId(){
        return id;
    }
    
    public int getNumPred(){
        return numPred;
    }
    
    public void eliminaPredecesor(){
        this.numPred--;
    }
    
    public void modificaPredSucesores(){  //elimina un predecesor del nodo eliminado
        for(NodoTopo nodo: this.sucesores){
            nodo.eliminaPredecesor();
        }
    }
    
    public boolean equals(Object obj){
        boolean rel = false;
        NodoTopo nod;
        
        if(obj.getClass().equals(this.getClass())){
            nod = (NodoTopo)obj;
            rel = nod.id == this.id;
        }
        return rel;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nNodo Topo: ");
        cad.append("\n         id: ");
        cad.append(id);
        cad.append("\n         Numero de predecesores: ");
        cad.append(numPred);
        cad.append("\n         Sucesores: ");
        for(int i = 0; i < this.sucesores.size(); i++){
            cad.append("\n         id del sucesor: " + this.sucesores.get(i).id);
        }
        return cad.toString();
    }
}
