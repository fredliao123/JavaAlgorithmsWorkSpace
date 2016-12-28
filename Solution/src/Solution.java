public class Solution {
    int[] nums = null;
    int N = 0;
    public int kthSmallest(int[][] matrix, int k) {
        nums = new int[k + 1];
        N = k;
        int length = matrix[0].length;
        int i = 1;
        for(int n = 0 ; n < length ; n++){
            for(int m = 0 ; m < length ; m++){
                if(i <= k){
                    nums[i] = matrix[m][n];
                    swim(i);
                    i++;
                }else{
                    if(matrix[m][n] < nums[1]){
                        nums[1] = matrix[m][n];
                        sink(1);
                    }
                }
            }
        }
        return nums[1];
    }
    public boolean less(int i , int j){
        return nums[i] < nums[j] ? true : false;
    }
    
    public void exch(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swim(int n){
        while(n > 1 && less(n / 2, n)){
                exch(n , n / 2);
                n = n / 2;
            }
    }
    
    
    public void sink(int n){
        while(2 * n <= N){
            int j = 2 * n;
            if(j < N && less(j, j + 1)){
                j++;
            }
            if(less(j , n)){
                break;
            }else{
                exch(j, n);
            }
            n = j;
        }
        
    }
    
    public static void main(String[] args){
    	int[][] matrix = {{1,2},{3, 3}};
    	Solution s = new Solution();
    	int num = s.kthSmallest(matrix, 2);
    	System.out.print(num);
    }
    

	public static int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int len = words.length;
		int[] value = new int[len];
		for (int i = 0; i < len; i++) {
			String tmp = words[i];
			value[i] = 0;
			for (int j = 0; j < tmp.length(); j++) {
				int b = tmp.charAt(j) - 'a';
				int a = 1 << (tmp.charAt(j) - 'a');
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}
		int maxProduct = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				if ((value[i] & value[j]) == 0
						&& (words[i].length() * words[j].length() > maxProduct))
					maxProduct = words[i].length() * words[j].length();
			}
		return maxProduct;
	}
	
	
}