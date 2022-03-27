/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 26/03/2022
 * @filename    : BinarySearchTree
 */
public class BinarySearchTree <T extends Comparable<T>>{

	class Node{
		T data;
		Node right;
		Node left;

		public Node(T dat, Node r, Node l){
			data = dat;
			right = r;
			left = l;
		}

		public Node(){
			this(null, null, null);
		}
	}

	Node root = null;

	//methods
	public void add(T dat){
		if(root == null){
			this.root = new Node(dat, null, null);
		}else{
			this.root = addRecursive(dat, root);
		}
	}

	private Node addRecursive(T dat, Node node){
		if(node == null){
			return new Node(dat, null, null);
		}else{
			Node aux = new Node();
			if(dat.compareTo(node.data) > 0){
				aux.right = addRecursive(dat,node.right);
			}else{
				aux.left = addRecursive(dat, node.left);
			}
			return aux;
		}
	}

	public T search (T dat){
		return null;
	}

	public void delete(T dat){

	}

	//recorridos
	public String inOrden(){
		return null;
	}

	public String preOrden(){
		return null;
	}

	public String postOrden(){
		return null;
	}

	//retos
	public String searchLessThan(T dat){
		return null;
	}

	public String searchGreaterThan(T dat){
		return null;
	}

	public T searchAtPosition(int k){
		return null;
	}

	public static void main(String [] args){
		//code
	}
}


