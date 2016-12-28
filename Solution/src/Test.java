public class Test{
	public static void main(String[] args){
		int i = 1;
		int count = 0;
		for(int j = 0 ; j < 32 ; j++){
			int k = 2 ^ j;
			if((i & k) == 1) count++;
		}
		System.out.print(count);
	}
}