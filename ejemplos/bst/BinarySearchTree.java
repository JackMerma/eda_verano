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

	}

	Node root = null;

	//methods
	public void add(T dat){
		this.root = addRecursive(dat, root);
	}

	private Node addRecursive(T dat, Node node){
		if(node == null){
			return new Node(dat, null, null);
		}else{
			Node aux = node;
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
	public void inOrden(){
		System.out.print("InOrden:");
		inOrderRecursive(this.root);
	}

	private void inOrderRecursive(Node node){
		if(node != null){
			inOrderRecursive(node.left);
			System.out.print(node.data + " ");
			inOrderRecursive(node.right);
		}
	}

	public void preOrden(){
	}

	public void postOrden(){
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
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		int [] data = {9,2,5,7,1,35,7,88,9,3};

		for(int i=0;i<data.length;i++)
			bst.add(data[i]);

		bst.inOrden();
	}
}


