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
		this.list = (T[])new Comparable[n];
		this.total = n;
	}

	//principales metodos
	
	public boolean isEmpty(){
		return this.added == 0;
	}

	public void add(T dat, int index){
		if(index < 0 || index >= total){
			System.out.println("Out of range");
			return ;
		}
		if(this.list[index] ==  null)
			added++;
		this.list[index] = dat;
	}
	
	public int search(T dat){
		for(int i = 0; i < this.total; i++)
			if(list[i] != null && this.list[i].compareTo(dat) == 0)
				return i;
		return -1;
	}

	public T get(int index){
		if(index < 0 || index >= total){
			System.out.println("Out of range");
			return null;
		}
		return this.list[index];
	}

	public void delete(T dat){
		int index = this.search(dat);

		if(index != -1){ //ya es diferente de null
			this.list[index] = null;
			this.added--;
		}
	}

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

	public void remove(){
		this.list = (T[])new Comparable[total];
		this.added = 0;
	}

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

