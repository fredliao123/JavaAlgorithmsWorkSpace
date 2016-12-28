/*有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
  求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 这个问题的特点是：每种物品只有一件，可以选择放或者不放。*/
public class ZeroOneBag{
	private int[] cost;
	private int[] value;
	private int V;
	public ZeroOneBag(int[] cost, int[] value, int V){
		this.cost = cost;
		this.V = V;
		this.value = value;
	}
	

	public int addUpMax(){//求恰好和为V
		int[] max = new int[V + 1];
		max[0] = 0;
		for(int i = 1; i <= V; i++){
			max[i] = Integer.MIN_VALUE;
		}
		int length = cost.length;
		for(int j = 0 ; j < length ; j++){
			for(int k = V; k > 0; k--){
				if(k - cost[j] >= 0){
					max[k] = Math.max(max[k], max[k - cost[j]] + value[j]);
				}
			}
		}
		return max[V];
	}
	
	public int minusMax(){
		int[] max = new int[V + 1];
		int length = cost.length;
		for(int j = 0 ; j < length ; j++){
			for(int k = V; k > 0; k--){
				if(k - cost[j] >= 0){
					max[k] = Math.max(max[k], max[k - cost[j]] + value[j]);
				}
			}
		}
		return max[V];
	}
	
	public static void main(String[] args){
		int[] cost = {3,4,3};
		int[] value = {5,6,7};
		int V = 10;
		ZeroOneBag bag = new ZeroOneBag(cost,value,V);
		System.out.print(bag.addUpMax());
	}
}