public class KeySort {
	// 字符串的索引排序，p456
	private static final int R = 5;
	private int[] count = new int[R + 1];

	public static class Item {
		public String name;
		public int key;// key是1，2，3，4中的一个(0, 5)

		public Item(String name, int key) {
			this.name = name;
			this.key = key;
		}
	}

	public Item[] Sort(Item[] items) {
		int length = items.length;
		for (int i = 0; i < length; i++) {
			count[items[i].key + 1]++;
		}
		for (int r = 0; r < R; r++) {
			count[r + 1] += count[r];
		}
		Item[] temp = new Item[length];
		for (int i = 0; i < length; i++) {
			temp[count[items[i].key]++] = items[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		KeySort keySort = new KeySort();
		Item[] items = {new Item("a", 1),
				new Item("b", 3),
				new Item("c", 4),
				new Item("d", 2),
				new Item("e", 3),
				new Item("f", 1),
				new Item("g", 4),
				};
		Item[] sort = keySort.Sort(items);
		for(Item i : sort){
			System.out.println(i.name + " "+ i.key);
		}
	}
}