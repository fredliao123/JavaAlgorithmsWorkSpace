import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
	public Stack<Integer> stack ;
	public LinkedList<Integer> list ;
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<Integer>();
    	list = new LinkedList<>();
    
    	
    }
    
    public void push(int x) {
        stack.push(x);
        int i = 0;
        for(; i < list.size()&& x >list.get(i) ; i++){//注意list，Hashmap都使用size（），String用length
        	
        }
        list.add(i, x);
    }
    
    public void pop() {
        int x = stack.peek();
        list.remove((Integer)x);
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return list.peekFirst();
    }
    
    public static void main(String[] args){
    	MinStack s = new MinStack();
    	s.push(-2);
    	s.push(0);
    	s.push(-3);
    	s.getMin();
    	s.pop();
    	s.top();
    	s.getMin();
    }
}
