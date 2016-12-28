public class RedAndBlackTree<Key extends Comparable<Key>, Value>{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int N;
		boolean color;
		public Node(Key key, Value value, int N, boolean color){
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;//指向节点x连接的颜色
		}
		
	}
	
	private boolean isRed(Node x){
		if(x == null){
			return false;
		}
		return x.color == RED;
	}	
	
	public Node rotateLeft(Node h){//右红连接移到左边
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	public Node rotateRight(Node h){//左红连接移到右边
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	public int size(Node x){
		if(x == null){
			return 0;
		}else{
			return x.N;
		}
	}
	
	public void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	private Node put(Node x, Key key, Value value){
		if(x == null){
			return new Node(key, value, 1, RED);
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			x.left = put(x.left, key, value);
		}else if(cmp > 0){
			x.right = put(x.right, key, value);
		}else{
			x.value = value;
		}
		if(isRed(x.right) && !isRed(x.left)){
			x = rotateLeft(x);
		}
		if(isRed(x.left) && isRed(x.left.left)){
			x = rotateRight(x);
		}
		if(isRed(x.left) && isRed(x.right)){
			flipColors(x);
		}
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
	
}