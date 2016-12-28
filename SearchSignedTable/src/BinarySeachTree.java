import java.util.LinkedList;
import java.util.Queue;

public class BinarySeachTree<Key extends Comparable<Key>, Value> implements ST{
	//��Ϊ�����������������ģ����Կ���ʵ��������ű�   ������ͨ����   ������ͨ������˳�������ʷ��ű�
	private Node root;
	Queue<Key> q;
	private class Node{
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int N;
		public Node(Key key, Value value , int N){
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
	
	
	public int size(){
		return size(root);
	}
	
	public int size(Node root){
		if(root == null){
			return 0;
		}else{
			return root.N;
		}
	}
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
 		return get(root, (Key)key);
	}
	
	public Value get(Node x,Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return get(x.left, key);
		}else if(cmp > 0){
			return get(x.right, key);
		}else{
			return x.value;
		}
	}

	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		root = put(root, (Key)key, (Value)value);
	}
	
	public Node put(Node root, Key key, Value value){
		if(root == null){
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo(root.key);
		if(cmp < 0){
			root.left = put(root.left , key , value);
		}else if(cmp > 0){
			root.right = put(root.right , key , value);
		}else{
			root.value = value;
		}
		root.N = size(root.left) + size(root.right) + 1;
		return root;
	}

	@Override
	public Iterable keys(Object lo, Object hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable keys() {
		// TODO Auto-generated method stub
		q = new LinkedList<Key>();
		keys(root);
		return q;
	}
	
	public void keys(Node root){
		if(root == null){
			return;
		}
		if(root.left != null){
			keys(root.left);
		}
		q.add(root.key);
		if(root.right != null){
			keys(root.right);
		}
		return;
		
	}
	
	public Key min(){//������С��ӵ�е�ֵ
		return min(root).key;
	}
	
	private Node min(Node x){
		if(x.left == null){
			return x;
		}
		return min(x.left);
	}
	
	public Key floor(Key key){
		//���ز�����key�����ֵ
		Node x = floor(root, key);
		if(x == null){
			return null;
		}
		return x.key;
	}
	
	private Node floor(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp == 0){
			return x;
		}else if(cmp < 0){
			return floor(x.left , key);
		}
		Node t = floor(x.right , key);//��Ӧkey�����ֵ������
		if(t != null){
			return t;
		}else{
			return x;//�����������ֵ
		}
	}
	
	public Key ceil(Key key){
		Node s = floor(root, key);
		if(s == null){
			return null;
		}
		return s.key;
	}
	
	public Node ceil(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp == 0){
			return x;
		}else if(cmp > 0){
			return ceil(x.right , key);
		}
		Node t = ceil(x.left , key);
		if(t != null){
			return t;
		}else{
			return x;
		}
	}
	
}