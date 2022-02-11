/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 06/02/2022
 * @filename    : Prueba
 */
class Prueba {
	public static void main(String [] args){
		System.out.println("------------------------------------------------------------------------------");

		//Prueba para un LinkedList
		System.out.println("-----------Lista enlazada------------");

		LinkedList lista = new LinkedList();
		String nombres[] = {"Pedro", "Juan", "Diego"};

		for(int i = 0;i < nombres.length; i++){
			lista.put(nombres[i]);
			System.out.println(lista);
		}

		//Busquedas
		int busq1 = lista.search("Pedro");
		int busq2 = lista.search("Jack");

		System.out.println(busq1);
		System.out.println(busq2);


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

	}
}


