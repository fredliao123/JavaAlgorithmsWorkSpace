public class ReverseOddEvenArray{
	public static void reverse(int[] a){
		swap(a, 0, a.length - 1);
	}
	public static void swap(int[] a, int lo , int hi){
		if(lo >= hi){
			return;
		}
		int mid = lo + (hi - lo) / 2;
		swap(a, lo, mid);
		swap(a, mid + 1, hi);
		reverse(a, lo, mid, hi);
	}
	
	public static void reverse(int[] a, int lo, int mid, int hi){
		
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9};
		reverse(a);
	}
}
