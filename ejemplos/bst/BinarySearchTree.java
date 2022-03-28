/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 26/03/2022
 * @filename    : BinarySearchTree
 */
public class BinarySearchTree <T extends Comparable<T>>{

	/* Clase Node
	 */
	class Node{
		T data;//dato a almacenar
		Node right;//hijo derecho
		Node left;//hijo izquierdo

		public Node(T dat, Node r, Node l){
			data = dat;
			right = r;
			left = l;
		}
	}

	Node root = null;//raiz principal

	//methods
	
	/*
	 * Metodo add
	 * 	Agrega un elemento al BST
	 */
	public void add(T dat){
		//forma indirecta de guardar un dato (retorna un nodo)
		this.root = addRecursive(dat, root);
	}

	/*
	 * Metodo addRecursive
	 * 	Agrega recursivamente un dato con la informacion de un nodo
	 */ 
	private Node addRecursive(T dat, Node node){
		if(node == null){//si llego al final (hoja)
			return new Node(dat, null, null);//crea un nuevo nodo
		}else{//si no llego al final
			Node aux = node;
			if(dat.compareTo(node.data) > 0){//si el dato a ingresar es mayor que el nodo actual
				aux.right = addRecursive(dat,node.right);//viaja por la derecha
			}else{
				aux.left = addRecursive(dat, node.left);//viaja por la izquierda
			}
			return aux;
		}
	}

	/*
	 * Metodo search
	 * 	Busca un dato en la estructura
	 */
	public String search (T dat){
		Node aux = this.root;

		while(aux != null){//siempre que no llegue a una hoja (no encontrado)
			int value = dat.compareTo(aux.data);//valor de comparacion
			
			if(value == 0){
				return dat + " encontrado :)";
			}else if(value < 0){//esta por la izquierda
				aux = aux.left;
			}else{//esta por la derecha
				aux = aux.right;
			}
		}

		return dat + " no encontrado :(";
	}

	/*
	 * Metodo delete
	 * 	Elimina un dato de la estructura
	 */
	public void delete(T dat){
		this.root = deleteRecursive(dat, this.root);//eliminacion indirecta (retorna nuevo nodo)
	}

	/*
	 * Metodo deleteRecursive
	 * 	Eliminacion recursiva indirectamente
	 */
	private Node deleteRecursive(T data, Node node){
		Node aux = node;
	
		if(node != null){
			int value = data.compareTo(node.data);//valor de comparacion

			if(value == 0){//Encontro al valor a eliminar
				if(node.right == null && node.left == null){//si el nodo no tiene ningun hijo
					return null;//eliminacion indirecta
				}else{ // 1 hijo o mas

					//para reemplazar este padre, se debe devolver el dato mas a la izquierda del subarbol derecho
					//tambien puede ser con el dato mas a la derecha del subarbol izquierdo
					//en general, es un tema de implementacion
					T lastLeftSheet = getLastLeftSheet(node.right);//retorna el dato mas a la izquierda de node.right
					
					//ademas, se debe de eliminar a este dato almacenado
					node.right = deleteLastLeftSheet(node.right);//eliminacion indirecta de este dato

					if(lastLeftSheet == null){//si solo tenia al hijo izquierdo
						aux = node.left;//se reemplaza el arbol con este hijo izquierdo
					}else{//si tenia el arbol derecho o ambos
						aux.data = lastLeftSheet;//solo se cambia el dato con el buscado anteriormente
					}
				}
			}else if(value < 0){//si aun no se encuentra (esta por la izquierda)
				aux.left = deleteRecursive(data, node.left);//se elimina por la izquierda de forma indirecta
			}else{//si aun no se encuentra (esta por laderecha)
				aux.right = deleteRecursive(data, node.right);//se elimina por la derecha de forma indirecta
			}
		}
		return aux;
	}

	/*
	 * Metodo getLastLeftSheet
	 * 	Metodo para encontrar al dato mas a la izquierda de un subarbol
	 * 	de forma recursiva
	 */
	private T getLastLeftSheet(Node node){
		if(node == null)//No existe dicho dato
			return null;

		if(node.left == null){//Se encuentra este dato (node.left se adelanta al os hechos)
			return node.data;//se retorna el dato
		}else{
			return getLastLeftSheet(node.left);//Si no se encuentra, se sigue buscando solo por la izquierda
		}
	}

	/*
	 * Metodo deleteLastLeftSheet
	 * 	Elimina al dato mas a la izquierda de un nodo de ofrma recursiva
	 */
	private Node deleteLastLeftSheet(Node node){
		if(node == null)//Si no existe dicho dato
			return null;
		if(node.left == null){//si se encontro (se adelanta a los hechos)
			return node.right;//retorna el nodo derecho (esto evitará que se pierda parte del arbol)
		}

		node.left = deleteLastLeftSheet(node.left);//si no es encuentra, se sigue buscando por la izquierda
		return node;
	}

	/*
	 * Recorridos basicos (In Orden, Post Orden, Pre Orden)
	 */

	/*
	 * Metodo inOrden
	 * 	Imprime el recorrido en orden de la raiz
	 */
	public void inOrden(){
		System.out.print("InOrden:");
		inOrderRecursive(this.root);//llama a la forma recursiva
		System.out.println();
	}

	/*
	 * Metodo inOderRecursive
	 * 	Imprime el recorrido en orden de un nodo de forma recursiva
	 */
	private void inOrderRecursive(Node node){
		if(node != null){//siempre que exista el nodo
			inOrderRecursive(node.left);//si tiene hijo izquierdo
			System.out.print(node.data + " ");//imprime el nodo actual
			inOrderRecursive(node.right);//si tiene hijo derecho
		}
	}

	/*
	 * Metodo preOrden
	 * 	Imprime el recorrido en pre orden de la raiz
	 */
	public void preOrden(){
		System.out.print("PreOrden:");
		preOrdenRecursive(this.root);//llama a la recursividad
		System.out.println();
	}

	/*
	 * Metodo preOrdenRecursive
	 * 	Imprime el recorrido en pre orden de un nodo de forma recursiva
	 */
	private void preOrdenRecursive(Node node){
		if(node != null){
			System.out.print(node.data + " ");//primero imprime al nodo actual
			preOrdenRecursive(node.left);//si tiene hijo izquierdo
			preOrdenRecursive(node.right);//si tiene hijo derecho
		}
	}

	/*
	 * Metodo postOrden
	 * 	Imprime el recorrido en post orden de la raiz
	 */
	public void postOrden(){
		System.out.print("PostOrden:");
		postOrdenRecursive(this.root);//llama a la recursividad
		System.out.println();
	}

	/*
	 * Metodo portOrdenRecursive
	 * 	Imprime el recorrido en post orden de un nodo de forma recursiva
	 */
	private void postOrdenRecursive(Node node){
		if(node != null){
			postOrdenRecursive(node.left);//si tiene hijo izquierdo
			postOrdenRecursive(node.right);//si tiene hijo derecho
			System.out.print(node.data + " ");//imprime al nodo actual
		}
	}

	/*
	 * Algunos retos (sacados del lab de eda)
	 */

	/*
	 * Metodo searchLessThan (reto 1)
	 * 	Imprime los datos de forma ordenada, menores que uno enviado
	 */
	public void searchLessThan(T dat){
		System.out.print("Menores que " + dat + ":");
		searchLessThanRecursive(dat, this.root);//llama a la recursividad
		System.out.println();
	}

	/*
	 * Metodo searchLessThanRecursive
	 * 	Busca a los datos menores que uno enviado de forma recursiva y ordenada
	 */
	private void searchLessThanRecursive(T dat, Node node){
		if(node != null){
			searchLessThanRecursive(dat, node.left);//primero busca (en todos los casos)

			if(dat.compareTo(node.data) > 0){//si el dato actual es menor que el dado
				System.out.print(node.data + " ");//imprime al dato
				searchLessThanRecursive(dat, node.right);//busca por la derecha
			}
		}
	}

	/*
	 * Metodo searchGreaterThan (reto 2)
	 * 	Imprime los datos de forma ordenada, mayores que uno enviado
	 */
	public void searchGreaterThan(T dat){
		System.out.print("Mayores que " + dat + ":");
		searchGreaterThanRecursive(dat, this.root);//llama a la recursividad
		System.out.println();
	}

	/*
	 * Metodo searchGreaterThanRecursive
	 * 	Busca a los datos mayores que uno enviado de forma recursiva y ordenada
	 */
	private void searchGreaterThanRecursive(T dat, Node node){
		if(node != null){
			if(dat.compareTo(node.data) < 0){//si el actual es mayor que el dado
				searchGreaterThanRecursive(dat, node.left);//se busca por la izquierda
				System.out.print(node.data + " ");//se imprime el dato
			}
			searchGreaterThanRecursive(dat, node.right);//en todos los casos, se busca por la derecha
		}
	}

	/*
	 * Metodo searchAtPosition (reto 3) 
	 * 	Busca un elemento en el arbol, mediante una posicion dada(k)
	 */
	public T searchAtPosition(int k){
		return searchAtPositionRecursive(k, this.root);//llama a la recursividad
	}

	/*
	 * Metodo searchAtPositionRecursive
	 * 	Busca recusivamente a un elemento, mediante una posicion y un nodo
	 */
	private T searchAtPositionRecursive(int k, Node node){
		if(node == null){//si llega a una hoja, no existe
			System.out.println("No existe >:v");
			return null;
		}

		//para determinar en que posicion esta el nodo actual dentro del arbol,
		//se debe contrar cuantos nodos hay a su izquierda + 1
		//por ejemplo, si se tienen 4 nodos a la izquierda, entonces el actual
		//esta en la quinta posicion.
		int count = countLeftSubarbol(node.left) + 1;// conteo de nodos a la izquierda del actual + 1

		 if(count == k){//si coincide con el buscado, entonces se encontro el dato
			 return node.data;
		 }else if(count < k){//si se esta en una posicion menor a la requerida, se debe buscar por la derecha
			 //al buscar por la derecha, se busca una nueva posicion (k - count)
			return searchAtPositionRecursive(k - count, node.right);
		 }else{//si esta en una posicion superior, entonces de debe buscar por la izquierda del arbol
			return searchAtPositionRecursive(k, node.left);
		 }
	}

	/*
	 * Metodo countLeftSubarbol
	 * 	Retorna el conteo de nodos que hay en un arbol
	 */
	private int countLeftSubarbol(Node node){
		if(node != null){//si no esta en una hoja
			return 1 + countLeftSubarbol(node.left) + countLeftSubarbol(node.right);//cuenta el actual (1) y los de la derecha e izquierda
		}else{//si esta en una hoja
			return 0;
		}
	}

	public static void main(String [] args){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		int [] data = {1,10,-1,2,7,20,6,8};
		/*
		 * 	  1
		 * 	/  \
		 *   /    \
		 * -1 	  10
		 *       /   \
		 *      /     \
		 *  	 2      20
		 *  	  \
		 *  	   \
		 *  	  	 7
		 *       / \
		 *      /   \
		 *  	 6     8
		 */

		for(int i=0;i<data.length;i++)
			bst.add(data[i]);

		bst.inOrden();
		bst.preOrden();
		bst.postOrden();

		System.out.println("En posicion 5:" + bst.searchAtPosition(5));
		System.out.println("En posicion 7:" + bst.searchAtPosition(7));

		bst.searchLessThan(2);
		bst.searchGreaterThan(10);

		System.out.println(bst.search(404));
		System.out.println(bst.search(7));

		bst.delete(7);
		bst.inOrden();
	}
}


