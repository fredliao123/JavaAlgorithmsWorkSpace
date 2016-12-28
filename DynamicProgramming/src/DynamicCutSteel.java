import java.util.HashMap;

public class DynamicCutSteel {
	//增加了一个hashmap来记录以及求过得值，用空间换时间
	public static final int[] steelPrice= {1,5,8,9,10,17,17,20,24,30};
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static int cut(int n){
		if(n == 0){
			return 0;
		}
		if(map.containsKey(n)){
			return map.get(n);
		}
		int p = -1;
		for(int i = 1 ; i <= 10 && (n - i) >= 0 ; i++){
			p = Math.max(p, steelPrice[i - 1] + cut(n - i));
		}
		map.put(n, p);
		return p;
	}
	
	public static void main(String[] args){
		System.out.print(cut(1000)) ;
	}
}