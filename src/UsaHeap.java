import javax.swing.*;
import javax.swing.text.StringContent;
import javax.swing.text.html.parser.Parser;

/**
 * Created by RafaelMq on 07/03/2016.
 */
public class UsaHeap {

    public static void main(String[] args){

        Heap objHeap = new Heap();
        Heap objNaoHeap = new Heap();



        // int vetorInsereHeap[] = {18,25,41,34,15,11,52,50,48};
        int vetorInsereHeap[] = {18,25,41,34,15,11,52,50,48};

        for(int i=0; i<vetorInsereHeap.length; i++) {
            objHeap.insere(objHeap, vetorInsereHeap[i]);
        }




        while(true) {

            int op, auxI;
            String vetorHeap[];
            String auxS;


            op = Integer.parseInt(JOptionPane.showInputDialog("\nOpções: " +

                    "\n\n" +
                    "\n 1 - Inserir no Heap" +
                    "\n 2 - Remover do Heap" +
                    "\n 3 - Inserir um Vetor nao Heap" +
                    "\n 4 - Constroi Heap do vetor" +
                    "\n\n" +

                    objHeap.imprimeHeap(objHeap) + "\n\n")


            );

            switch (op) {

                case 1:

                    auxI = Integer.parseInt(JOptionPane.showInputDialog(null,"\nDigite o Valor da Chave: \n\n"));
                    objHeap.insere(objHeap, auxI);
                    System.out.println(objHeap.imprimeHeap(objHeap));
                    break;

                case 2:

                    auxI = objHeap.remove(objHeap);
                    JOptionPane.showMessageDialog(null,"Chave Removida: " + auxI);
                    System.out.println(objHeap.imprimeHeap(objHeap));

                break;

                case 3:

                    auxS = (JOptionPane.showInputDialog(null,"\nDigite o Valor da Chave: \n\n"));
                    vetorHeap = auxS.split(" ");
                    for (int i=0 ; i<vetorHeap.length ; i++){

                        auxI = Integer.parseInt(vetorHeap[i]);
                        objNaoHeap.insereDesordenado(objNaoHeap, auxI);
                    }

                    System.out.println(objNaoHeap.imprimeHeap(objNaoHeap));
                    break;

                case 4:

                    objNaoHeap.constroi_heap(objNaoHeap,1);
                    System.out.println(objNaoHeap.imprimeHeap(objNaoHeap));
                    break;

                default:

                    JOptionPane.showMessageDialog(null,"Numero Invalido !!","Erro", JOptionPane.ERROR_MESSAGE);
                    break;


            }
        }

    }

}
