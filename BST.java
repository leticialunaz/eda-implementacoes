public class BST {
    private Node root;

    public boolean isEmpty() {
    	return this.root == null;
    }

    public int altura() {
    	return altura(this.root);
    }

    private int altura(Node current) {
    	if (current == null) return -1;
	else return 1 + Math.max(altura(current.right), altura(current.left));
    }

    public Node minimo() {
    	return minimo(this.root);
    }

    private Node minimo(Node current){
    	if(current.left == null) return current;
	else return minimo(current.left);
    }


    public Node maximo() {
    	return maximo(this.root);
    }

    private Node maximo(Node current){
    	if(current.right == null) return current;
	else return maximo(current.right);
    }

    // adicao iterativa
    public void add(int value){
    	if(isEmpty()) this.root = new Node(value);
	else {
	    Node aux = this.root;

	    while(aux != null) {
	    	if(aux.value > value) {
		    if(aux.left == null){
		    	aux.left = new Node(value);
			aux.left.parent = aux;
			return;
		    }
		    aux = aux.left;
		} else {
		    if(aux.right == null){
		        aux.right = new Node(value);
			aux.right.parent = aux;
			return;
		    }
		    aux = aux.right;
		}
	    }
	
	}
    }



    // adicao recursiva
    public void addRecur(int value){
    	addRecur(value, this.root);
    }

    private void addRecur(int value, Node current){
    	if (current == null) this.root = new Node(value);
	else {
	    if(value > current.value) {
	    	if(node.right == null) {
		    node.right = new Node(value);
		    node.right.parent = current;
		    return;
		}
		addRecur(value, current.right);
	    } else {
	    	if(node.left == null) {
		    node.left = new Node(value);
		    node.left.parent = current;
		    return;
		}
		addRecur(value, current.left);
	    
	    
	    }
	}
    }


    public Node search(int k){
    	return search(k, this.root);
    }

    private Node search(int k, Node current){
    	if(current.value == k) return current;
	else if(current.value > k) return search(k, current.left);
	else if(current.value < k) return search(k, current.right);
	else return null;
    }


    public Node sucessor(Node current){
	if(current == null) return null;

	if(current.right != null) return min(current.right);
	else {
	    Node aux = current.parent;

	    while(aux != null && current.value > aux.value)
		aux = aux.parent;
	    return aux;
	}
    }


    public void remove(int value){
    	Node toRemove = search(value);
	if(toRemove != null) remove(toRemove);
    }



    private void remove(Node toRemove){
	if(toRemove.isLeaf()){
	    if(toRemove == this.root) this.root = null;
	    else{
	    	if(toRemove.value > toRemove.parent.value){
		    toRemove.parent.right = null;
		} else {
		    toRemove.parent.left = null;
		}
	    }
	} else if(toRemove.hasOnlyRightChild()){
	    if(toRemove == this.root){
	    	this.root = toRemove.right;
		this.root.parent = null;
	    } else {
	    	if(toRemove.right.value > toRemove.parent.value){
		    toRemove.parent.right = toRemove.right;
		} else{
		    toRemove.parent.left = toRemove.right;
		}
		toRemove.right.parent = toRemove.parent;
	    }
	} else if(toRemove.hasOnlyLeftChild()){
	    if(toRemove == this.root){
	    	this.root = toRemove.left;
		this.root.parent = null;
	    } else {
	        if(toRemove.left.value > toRemove.parent.value){
		    toRemove.parent.right = toRemove.left;		   
		} else {
		    toRemove.parent.left = toRemove.left;
		}
		toRemove.left.parent = toRemove.parent;
	    }
	}

    	else{
	    Node sucessor = sucessor(toRemove);
	    toRemove.value = sucessor.value;
	    remove(sucessor);
	}
    }

    public void preOrdem(){
    	preOrdem(this.root);
    }

    private void preOrdem(Node node){
    	if(node != null){
	    System.out.println(node.value);
	    preOrdem(node.left);
	    preOrdem(node.right);
	}
    }
    
    public void emOrdem(){
    	emOrdem(this.root);
    }

    private void emOrdem(Node node){
    	if(node != null){
	    preOrdem(node.left);
	    System.out.println(node.value);
	    preOrdem(node.right);
	}
    }
    
    public void posOrdem(){
    	posOrdem(this.root);
    }

    private void posOrdem(Node node){
    	if(node != null){
	    preOrdem(node.left);
	    preOrdem(node.right);
	    System.out.println(node.value);
	}
    }


    public boolean equals(BST other){
    	return other.preOrdem() == this.preOrdem();
    }
}



















class Node {
    int value;
    Node left;
    Node right;
    Node parent;


    public Node(int v) {
    	this.value = v;
    }


    public boolean isLeaf() {
    	return this.left == null && this.right == null;
    }

    public boolean hasTwochilds() {
    	return this.left != null && this.right != null;
    }

    public boolean hasOnlyLeftchild() {
    	return this.left != null && this.right == null;
    }

    public boolean hasOnlyRightchild() {
    	return this.left == null && this.right != null;
    }
}
