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

	public void delete(String dat){
		if(head != null){
			if(head.data.compareTo(dat) == 0){
				head = head.next;
			}else{
				Node anterior = head;

				while(anterior.next != null){
					if(anterior.next.data.compareTo(dat) == 0)
						break;
					anterior = anterior.next;
				}
				
				if(anterior.next != null){
					anterior.next = anterior.next.next;
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


