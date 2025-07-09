package Pilha;

public class Pilha{

    private int topo;
    private int[] pilha;
    private static final int CAPACIDADE_PADRAO = 10;

    public Pilha(int capacidade){
        this.pilha = new int[capacidade];
        this.topo = -1;

    }

    public Pilha(){
        this(CAPACIDADE_PADRAO);
    }


    public boolean isEmpty(){
        return topo == -1;
    }

    public boolean isFull(){
        return topo == pilha.length - 1;
    }

    public void push(int k){
        if(isFull()) throw new RuntimeException("pilha cheia");
        pilha[++topo] = k;
    }

    public int pop(){
        if(isEmpty()) throw new RuntimeException("pilha vazia"); 
        return pilha[--topo];
    }

    public int peek(){
        if(isEmpty()) throw new RuntimeException("pilha vazia");
        return pilha[topo];
    }


}
