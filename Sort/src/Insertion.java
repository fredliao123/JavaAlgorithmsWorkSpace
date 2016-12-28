public class Insertion extends Example{
	public static void sort(Comparable[] a){
		int length = a.length;
		for(int i = 1 ; i < length ; i++){
			for(int j = i ; j > 0 && less(a[j] , a[j - 1]) ; j--){//如果j比j-1小就交换他们，相当于j-1往后移了一位
				exch(a , j ,j - 1);
			}
		}
	}
	
	public static void sort2(Comparable[] a){
		int length = a.length;
		for(int i = 1 ; i < length ; i++){
			Comparable temp = a[i];
			for(int j = i - 1 ; j >= 0 && less(temp , a[j]) ; j--){//如果j比j-1小就交换他们，相当于j-1往后移了一位
				exch(a , j + 1 ,j );
			}
		}
	}
	

	public static void main(String[] args){
		Integer[] a = new Integer[5];
		for(int i = 0 ; i < 5 ; i++){
			a[i] = 5 - i;
		}
		sort2(a);
		sort(a);
		show(a);
	}
}