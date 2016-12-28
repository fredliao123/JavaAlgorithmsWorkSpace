import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way extends Example{
	public static void sort(Comparable[] a){
		sort(a, 0 , a.length - 1);
	}
	public static void sort(Comparable[] a , int lo , int hi){
		if(hi <= lo){
			return;
		}
		int lt = lo ;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp > 0){
				exch(a, i , gt--);
			}else if(cmp < 0){
				exch(a , lt++ ,i++);
			}else{
				i++;
			}
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	
	public static void main(String[] args){
		int N = 15;
		Double[] a = new Double[N];
		for(int i = 0 ; i < N ; i++){
			double temp = 10*StdRandom.uniform(100);
			a[i] = temp;
			StdOut.print(a[i] + "  ");
		}
		sort(a);
		for(int i = 0 ; i < N ; i++){
			StdOut.print("\n");
		StdOut.print(a[i] + "  ");
		}
	}
}