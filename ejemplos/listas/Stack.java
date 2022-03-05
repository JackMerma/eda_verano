/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 05/03/2022
 * @filename    : Stack
 */
class Stack {
	class Node{
		int dat;
		Node next;

		public Node(int dat, Node next){
			this.dat = dat;
			this.next = next;
		}
	}

	Node tope;

	public void push(int dat){
		if(tope == null){
			tope = new Node(dat, null);//nuevo nodo con null
		}else{
			tope = new Node(dat, tope);//nuevo nodo con el anterior tope
		}
	}

	public int pop(){
		if(tope != null){
			int data = this.tope.dat;//capturar el dato de tope
			tope = tope.next;//eliminar y cambiar el tope
			return data;
		}
		return -1;
	}

	public int top(){
		if(tope != null){
			return tope.dat;
		}
		return -1;
	}

	public boolean isEmpty(){
		return tope == null;
	}

	public String toString(){
		String out = "";

		Node aux = tope;

		while(aux != null){
			out += aux.dat + " - ";
			aux = aux.next;
		}

		return out;
	}
}


