public class Selection extends Example{//—°‘Ò≈≈–Ú
	public static void sort(Comparable[] a){
		for(int i = 0 ; i < a.length ; i++){
			int min = i;
			for(int j = i + 1 ; j < a.length ; j++){
				if(less(a[j] , a[min])){
					min = j;
				}	
			}
			exch(a, i, min);
		}
		show(a);
	}
	
	public static void main(String[] args){
		Integer[] a = new Integer[5];
		for(int i = 0 ; i < 5 ; i++){
			a[i] = 5 - i;
		}
		sort(a);
	}
}