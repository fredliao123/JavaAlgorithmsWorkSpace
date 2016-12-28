import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ShellSort extends Example {
	public static void sort(Comparable[] a) {
		int length = a.length;
		int N = 1;
		while (N < length / 3) {
			N = N * 3 + 1;
		}
		while (N >= 1) {
			for (int i = N; i < length; i++) {
				for (int j = i; j >= N && less(a[j], a[j - N]); j -= N) {
					exch(a, j, j - N);
				}
			}
			N = N/3;
		}
	}

}