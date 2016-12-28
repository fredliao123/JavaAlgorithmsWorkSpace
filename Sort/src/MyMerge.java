import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MyMerge extends Example {
	public static Comparable[] aux;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;//注意这里
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;//注意这里
		for (int m = lo; m <= hi; m++) {
			aux[m] = a[m];
		}
		for (int l = lo; l <= hi; l++) {
			if (i > mid) {
				a[l] = aux[j++];
			}else if(j > hi){
				a[l] = aux[i++];
			}else if(less(aux[i] , aux[j])){
				a[l] = aux[i++];
			}else{
				a[l] = aux[j++];
			}
		}
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