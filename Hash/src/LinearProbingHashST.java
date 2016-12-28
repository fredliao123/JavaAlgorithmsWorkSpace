public class LinearProbingHashST<Key, Value>{
	private int N = 0;
	private int M = 16;
	private Key[] keys;
	private Value[] values;
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		values = (Value[])new Object[M];
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}
	public void put(Key key, Value value){
		if(N >= M/2){
			resize(2*M);
		}
		int i;
		for(i = hash(key); keys[i] != null ;i = (i + 1) % M){
			if(keys[i] == key){
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}
	
	public Value get(Key key){
		for(int i = hash(key); keys[i] != null; i = (i + 1)%M){
			if(keys[i] == key){
				return values[i];
			}
		}
		return null;
	}
	
	public boolean contains(Key key){
		for(int i = hash(key); keys[i] != null ; i = (i + 1)%M){
			if(keys[i] == key){
				return true;
			}
		}
		return false;
	}
	
	public void delete(Key key){
		if(!contains(key)){
			return;
		}
	}
}