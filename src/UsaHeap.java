/**
 * Created by RafaelMq on 07/03/2016.
 */
public class UsaHeap {

    public static void main(String[] args){

        Heap objHeap = new Heap();
        NoHeap objNoHeap = new NoHeap();


        int vetorInsereHeap[] = {18,25,41,34,15,11,52,50,48};

        for(int i=0; i<vetorInsereHeap.length; i++) {
            objHeap.insere(objNoHeap, vetorInsereHeap[i]);
        }

        for(int i=0; i<vetorInsereHeap.length; i++) {
            System.out.print(" | "+objNoHeap.elemento[i]);
        }

    }

}
