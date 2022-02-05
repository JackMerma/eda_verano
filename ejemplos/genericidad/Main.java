/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 05/02/2022
 * @filename    : Main
 */
class Main {
	public static void main(String [] args){
		Caja<Integer> ci = new Caja<Integer>();
		ci.put(15);
		System.out.println(ci.get()+5);
		System.out.println(ci.get().toString());


		Caja<String> cs = new Caja<String>();
		cs.put("hola ");
		System.out.println(cs.get()+"mundo");
	}
}


