/** 
* @author      : Jackson Fernando Merma Portocarrero (jmermap@unsa.edu.pe)
* @created     : 10/02/2022
* @filename    : ArregloList
* @description : _
*/

import java.util.*;

public class ArregloList<T extends Comparable<T>>{

	private T[] list; // arreglo estándar a usar
	private int total; // total de datos 
	private int added = 0; // añadidos

	/**
	 * Constructor ArregloList
	 * 	Es necesario indicar la cantidad de datos
	 */
	public ArregloList(int n){
		//cast necesario para poder comparar datos (en vez de Object)
		this.list = (T[])new Comparable[n];
		this.total = n;
	}

	//principales metodos
	
	/**
	 * Metodo isEmpty
	 * 	Indica si la estructura esta vacia
	 * 	Complejidad : O(1) 
	 */
	public boolean isEmpty(){
		return this.added == 0;
	}

	/**
	 * Metodo add
	 * 	Añade un dato generico en la posicion indicada
	 * 	Complejidad : O(1) 
	 */
	public void add(T dat, int index){
		if(index < 0 || index >= total){
			System.out.println("Out of range");
			return ;
		}
		if(this.list[index] ==  null)
			added++;
		this.list[index] = dat;
	}
	
	/**
	 * Metodo search
	 * 	Busca un elemento mediante un dato generico enviado
	 * 	Complejidad : O(n) 
	 */
	public int search(T dat){
		for(int i = 0; i < this.total; i++)
			if(list[i] != null && this.list[i].compareTo(dat) == 0)
				return i;
		return -1;
	}

	/**
	 * Metodo get
	 * 	retorna un dato en la posicion indicada
	 * 	Complejidad : O(1) 
	 */ 

	public T get(int index){
		if(index < 0 || index >= total){
			System.out.println("Out of range");
			return null;
		}
		return this.list[index];
	}

	/**
	 * Metodo delete
	 * 	Elimina un dato enviado
	 * 	Complejidad : O(n) 
	 */
	public void delete(T dat){
		int index = this.search(dat);

		if(index != -1){ //ya es diferente de null
			this.list[index] = null;
			this.added--;
		}
	}

	/**
	 * Metodo delete
	 * 	Elimina un dato mediante una posicion
	 * 	Complejidad : O(1) 
	 */
	public void delete(int index){
		if(index < 0 || index >= total){
			System.out.println("Out of range");
			return ;
		}
		if(this.list[index] != null){
			this.list[index] = null;
			this.added--;
		}
	}

	/**
	 * Metodo remove
	 * 	Elimina los datos de la estructura
	 * 	Complejidad : O(1) 
	 */
	public void remove(){
		this.list = (T[])new Comparable[total];
		this.added = 0;
	}

	/**
	 * Metodo toString
	 * 	Devuelve informacion de la estructura
	 * 	Complejidad : O(n) 
	 */
	public String toString(){
		String out = "";
		if(!this.isEmpty()){
			for(int i = 0;i < this.total - 1; i++){
				out += this.list[i] + " - ";
			}
			out += this.list[this.total-1];
		}
		return out;
	}
}

