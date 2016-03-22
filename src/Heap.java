import static java.lang.StrictMath.pow;

/**
 * Created by RafaelMq on 07/03/2016.
 */
public class Heap  {


    int n;
    int elemento[];

    Heap() {
        this.n = 0;
        elemento = new int[100];
    }

    public void insereDesordenado(Heap heap, int valor) {
        heap.n = heap.n + 1;
        heap.elemento[heap.n] = valor;
        //heap.n += 1;

        for(int i=0; i<heap.n+1; i++) { //+1 por caus da raiz
            System.out.print(" | "+heap.elemento[i]);

        }
        System.out.println("\n");
    }


    public void insere(Heap heap, int valor) {
        heap.n = heap.n + 1;
        heap.elemento[heap.n] = valor;
        //heap.n += 1;
        subir(heap, heap.n);

        for(int i=0; i<heap.n+1; i++) { //+1 por caus da raiz
            System.out.print(" | "+heap.elemento[i]);

        }
        System.out.println("\n");
    }

    public void subir (Heap heap, int posicao){
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

    public int remove(Heap heap){
        int aux=0;

        if(heap.n == 0){
            System.out.println("Impossivel Remover - Heap Vazio");
        }else{
            aux = heap.elemento[1];
            heap.elemento[1] = heap.elemento[heap.n];
            heap.n -= 1;
            descer(heap,1);
        }
        return aux;
    }

    public void descer(Heap heap, int posicao){
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

    public void constroi_heap(Heap heap, int posicao){
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

    String imprimeHeap( Heap heap) {
        StringBuffer saida = new StringBuffer();
        int i=1; // armazena a posição que estou imprimindo, começa no 1 pois o v[0] armazena a quantidade de elementos
        int aux; // armazena quantos elementos ja foram impressos em casa linha
        int j=0; // armazena a quantidade de linhas que ja foram impressas
        while(i<=heap.n){ //execulta até atingir a quantidade mazima de elementos
            for(int espaco = heap.n-i ; espaco>0 ; --espaco){//dar espaco
                saida.append("  ");
            }

            for(aux = 0; aux+1 <= (int)pow(2,j) && i <= heap.n; i++){//for para imprimir cada linha
                saida.append(heap.elemento[i] + "  ");//imprimo h[i]
                aux++;
            }
            saida.append("\n");//enter
            j++;
        }
        return saida.toString();
    }


}
