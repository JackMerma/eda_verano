/** 
* @author      : Jackson Fernando Merma Portocarrero (jmermap@unsa.edu.pe)
* @created     : 10/02/2022
* @filename    : ArregloList
* @description : _
*/

import java.util.*;

public class ArregloList<T extends Comparable<T>>{

	private T[] list;
	private int total;
	private int added = 0;

	public ArregloList(int n){
		//cast necesario
		this.list = (T[])new Object[n];
		total = n;
	}

	//principales metodos
	
	public boolean isEmpty(){
		return added == 0;
	}

	public void add(T dat, int index){
		list[index] = dat;
	}
	
	public int search(T dat){
		for(int i = 0; i < this.total; i++)
			if(list[i] != null && this.list[i].compareTo(dat) == 0)
				return i;
		return -1;
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

