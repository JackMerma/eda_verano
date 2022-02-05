/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 05/02/2022
 * @filename    : Par
 */
class Par <P>{
	private P a, b;

	public Par(P a, P b){
		this.a = a;
		this.b = b;
	}
	public Par<P> swap(){
		return new Par<P>(b,a);
	}
	public String toString(){
		return this.a+":"+this.b;
	}
}


