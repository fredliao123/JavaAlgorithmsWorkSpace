import java.util.Iterator;

class FixedCapacityStackOfString {// ����ջ
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

public class FixedCapacityStack<Item> implements Iterable<Item> {// ���ݷ���ջ
	private Item[] a;
	private int N;

	public FixedCapacityStack(int size) {
		a = (Item[]) new Object[size];// ע��˴�
	}
	
	public FixedCapacityStack() {
		a = (Item[]) new Object[1];// ע��˴�
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
		Item item = a[--N];//���󱻵����ˣ�������--Nλ�õĶ��󲻻ᱻ���գ���������Զ�����ٷ���������������������
		//�����串�ǡ��������������Ϊ�գ���GC������Ч���ոĶ����Ż��ڴ�
		a[N] = null;//�����������
		if(N > 0 && N == a.length/4)resize(a.length/2);
		return item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;// ��ֵ��ֻ��ָ��
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
			return a[--i];//����ֻ�Ǳ��� ������pop
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

