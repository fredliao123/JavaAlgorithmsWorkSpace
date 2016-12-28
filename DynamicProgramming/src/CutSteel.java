public class CutSteel {
	//�ݹ��������۸���󻯣�Ч��Ϊ2��n�η�
	public static final int[] steelPrice= {1,5,8,9,10,17,17,20,24,30};
	public static int cut(int n){
		if(n == 0){
			return 0;
		}
		int p = -1;
		for(int i = 1 ; i <= 10 && (n - i) >= 0 ; i++){
			p = Math.max(p, steelPrice[i - 1] + cut(n - i));
		}
		return p;
	}
	
	public static void main(String[] args){
		System.out.print(cut(50)) ;
	}
}