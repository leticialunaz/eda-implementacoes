public class Heap {

    private int tail;
    private int[] heap;

    public Heap(int tamanho){
        this.heap = new int[tamanho];
        this.tail = -1;
    }

    public boolean isEmpty(){
        return this.tail = -1;
    }

    public int left(int indice){
        return 2*indice + 1;
    }

    public int right(int indice){
        return 2 * indice + 2;
    }

    public int parent(int indice){
        return int((indice - 2)/2);
    }

}