public class SequentialSearchST <Key, Value> implements ST{
	private Node first;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	
	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		for(Node x = first; x!=null; x = x.next){
			if(x.key == (Key)key){
				return true;
			}
		}
		return false;
	}


	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		for(Node x = first; x!=null ; x = x.next){
			if(x.key == key){
				return (Value)x.val;
			}
		}
		return null;
	
	}


	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		for(Node x = first; x != null; x = x.next){
			if(x.key == key){
				x.val = (Value)value;
				return;
			}
		}
		first = new Node((Key)key,(Value)value,first);//在链表头加新元素
	
	}


	@Override
	public Iterable keys(Object lo, Object hi) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}