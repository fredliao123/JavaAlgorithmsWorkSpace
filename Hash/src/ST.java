public interface ST<Key, Value>{
	public Value get(Key key);
	public boolean contains(Key key);
	public void put(Key key, Value value);
	public Iterable<Key> keys(Object lo , Object hi);
	public Iterable<Key> keys();
}