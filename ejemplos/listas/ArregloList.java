/** 
* @author      : Jackson Fernando Merma Portocarrero (jmermap@unsa.edu.pe)
* @created     : 10/02/2022
* @filename    : ArregloList
* @description : _
*/

import java.util.*;

public class ArregloList<T>{

	private T[] list;
	private int total;

	public ArregloList(int n){
		//cast necesario
		this.list = (T[])new Object[n];
		total = n;
	}

	//principales metodos
	
	public boolean isEmpty(){
	}

	public void add(T dat, int index){
	}
	
	public int search(T dat){
	}

	public T get(int index){
	}

	public void delete(T dat){
	}

	public void delete(int index){
	}

	public void remove(){

	}

	public String toString(){
	}
}

