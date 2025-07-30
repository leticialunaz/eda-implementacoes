import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(int valor) {
        Node novoNode = new Node(valor);

        if(isEmpty()){
            this.head = novoNode;
            this.tail = novoNode;
        } else {
            novoNode.next = head;
            this.head.prev = novoNode;
            this.head = novoNode;
        }
        this.size++;
    }

    public void addLast(int valor) {
        Node novoNode = new Node(valor);

        if(isEmpty()){
            this.head = novoNode;
            this.tail = novoNode;
        } else {
            this.tail.next = novoNode;
            novoNode.prev = tail;
            this.tail = novoNode;
        }
        this.size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {    
        if(index < 0 || index >= size)
           throw new IndexOutOfBoundsException();

        if(index == 0) 
            this.addFirst(valor);
    
        else{
            Node novoNode = new Node(valor);
            
            Node aux = head;

            for(int i = 0; i < index - 1; i++)
                aux = aux.next;

            novoNode.next = aux.next;
            aux.next = novoNode;
            novoNode.prev = aux;
            novoNode.next.prev = novoNode;

            size++;
        }
    }

    public int getFirst() {
        return head.value;
    }

    public int getLast() {
        return tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node aux = head;
        for(int i = 0; i < index; i++)
            aux = aux.next;

         return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty())
            throw new RuntimeException("linkedlist vazio");
        Node aux = head;

        if(size == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.head = head.next;
            head.prev = null;
        }

        size--;
        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if(isEmpty())
            throw new RuntimeException("linkedlist vazio");
        Node aux = tail;
        if(size == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            tail.next = null;
        }

        size--;
        return aux.value;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if(index == 0)
           return removeFirst();

        int valorRemovido = 0;
        Node aux = this.head;
        for(int i = 0; i < index; i++){
            aux = aux.next;
        }
        valorRemovido = aux.value;
        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;
        size--;

        return valorRemovido;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) { 
        Node aux = this.head;
        int index = 0;
        int num = 0;

        while(aux != null){
            if(aux.value == value){
                remove(index);
                return true;
            }
            aux = aux.next;
            index++;

        }

        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        int index = 0;
        
        while(aux != null){
            if(aux.value == value)
                return index;
            aux = aux.next;
            index++;
        }
        return -1;
    }

    public boolean contain(int v) {
        Node aux = this.head;

        while(aux != null){
            if(aux.value == v)
                return true;
            aux = aux.next;
        }

        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.head;
        int lastIndex = -1;
        int index = 0;

        while (aux != null){
            if(aux.value == valor){
               lastIndex = index;
            }
            aux = aux.next;
            index++;
        }
        return lastIndex;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return size;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
        this.prev = null;
        this.next = null;
    }

}
