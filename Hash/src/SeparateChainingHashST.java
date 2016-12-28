import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SeparateChainingHashST<Key, Value>{
	private int N;
	private int M;
	private SequentialSearchST<Key,Value>[] st;
	public SeparateChainingHashST(){
		this(996);
	}
	public SeparateChainingHashST(int M){
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i = 0 ; i < M ; i++){
			st[i] = new SequentialSearchST();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M ;
	}
	
	public Value get(Key key){
		return (Value)st[key.hashCode()].get(key);
	}
	
	public void put(Key key, Value value){
		st[key.hashCode()].put(key, value);
	}
	
	public Iterable<Key> keys(){
		Queue<Key> queue = new LinkedList<Key>();
		for(SequentialSearchST s : st){
			for(Object key: s.keys()){
				queue.add((Key) key);
			}
			
		}
		return queue;
	}
	
	
	
	
	

}

