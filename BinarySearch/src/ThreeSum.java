import java.util.Arrays;

import javax.sql.rowset.CachedRowSet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class ThreeSum{
	public static int Calcu(int [] a){
		int cnt = 0;
		int length = a.length;
		Arrays.sort(a);
		for(int i = 0 ; i < length ; i++){
			for(int j = i + 1; j < length ; j++){
				if(BinarySearch.rank(a, -a[i] - a[j]) > j)
					cnt++;
			}
		}
		return cnt;
		
	}
	
	public static void main(String[] args){
		int[] a = In.readInts("F:\\1Kints.txt");
		StdOut.print(Calcu(a));
	}
}