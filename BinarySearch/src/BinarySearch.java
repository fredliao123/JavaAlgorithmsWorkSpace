import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static int rank(int[] array , int key , int lo, int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(key < array[mid]) return rank(array , key , lo , mid - 1);
		else if(key > array[mid]) return rank(array , key , mid + 1 , hi);
		else return mid;
	}
	
	public static int rank(int[] array , int key){
		return rank(array, key , 0 , array.length - 1);
	}
	
	public static void main(String[] args){
		System.out.printf("PI is %f", Math.PI);//注意 %d是整形，%f是浮点型
		//如果写成System.out.printf("PI is %d", Math.PI);则会报错
		System.out.printf("\nPI is %22f", Math.PI);//左边添加空格达到输出的宽度22，如果宽度小于字符串本来的宽度，则会被忽略
		System.out.printf("\nPI is %-22f", Math.PI);//右边加空格
		System.out.printf("\nPI is %.2f", Math.PI);//限制小数点后显示几位
		
	}
}