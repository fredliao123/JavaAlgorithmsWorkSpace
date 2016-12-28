import edu.princeton.cs.algs4.Queue;

public class BinarySearchST <Key extends Comparable <Key> , Value> implements ST{
	private int N;
	private Key[] keys;
	private Value[] values;
	public BinarySearchST(int capacity){
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Object[capacity];
	}
	
	public BinarySearchST(){
		keys = (Key[])new Comparable[1];
		values = (Value[])new Object[1]; 
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	@Override
	public Object get(Object key){
		if(isEmpty()){
			return null;
		}
		int i = rank((Key)key);
		if(i < N  && keys[i].compareTo((Key)key) == 0){
			return (Value)values[i];
		}else{
			return null;
		}
	}
	
	@Override
	public void put(Object key, Object value){
		int i = rank((Key)key);
		if(i < N && keys[i].compareTo((Key)key)==0){
			values[i] = (Value)value;
			return;
		}
		for(int j = N ; j > i ; j--){
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = (Key)key;
		values[i] = (Value)value;
		N++;
		if(N == keys.length){
			resize(N*2);
		}
		
	}
	
	public int rank(Key key){
		int lo = 0 ; int hi = N - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			int cmp = keys[mid].compareTo(key);
			if(cmp > 0){
				lo = mid + 1;
			}else if(cmp < 0){
				hi = mid - 1;
			}else{
				return mid;
			}
			
		}
		return lo;
	}
	
	public void resize(int length){
		Key[] tempkey = (Key[])new Comparable[length];
		Value[] tempValue = (Value[]) new Object[length];
		for(int i = 0 ; i < N ; i++){
			tempkey[i] = keys[i];
			tempValue[i] = values[i];
		}
		keys = tempkey;
		values = tempValue;
	}

	

	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		int i = rank((Key) key);
		if(i < N && keys[i].compareTo((Key)key) == 0 ){
			return true;
		}
		return false;
	}

	@Override
	public Iterable keys(Object lo, Object hi) {
		// TODO Auto-generated method stub
		Queue<Key>queue = new Queue<Key>();
		for(int i = rank((Key)lo) ; i < rank((Key)hi) ; i++){
			queue.enqueue(keys[i]);
		}
		if(contains((Key)hi)){
			queue.enqueue(keys[rank((Key)hi)]);
		}
		
		return null;
	}

	@Override
	public Iterable keys() {
		// TODO Auto-generated method stub
		return null;
	}

	
}