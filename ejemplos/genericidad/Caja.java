/**
 * @author      : Jack
 * @created     : 05/02/2022
 * @filename    : Caja
 */
class Caja <T>{
	private T elemento;
	public Caja(){
		super();
	}
	public T get(){
		return this.elemento;
	}
	public void put(T ele){
		this.elemento = ele;
	}

	public static <L> void ponEnCaja(L dato, Caja<L> caja){
		caja.put(dato);
	}
}


