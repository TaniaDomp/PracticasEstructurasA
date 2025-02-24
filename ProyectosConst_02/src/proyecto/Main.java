/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
/**
 *
 * @author rggh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EstrucTopo st = new EstrucTopo();
        EstrucTopo sal;
        // TODO code application logic here
        System.out.println("Hola, uso del Ordenamiento Topológico");

        st.agregaAct(1,2,10567.0, 12);
        st.agregaAct(2,4,24325.0,15);
        st.agregaAct(4,6,2500.0,2);
        st.agregaAct(2,10,57800.0,4);
        st.agregaAct(4,8,17325.0,3);
        st.agregaAct(6,3,125323,12);
        st.agregaAct(1,3,500,5);
        st.agregaAct(3,5,17500.0,14);
        st.agregaAct(5,8,3500,1);
        st.agregaAct(7,5,12750,3);
        st.agregaAct(7,9,25000.0,10);
        st.agregaAct(9,4,4500,2);
        st.agregaAct(9,10,35000,8);

        System.out.println("Estructura previa al ordenamiento:\n" + st );
        sal = st.ordena();
        System.out.println("------------------------------------------");
        System.out.println("Estructura posterior al ordenamiento:\n" + st );

        System.out.println("Estructura ordenada:\n" + sal );
        System.out.println("===========================================");
        double porcionCostoAlFinal = 0.50;
        sal.diasCostoT("Proyecto de prueba",porcionCostoAlFinal,0);
        System.out.println("===========================================");

    }

}
