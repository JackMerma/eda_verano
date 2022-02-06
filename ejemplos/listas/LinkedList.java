/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 06/02/2022
 * @filename    : LinkedList
 */
class LinkedList {
	class Node{
		String data;
		Node next;

		public Node(String dat, Node next){
			this.data = dat;
			this.next = next;
		}
	}

	public Node head = null;
	public int cant = 0;

	public boolean isEmpty(){
		return cant == 0;
	}

	public void put(String dat){
		if(head == null){
			head = new Node(dat, null);
		}else{
			Node aux = new Node(dat, head);
			head = aux;
		}
	}

	public void add(String dat, int index){
		//implementar
	}
	
	public String search(String dat){
		return "";
	}

	public String searchK(int index){
		//implementar
		return "";
	}

	public void delete(String dat){
	
	}

	public String toString(){
		String out = "";
		Node aux = head;
		
		while(aux != null){
			out += aux.toString()+" - ";
			aux = aux.next;
		}
		return out;
	}

}


