
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
			head = aux;
		}
		cant++;
	}

	public void add(String dat){
//		Node auxi=new Node(dat, null);;
//		if(head == null){
//			head = new Node(dat, null);
//		}else{
//			auxi=head;
//			Node aux = new Node(dat, auxi);
//			//head = aux;
//		}
		//cant++;
		head=null;
		Node auxD;
		if(head != null){
			auxD= new Node(dat,null);
//			Node aux = new Node(auxD.data,null);
//			head = new Node(dat, auxD);
//			auxD.next = aux;
//			//head = aux;
		}else{
			auxD=null;
		}
		head = new Node(dat, auxD);
		cant++;
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
		//implementar
		int pos = 0;
		if(head != null){
			if(pos == index){
				head = head.next;
			}else{
				Node actual = this.head.next;
				Node anterior = this.head;

				while(actual != null && index!=pos){
					actual = actual.next;
					anterior = anterior.next;
					pos--;
					break;
				}

				if(actual != null){
					anterior.next = actual.next;
					pos--;
				}
				
			}
			
		}pos--;
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
