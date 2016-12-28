public class DynamicCutSteelTwo{
	public static final int[] steelPrice= {1,5,8,9,10,17,17,20,24,30};
	public static int cut(int n){
		int [] p = new int [n + 1];
		p[0] = 0;
		for(int j = 1 ; j <= n ; j++){
			int q = -1;
			for(int i = 1 ; i <= j && i <= 10; i++){//�˴�ΪʲôҪ���ƣ飼��������Ϊ�����ֻ��ʮ�����
				q = Math.max(q,  steelPrice[i - 1] + p[j - i]);
			}
			p[j] = q;
		}
		return p[n];
	}
	public static void main(String[] args){
		System.out.print(cut(100)) ;
	}
}