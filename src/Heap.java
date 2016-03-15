/**
 * Created by RafaelMq on 07/03/2016.
 */
public class Heap {





    public void insere(NoHeap heap, int valor) {
        heap.n = heap.n + 1;
        heap.elemento[heap.n] = valor;
        //heap.n += 1;
        subir(heap, heap.n);

    }

    public void subir (NoHeap heap, int posicao){
        if(posicao > 1){
            int pai;
            pai = posicao/2;
            if(heap.elemento[posicao] > heap.elemento[pai]){
                int aux;
                aux = heap.elemento[posicao];
                heap.elemento[posicao] = heap.elemento[pai];
                heap.elemento[pai] = aux;
                subir(heap,pai);
            }
        }
    }

    public void remove(NoHeap heap){
        if(heap.n == 0){
            System.out.println("Impossivel Remover - Heap Vazio");
        }else{
            int aux;
            aux = heap.elemento[1];
            heap.elemento[1] = heap.elemento[heap.n];
            heap.n -= 1;
            descer(heap,1);
        }
        // retornar chave removida
    }

    public void descer(NoHeap heap, int posicao){
        int filho;
        filho = 2*posicao;

        if(filho <= heap.n){

            if(filho < heap.n && heap.elemento[filho] < heap.elemento[filho+1]){
                filho += 1;
            }

            if(heap.elemento[posicao] <  heap.elemento[filho]){
                int aux;
                aux = heap.elemento[posicao];
                heap.elemento[posicao] = heap.elemento[filho];
                heap.elemento[filho] = aux;
                descer(heap,filho);
            }

        }

    }

    public void constroi_heap(NoHeap heap, int posicao){
        int filho;
        filho = 2*posicao;
        if(filho <= heap.n ){
            constroi_heap(heap,filho);
            if(filho+1 <= heap.n){
                constroi_heap(heap,filho+1);
            }

        }
        descer(heap, posicao);
    }

    public void mostraHeap(){

    }

}
