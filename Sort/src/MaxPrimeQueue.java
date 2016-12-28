public class MaxPrimeQueue<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N = 0;
	public MaxPrimeQueue(int MaxN){
		pq = (Key[])new Comparable[MaxN + 1];
	}
	public void Insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	public Key delMax(){
		Key v = pq[1];
		pq[1] = pq[N--];
		pq[N + 1] = null;
		sink(1);
		return v;
	}
	
	public Key max(){
		return pq[1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void swim(int k){
		while(k > 1 && less(k/2 , k)){//注意是要大于1哦
			exch(k/2 , k);
			k = k/2;
		}
		
	}
	
	public void sink(int k){
		while(2*k <= N){
			int j = k*2;
			if(j < N && less(j , j+1)){
				j++;
			}
			if(!less(k , j)){//当K比两数中较大的还大就结束下沉
				break;
			}
			exch(j, k );
			k = j;
		}
	}
	
	public boolean less(int i , int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	public void exch(int i, int j){
		Key v = pq[i];
		pq[i] = pq[j];
		pq[j] = v;
	}
}