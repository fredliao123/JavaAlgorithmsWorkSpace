public class PriorityQueue {
	int[] pq;
	int N = 0;
	
	public PriorityQueue(int Max){
		pq = new int[Max];
	}

	public boolean less(int i, int j) {
		return pq[i] < pq[j];
	}

	public void exch(int i, int j) {
		int temp = pq[j];
		pq[j] = pq[i];
		pq[i] = temp;
	}

	public void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	public void sink(int k) {
		while (2 * k <= N) {
			int j = k * 2;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	public void add(int i) {
		pq[++N] = i;
		swim(N);
	}

	public int remove() {
		int max = pq[1];
		exch(1, N--);
		pq[N + 1] = 0;
		sink(1);
		return max;
		
	}
}