public class Fabonacci{
	public static long compute(int n){
		if(n > 1){
			long a, b = 1;
			n--;
			a = n & 1;
			n /= 2;
			while(n -- > 0){
				a += b;
				b += a;
			}
			return b;
			System.arraycopy(src, srcPos, dest, destPos, length)
		}
		return n;
	}
	
	public static void main(String[] args){
		compute(5);
	}
}