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

	public String search (T dat){
		Node aux = this.root;

		while(aux != null){
			int value = dat.compareTo(aux.data);
			
			if(value == 0){
				return dat + " encontrado :)";
			}else if(value < 0){
				aux = aux.left;
			}else{
				aux = aux.right;
			}
		}

		return dat + " no encontrado :(";
	}

	public void delete(T dat){
		this.root = deleteRecursive(dat, this.root);
	}

	private Node deleteRecursive(T data, Node node){
		Node aux = node;
	
		if(node != null){
			int value = data.compareTo(node.data);
			if(value == 0){
				if(node.right == null && node.left == null){
					return null;
				}else{ // 1 hijo o mas
					T lastLeftSheet = getLastLeftSheet(node.right);
					node.right = deleteLastLeftSheet(node.right);

					if(lastLeftSheet == null){
						aux = node.left;
					}else{
						aux.data = lastLeftSheet;
					}
				}
			}else if(value < 0){
				aux.left = deleteRecursive(data, node.left);
			}else{
				aux.right = deleteRecursive(data, node.right);
			}
		}
		return aux;
	}

	private T getLastLeftSheet(Node node){
		if(node == null)
			return null;

		if(node.left == null){
			return node.data;
		}else{
			return getLastLeftSheet(node.left);
		}
	}

	private Node deleteLastLeftSheet(Node node){
		if(node == null || node.left == null)
			return null;

		node.left = deleteLastLeftSheet(node.left);
		return node;
	}

	//recorridos
	public void inOrden(){
		System.out.print("InOrden:");
		inOrderRecursive(this.root);
		System.out.println();
	}

	private void inOrderRecursive(Node node){
		if(node != null){
			inOrderRecursive(node.left);
			System.out.print(node.data + " ");
			inOrderRecursive(node.right);
		}
	}

	public void preOrden(){
		System.out.print("PreOrden:");
		preOrdenRecursive(this.root);
		System.out.println();
	}

	private void preOrdenRecursive(Node node){
		if(node != null){
			System.out.print(node.data + " ");
			preOrdenRecursive(node.left);
			preOrdenRecursive(node.right);
		}
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

		int [] data = {4,1,10,5,11};

		for(int i=0;i<data.length;i++)
			bst.add(data[i]);

		bst.inOrden();
		bst.preOrden();

		//System.out.println(bst.search(100000));
		//System.out.println(bst.search(7));
		//bst.delete(11);

		//bst.inOrden();
	}
}


