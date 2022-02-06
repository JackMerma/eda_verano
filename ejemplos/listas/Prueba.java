/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 06/02/2022
 * @filename    : Prueba
 */
class Prueba {
	public static void main(String [] args){
		System.out.println("------------------------------------------------------------------------------");

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

	}
}


