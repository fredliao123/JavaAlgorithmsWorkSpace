public class quickFind {
	private int count;
	private int[] id;
	private int[] sz;
	public quickFind(int N) {
		count = N;
		for(int i = 0 ; i < N ; i++){
			id[i] = i;
			sz[i] = 1;
		}		
	}
	public int Count(){
		return count;
	}
	public boolean isConnected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		while(p != id[p]) p = id[p];
		return p;
	}
	
	public void Union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
}