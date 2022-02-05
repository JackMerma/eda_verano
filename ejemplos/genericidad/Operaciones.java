/**
 * @author      : Jackson Merma (mermaportocarreroj@gmail.com)
 * @created     : 05/02/2022
 * @filename    : Operaciones
 */
class Operaciones {
	public static <T extends Comparable<T>> T menor(T[] arr){
		T ele = arr[0];
		for(int i = 1; i<arr.length; i++){
			if(arr[i] != null){
				if(ele.compareTo(arr[i])>0)
					ele = arr[i];
			}
		}
		return ele;
	}
	public static void main(String [] args){
		String[] str = {"z","c","aa","ax","d"};
		System.out.println("menor cadenas:"+menor(str));


		Integer[] nums = {5,1,7,4,2,3,5,6,7};
		System.out.println("menor numeros:"+menor(nums));
	}
}


