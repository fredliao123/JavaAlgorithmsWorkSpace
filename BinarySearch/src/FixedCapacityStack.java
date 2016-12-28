import java.util.Iterator;

class FixedCapacityStackOfString {// 定容栈
	private String[] a;
	private int N;

	public FixedCapacityStackOfString(int size) {
		a = new String[size];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(String s) {
		a[N++] = s;
	}

	public String pop() {
		return a[--N];
	}
}

public class FixedCapacityStack<Item> implements Iterable<Item> {// 定容泛型栈
	private Item[] a;
	private int N;

	public FixedCapacityStack(int size) {
		a = (Item[]) new Object[size];// 注意此处
	}
	
	public FixedCapacityStack() {
		a = (Item[]) new Object[1];// 注意此处
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item s) {
		if (N == a.length)
			resize(2 * N);
		a[N++] = s;
	}

	public Item pop() {
		Item item = a[--N];//对象被弹出了，但数组--N位置的对象不会被回收，但我们永远不会再访问他，除非又有入札的
		//对象将其覆盖。所以这里把他设为空，让GC可以有效回收改对象，优化内存
		a[N] = null;//避免对象游离
		if(N > 0 && N == a.length/4)resize(a.length/2);
		return item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;// 赋值的只是指针
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i = N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];//这里只是遍历 并不是pop
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] Args){
		FixedCapacityStack<Integer> a = new FixedCapacityStack<>();
		a.push(1);
		a.push(2);
		a.push(3);
		for(int b : a){
			System.out.println(b);
		}
	}

}

