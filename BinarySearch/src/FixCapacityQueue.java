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
		if(head == tail)//队满，加长
			resize(a.length*2);
	}
	
	public Item disQueue(){
		int temp = head;//防止对象游离，就是这个数已经出队了，但是GC不能回收它
		Item item = a[head++];
		a[temp] = null;//
		if(head == a.length) head = 0;
		if(size() <= a.length/4) resize(a.length/2);//如果队长只有数组一半，则减小数组长度
		return item;
	}
	
	public boolean isEmpty(){
		return head == tail;//如果相等肯定是空的，不是满的，因为满的情况下回数组加倍resize(a.length*2);
	}
	
	public int size(){
		return (tail - head) >= 0 ? (tail - head) : a.length - (head - tail);
	}
	
	public void resize(int length){
	     int count = 0;//这个是为了计算队尾的位置，因为如果是扩大数组，这是tail一定是等于head的，这样就不能
	     //直接计算size，因为会得到0
		 Item[] temp = (Item[])new Object[length];
		 for(int i = 0 ; i < length ; i++){
			 temp[i] = a[head++];//相当于出队，所以是head++，把队列中的数据都读出来
			 count++;//计算新队列有多少个元素，好知道tail的位置
			 if(head == a.length) head = 0;//如果读到了数组尾则在到数组头去读
			 if(tail == head ) break;//读完了
			 
		 }
		 tail = count;
		 head = 0;
		 a = temp;//这里相当于指针赋值
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