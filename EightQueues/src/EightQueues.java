public class EightQueues {
	public static final int MaxQueues = 8;
	public static int count = 0;
	public static int[] cols = new int[MaxQueues];

	public void solution() {
		getQueues(0);
		System.out.println(count);
	}

	public void getQueues(int n) {
		boolean[] row = new boolean[MaxQueues];
		for (int i = 0; i < n; i++) {
			row[cols[i]] = true;
			int d = n - i;
			if (cols[i] - d >= 0) {
				row[cols[i] - d] = true;
			}
			if (cols[i] + d < MaxQueues) {
				row[cols[i] + d] = true;
			}
		}
		for (int i = 0; i < MaxQueues; i++) {
			if (row[i]) {
				continue;
			}
			cols[n] = i;// 第n行第i列
			if (n < MaxQueues - 1) {
				getQueues(n + 1);
			} else {
				printQueues();
				count++;
			}
		}

	}

	public void printQueues() {
		for (int i = 0; i < MaxQueues; i++) {
			for (int j = 0; j < MaxQueues; j++) {
				if (cols[j] == i) {
					System.out.print("0");
				} else {
					System.out.print("+");
				}

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
	}

	public static void main(String[] args) {
		EightQueues q = new EightQueues();
		q.solution();
	}
}