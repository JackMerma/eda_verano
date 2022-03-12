/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 12/03/2022
 * @filename    : Queue
 */
class Queue {
	class Node{
		int dat;
		Node next;

		public Node(int dat, Node next){
			this.dat = dat;
			this.next = next;
		}
	}

	Node first, last;

	public void enqueue(int data){
		if(isEmpty()){
			//this.first = this.last = new Node(data, null);

			Node x = new Node(data, null);
			this.first = x;
			this.last = x;
		}else{
			this.last.next = new Node(data, null);//ingreso al final
			this.last = this.last.next;//nueva direccion
		}
	}

	public int dequeue(){
		if(!isEmpty()){
			int data = this.first.dat;//almacenando dato
			
			if(this.first == this.last){//solo 1 dato
				this.first = this.last = null;
			}else{//mas de un dato
				this.first = this.first.next;	
			}
			return data;
		}
		return -1;
	}

	public boolean isEmpty(){
		return this.first == null;
	}

	public int back(){
		return (this.last != null)? this.last.dat: -1;
	}

	public int front(){
		return (this.first != null)? this.first.dat: -1;
	}

	public String toString(){
		Node aux = this.first;
		String out = "";

		while(aux != null){
			out += aux.dat + " - ";
			aux = aux.next; 
		}

		return out;
	}

	public static void main(String[]args){
		System.out.println("-------------------Salida---------------------");

		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(queue);

		System.out.println("eliminado " + queue.dequeue());
		System.out.println("eliminado " + queue.dequeue());


		System.out.println("Primero " + queue.front());
		System.out.println("Ultimo " + queue.back());


		System.out.println(queue);
	}
}


