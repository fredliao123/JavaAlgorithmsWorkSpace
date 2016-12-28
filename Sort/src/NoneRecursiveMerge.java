import java.util.LinkedList;
import java.util.Queue;

public class NoneRecursiveMerge extends Example{
	public static Comparable[] aux;
	public static void sort(Comparable[] a){
		Queue<Integer>queue  = new LinkedList<Integer>();
		
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1 ; sz < N; sz = sz + sz){
			for(int lo = 0; lo < N - sz ; lo+= sz + sz){
				Merge.merge(a , lo , lo + sz - 1, Math.min(N-1, lo+sz+sz -1));
			}
		}
	}
}