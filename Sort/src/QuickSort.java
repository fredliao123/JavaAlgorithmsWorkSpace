import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends Example{
	public static void sort(Comparable[] a){
		sort(a, 0 ,a.length - 1);
	}
	public static void sort(Comparable[] a, int lo , int hi){
		if(lo >= hi)return;
		int j = partition(a, lo ,hi);
		sort(a, 0 ,j-1);
		sort(a, j+1, hi);
	}
	public static int partition(Comparable[]a, int lo, int hi){
		int i = lo + 1;
		int j = hi;
		Comparable v = a[lo];
		while(true){
			while(less(a[i], v)){
				if(i == hi){//���߽磬����i����С�����أ�
					break;
				}
				i++;
			}
			while(less(v,a[j])){
				if(j==lo){
					break;
				}
				j--;
			}
			if(i>=j){
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo ,j);//ע������һ����j���ϴ�ֵ�����i�������jһ������Ȼû���⣬������i��j��ôjһ���ǽ�С�Ǹ�
		return i;
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