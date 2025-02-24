package redtopo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.javatuples.Pair;   //para ocupar la tupla de pares se debe agregar a las librerias el jar correspondiente
/**
 *
 * @author tania
 */
public class RedTopologica {
    private Map<Integer, NodoTopo> nodos;
    private ArrayList<NodoTopo> nodosOrdenados;
    
    public RedTopologica(ArrayList<Pair> relaciones){
        this.nodos = new LinkedHashMap<>();
        this.nodosOrdenados = new ArrayList<>();
        this.agregaColRel(relaciones);
        this.ordenTopo();
    }
    
    private void agregaColRel(ArrayList<Pair> relaciones){
        int val1, val2;
        int i = 0;
        Pair<Integer, Integer> rel;
        
        while(i < relaciones.size()){
            rel = relaciones.get(i);
            val1 = rel.getValue0(); //obtiene los dos valores de la relacion
            val2 = rel.getValue1();
            if(!this.nodos.containsKey(val1)){
                this.nodos.put(val1, new NodoTopo(val1));
            }
            if(!this.nodos.containsKey(val2)){
                this.nodos.put(val2, new NodoTopo(val2));
            }
            //actualizamos la relacion entre nodos
            this.nodos.get(val1).agregaSucesor(this.nodos.get(val2));
            i++;
        }
    }
    
    private void ordenTopo(){
        NodoTopo aux = null; //para usar la variable fuera del ciclo for
        while(!this.nodos.isEmpty()){
            //Ciclo corto no recomendado
            for(NodoTopo nodo: this.nodos.values()){
                aux = nodo;
                if(aux.getNumPred() == 0){
                    break;
                }
            }
            if(aux.getNumPred() == 0){
                this.nodosOrdenados.add(aux);
                aux.modificaPredSucesores();
                this.nodos.remove(aux.getId()); //elimina el nodo del map
            }
            else{
                throw new RuntimeException("Hay al menos un ciclo");
            }
        }
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nRed Topologica");
        for(NodoTopo nodo: this.nodosOrdenados){
            cad.append(nodo.toString());
        }
        return cad.toString();
    }
}
