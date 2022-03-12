
public class LinkedList {
	class Node{
		String data;
		Node next;
		Node nextn;

		public Node(String dat, Node next){
			this.data = dat;
			this.next = next;
		}
		
		public Node(String dat, Node next,Node nextn){
			this.data = dat;
			this.next = next;
			this.nextn = nextn;
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
			this.head = aux;
		}
		cant++;
	}

	public void add(String dat){
		if(this.head == null){
			this.head = new Node(dat, null);
		}else{
			Node aux = this.head;

			while(aux.next != null)
				aux = aux.next;

			aux.next = new Node(dat, null);
		}
		this.cant ++;
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

	public String searchK(int index){//funciona
		//implementar 
		int pos = 0;
		Node aux = head;

		while(aux != null){//(pos < cant)
			String cadena = aux.data;

			if(pos == index)
				return cadena;

			pos++;
			aux = aux.next;
		}

		return "no encontrado";
	}

	//
	// 0 	 -> a = b
	// > 1 -> a > b
	// < 1 -> a < b
	public void delete(String dat){
		if(head != null){
			if(head.data.compareTo(dat) == 0){
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

		if(index < 0 || index > cant-1)
			return ;

		//implementar
		if(head != null){
			if(index == 0){
				head = head.next;
			}else{
				Node actual = this.head.next;
				Node anterior = this.head;

				int pos = 1;
				
				while(actual != null && pos<index){
					actual = actual.next;
					anterior = anterior.next;
					pos++;
				}

				anterior.next = actual.next;
				cant--;
			}
		}
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
