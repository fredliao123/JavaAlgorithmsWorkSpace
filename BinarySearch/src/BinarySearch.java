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
		System.out.printf("PI is %f", Math.PI);//ע�� %d�����Σ�%f�Ǹ�����
		//���д��System.out.printf("PI is %d", Math.PI);��ᱨ��
		System.out.printf("\nPI is %22f", Math.PI);//�����ӿո�ﵽ����Ŀ��22��������С���ַ��������Ŀ�ȣ���ᱻ����
		System.out.printf("\nPI is %-22f", Math.PI);//�ұ߼ӿո�
		System.out.printf("\nPI is %.2f", Math.PI);//����С�������ʾ��λ
		
	}
}