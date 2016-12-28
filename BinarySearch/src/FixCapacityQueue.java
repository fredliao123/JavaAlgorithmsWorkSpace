import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class FixCapacityQueue<Item> implements Iterable<Item>{
	private Item[] a;
	private int head;
	private int tail;
	public FixCapacityQueue(int size){
		a = (Item[])new Object[size];
	}
	
	public FixCapacityQueue(){
		a = (Item[])new Object[1];
	}
	public void enQueue(Item m){
		a[tail++] = m;
		if(tail == a.length) tail = 0;
		if(head == tail)//�������ӳ�
			resize(a.length*2);
	}
	
	public Item disQueue(){
		int temp = head;//��ֹ�������룬����������Ѿ������ˣ�����GC���ܻ�����
		Item item = a[head++];
		a[temp] = null;//
		if(head == a.length) head = 0;
		if(size() <= a.length/4) resize(a.length/2);//����ӳ�ֻ������һ�룬���С���鳤��
		return item;
	}
	
	public boolean isEmpty(){
		return head == tail;//�����ȿ϶��ǿյģ��������ģ���Ϊ��������»�����ӱ�resize(a.length*2);
	}
	
	public int size(){
		return (tail - head) >= 0 ? (tail - head) : a.length - (head - tail);
	}
	
	public void resize(int length){
	     int count = 0;//�����Ϊ�˼����β��λ�ã���Ϊ������������飬����tailһ���ǵ���head�ģ������Ͳ���
	     //ֱ�Ӽ���size����Ϊ��õ�0
		 Item[] temp = (Item[])new Object[length];
		 for(int i = 0 ; i < length ; i++){
			 temp[i] = a[head++];//�൱�ڳ��ӣ�������head++���Ѷ����е����ݶ�������
			 count++;//�����¶����ж��ٸ�Ԫ�أ���֪��tail��λ��
			 if(head == a.length) head = 0;//�������������β���ڵ�����ͷȥ��
			 if(tail == head ) break;//������
			 
		 }
		 tail = count;
		 head = 0;
		 a = temp;//�����൱��ָ�븳ֵ
	}
	
	public void printAll(){
		for(Item i : a){
			StdOut.print(i + " ");
		}
		StdOut.print("\n");
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new AwesomeIterator();
	}
	
	private class AwesomeIterator implements Iterator<Item>{
		private int thisHead = head;
		private int thisTail = tail;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !(thisHead == thisTail);
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(thisHead == a.length) thisHead = 0;
			return a[thisHead++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		} 
		
	}
	
	public static void main(String[] Args){
		FixCapacityQueue<Integer> queue = new FixCapacityQueue<>();
		for(int i = 0 ; i < 10 ; i ++ ){
			queue.enQueue(i);
			queue.printAll();
			
		}
		StdOut.print("\n");
		for(int i : queue)StdOut.print(i);
		StdOut.print("\n");
		for(int i = 0 ; i < 3 ; i ++ ){
			queue.disQueue();
			queue.printAll();
			
		}
		StdOut.print("\n");
		for(int i : queue)StdOut.print(i);
		StdOut.print("\n");
		
		for(int i = 0 ; i < 10 ; i ++ ){
			queue.enQueue(i + 10);
			queue.printAll();
		}
		StdOut.print("\n");
		for(int i : queue)StdOut.print(i);
		StdOut.print("\n");
		
		
		for(int i = 0 ; i < 10 ; i ++ ){
			queue.disQueue();
			queue.printAll();
		}
		StdOut.print("\n");
		
	}
	
}