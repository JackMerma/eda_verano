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
		cant++;
	}

	public void add(String dat){
		//implementar
	}
	
	public int search(String dat){
		int pos = 0;
		Node aux = head;

		while(aux != null){//(pos < cant)
			String cadena = aux.data;

			if(dat.compareTo(cadena) == 0)
				return pos;

			pos++;
			aux = aux.next;
		}

		return -1;
	}

	public String searchK(int index){
		//implementar
		return "";
	}

	//
	// 0 	 -> a = b
	// > 1 -> a > b
	// < 1 -> a < b
	public void delete(String dat){
		if(head != null){
			if(head.data.compareTo(dat) == 0){
				//inicio
				// abc -> null ---> null
				// abc -> dfg -> ... -> null
				head = head.next;
			}else{
				Node actual = this.head.next;
				Node anterior = this.head;

				while(actual != null && actual.data.compareTo(dat)!=0){
					actual = actual.next;
					anterior = anterior.next;
				}

				if(actual != null){
					anterior.next = actual.next;
				}
				
			}
		}
	}

	public void deleteK(int index){
		//implementar
	}

	public String toString(){
		String out = "";
		Node aux = head;

		while(aux != null){
			out += aux.data.toString()+" - ";
			aux = aux.next;
		}
		return out;
	}

}


