package ejemplo_01;
/**Tania Ariadna Dominguez Palma
 * 08/08/2022
 * Programa que nos permite mostrar un texto desde el CMD
 */
public class Ejemplo_01 {

    public static void main(String[] args) {
        /*int n = args.length;
        if(n == 0){
            System.out.println("Sin argumentos...");
        }
        else{
            for(int i = 0; i < n; i++){
                System.out.println("Indice del argumento " + i + ": " + args[i]);
            }
        }*/
        StringBuilder cad = new StringBuilder();
        for(int i = 0; i < 5; i++){
            cad.append(i);
        }
        System.out.println(cad.charAt(5));
    }
    
}
