import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Example{
	public static void sort(Comparable[] a){
		
	}
	protected static boolean less(Comparable v , Comparable w){
		return v.compareTo(w) < 0;
	}
	protected static void exch(Comparable[] a , int i , int j){
		Comparable t = a[i] ;
		a[i] = a[j];
		a[j] = t;
	}
	protected static void show(Comparable[] a){
		for(int i = 0 ; i < a.length ; i++){
			System.out.print(a[i] + " ");
		}
	}
	public static boolean isSorted(Comparable[] a){
		for(int i = 0 ; i < a.length ; i++){
			if(less(a[i] , a[i - 1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int N = 10;
		Double[] a = new Double[N];
		Double[] b = new Double[N];
		Double[] c = new Double[N];
		for(int i = 0 ; i < N ; i++){
			double temp = StdRandom.uniform();
			a[i] = temp;
			b[i] = temp;
			c[i] = temp;
		}
		
		Stopwatch timer1 = new Stopwatch();
		ShellSort.sort(a);
		double t1 = timer1.elapsedTime();
		Stopwatch timer2 = new Stopwatch();
		Insertion.sort(b);
		double t2 = timer1.elapsedTime();
		Stopwatch timer3 = new Stopwatch();
		Selection.sort(c);
		double t3 = timer1.elapsedTime();
		StdOut.println();
		StdOut.println("shell sort time is " + t1);
		StdOut.println("Insertion sort time is " + t2);
		StdOut.println("Selection sort time is " + t3);
		
	}
}