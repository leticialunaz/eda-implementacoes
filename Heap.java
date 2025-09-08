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
        return int((indice - 1)/2);
    }

    public void add(int elemento){
    	this.heap[++tail] = elemento;
	
	int cont = tail;
	while(cont > 0 && this.heap[cont] > this.heap[parent(cont)]){
	    swap(cont, parent(cont));
	    cont = parent(cont);
	}
    }


    public int remove(){
    	int element = this.heap[0];
	swap(0, tail);
	this.tail--;

	heapify(0);

	return element;
    }


    public void heapify(int index){
    	if(isLeaf(index) || !isValidIndex(index))
	    return;

	int maxIndex = maxIndex(index, right(index), left(index));

	if(maxIndex != index){
	    swap(maxIndex, index);
	    heapify(maxIndex);
	}
    }


    public void buildHeap(){
	for(int i = parent(tail); i >= 0; i--){
	    heapify(i)	;
	}
    }


    public int maxIndex(int index, int right, int left){
		int max = index;

		if(heap[right(index)] > heap[max])
			max = right;
		if(heap[left(index)] > heap[max])
			max = left;

    // 	if(isValidIndex(left) && this.heap[index] > this.heap[left]){
	//     if(isValidIndex(right) && this.heap[index] > this.heap[right])
	//     	return index;
	//     else if(isValidIndex(right) && this.heap[index] < this.heap[right])
	// 	return right;
	//     else
	// 	return index;

	// } else if(isValidIndex(left) && this.heap[index] < this.heap[left]){
	//     if(isValidIndex(right) && this.heap[index] > this.heap[right])
	// 	return left;
	//     else if(isValidIndex(right) && this.heap[left] < this.heap[right])
	// 	return right;
	// }   else
	// 	return left;
		return max;		
    }


    public boolean isValidIndex(int i){
    	return (i >= 0 && i <= tail);
    }

    public boolean isLeaf(int index){
    	return (index > parent(tail) && index <= tail);
    }



    public void swap(int i, int j){
    	int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;
    }
}
