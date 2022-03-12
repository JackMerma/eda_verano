
public class Prueba {
	public static void main(String [] args){
		System.out.println("------------------------------------------------------------------------------");

		//Prueba para un LinkedList
		System.out.println("-----------Lista enlazada------------");

		LinkedList lista = new LinkedList();
		String nombres[] = {"Pedro", "Juan", "Diego"};
		
		LinkedList lista2 = new LinkedList();
		
		for(int i = 0;i < nombres.length; i++){
			lista.put(nombres[i]);
			System.out.println(lista);
		}
		System.out.println("barbara:");
		for(int i = 0;i < nombres.length; i++){
			lista2.add(nombres[i]);
			System.out.println(lista2);
		}System.out.println("asi queda"+lista2);
		
        System.out.println("fin barbara");
		//Busquedas
		int busq1 = lista.search("Pedro");
		int busq2 = lista.search("Jack");
		String b1 = lista.searchK(2);
 
		System.out.println(busq1);
		System.out.println(busq2);
		System.out.println(" funciona");
        System.out.println(b1);
        
        System.out.println("borradno");
        lista.deleteK(0);
        for(int i = 0;i < nombres.length; i++){
			lista.put(nombres[i]);
			System.out.println(lista);
		}
        System.out.println("fin");

		//Eliminacion
		lista.delete("Pedro");
		System.out.println(lista);





		//Prueba para un ArregloList - Generico
		System.out.println("-----------Lista en base a arreglo------------");

		ArregloList<String> names = new ArregloList<String>(10);

		//add
		names.add("Majo", 0);
		names.add("Zoe", 1);
		names.add("Chloe", 2);
		names.add("Madiley", 3);

		System.out.println(names);
		System.out.println(names.isEmpty());

		//search
		System.out.println("Auron in index : " + names.search("Auron"));
		System.out.println("Chloe in index : " + names.search("Chloe"));

		//get
		System.out.println(names.get(1000));
		System.out.println(names.get(3));
		System.out.println(names.get(9));

		//delete
		names.delete("Madiley");
		names.delete("Barbara");
		names.delete(1); //Zoe
		System.out.println(names);

		//remove
		names.remove();
		System.out.println(names.isEmpty());


//		//Prueba para un Stack
//		System.out.println("-----------Stack------------");
//		Stack stack = new Stack();
//
//		stack.push(5);
//		stack.push(4);
//		stack.push(3);
//		stack.push(2);
//		stack.push(1);
//
//		System.out.println(stack);
//		System.out.println("ultimo dato " + stack.top());
//
//		int suma = 0;
//
//		while(!stack.isEmpty()){
//			System.out.println("Sumando el "+stack.top());
//			suma += stack.pop();
//		}
//
//		System.out.println("Suma: " + suma);
	}
}
