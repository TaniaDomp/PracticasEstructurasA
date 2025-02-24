package mochila;
/**
 *
 * @author tania
 */
public class Combinacion implements Comparable<Combinacion>{
    private String valor;
    private String peso;
    private String combina;
    
    public Combinacion(String valor, String peso, String combina){
        this.valor = valor;
        this.peso = peso;
        this.combina = combina;
    }
    
    public int compareTo(Combinacion art){
        return this.valor.compareTo(art.valor);
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\n Combinacion: " + combina);
        cad.append("\n Peso: " + peso);
        cad.append("\n Valor: " + valor);
        return cad.toString();
    }
}
