public class MSD{
	/*
	 * ×Ö·û´®¸ßÎ»ÅÅÐò P461
	 */
	private static int R = 256;
	private static String[] aux;
	public static int charAt(String s, int d){
		if(d < s.length()){
			return s.charAt(d);
		}else{
			return -1;
		}
	}
	
	public static void sort(String [] a){
		int N = a.length;
		aux = new String[N];
		
	}
	
	public static void sort(String[] a, int lo, int hi, int d){
		if(hi < lo){
			return;
		}
		int[] count = new int[R + 2];
		for(int i = lo; i <= hi ; i ++){
			count [charAt(a[i], d) + 2]++;
		}
		for(int r = 0 ; r < R + 1; r++){
			count[r + 1] += count[r];
		}
		for(int i = lo ; i <= hi ; i++){
			aux[count[charAt(a[i], d) + 1] ++] = a[i];
		}
		for(int i = lo ; i <= hi ; i++){
			a[i] = aux[i - lo];
		}
		for(int r = 0 ; r < R; r++){
			sort(a, lo + count[r], lo + count[r + 1] - 1, d+1);
		}
	}
}