import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Merge extends Example{
	public static Comparable[] aux;
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a , 0 , a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){ 
		if(lo >= hi){ 
			StdOut.println("sort  return " + "lo=" + lo + "  " +"hi=" + hi);
			return;
			}
		int mid = lo + (hi - lo)/2;
		StdOut.println("sort " + "lo=" + lo + "  " +"hi=" + hi);
		sort(a, lo, mid);//其实这个函数名叫sort，其实只是个把数组分成一段一段的函数，但原理着实精妙
		sort(a ,mid + 1, hi);
		merge(a, lo , mid , hi);
	}
	
	public static void merge(Comparable[] a , int lo , int mid , int hi){
		int i = lo ; int j = mid + 1;
		StdOut.println("merge " + "lo=" + lo + "  "+"mid= "+ mid + "  " +"hi=" + hi );
		for(int k = lo ; k <= hi ;k++){
			aux[k] = a[k];
		}
		for(int k = lo ; k <= hi ; k++){
			if(i > mid){
				a[k] = aux[j++];
			}
			else if(j > hi){
				a[k] = aux[i++];
			}else if(less(aux[j], aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
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