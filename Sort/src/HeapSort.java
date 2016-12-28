import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        int arrayLength=a.length;  
        //循环建堆  
        for(int i = 0 ; i < arrayLength - 1 ; i++){
        	buildMaxHeap(a, arrayLength - 1 - i);
        	swap(a, 0 , arrayLength - 1 - i);
        	System.out.println(Arrays.toString(a));
        }
    }
    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex){
    	for(int i = lastIndex / 2 ; i >= 0 ; i--){
    		int k = i;
    		while(2 * k <= lastIndex){
    			int biggerIndex = 2  * k;
    			if(biggerIndex < lastIndex && data[biggerIndex + 1] > data[biggerIndex]){
    				biggerIndex ++;
    			}
    			if(data[k] < data[biggerIndex]){
    				swap(data, k , biggerIndex);
    				k = biggerIndex;
    			}else{
    				break;
    			}
    		}
    	}
    }
    //交换
    private static void swap(int[] data, int i, int j) {  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    } 
}