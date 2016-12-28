/*��N����Ʒ��һ������ΪV�ı�������i����Ʒ�ķ�����c[i]����ֵ��w[i]��
  ��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����
 ���������ص��ǣ�ÿ����Ʒֻ��һ��������ѡ��Ż��߲��š�*/
public class ZeroOneBag{
	private int[] cost;
	private int[] value;
	private int V;
	public ZeroOneBag(int[] cost, int[] value, int V){
		this.cost = cost;
		this.V = V;
		this.value = value;
	}
	

	public int addUpMax(){//��ǡ�ú�ΪV
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