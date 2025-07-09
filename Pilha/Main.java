package Pilha;

import Pilha.Pilha;

public class Main {

    public static void main(String[] args){
        Pilha pilha = new Pilha(5);
        
        pilha.push(48);
        pilha.push(36);
        pilha.push(21);
        pilha.push(12);
        pilha.push(30);
        //pilha.push(2);
        //
        System.out.println(pilha.pop());
    }
}
