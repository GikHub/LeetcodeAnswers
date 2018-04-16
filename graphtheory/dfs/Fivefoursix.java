package graphtheory.dfs;

public class Fivefoursix {
	public int findCircleNum(int[][] M) {
        boolean[] isVisited=new boolean[M.length];
        int count=0;
        for(int i=0;i<M.length;i++){
        	if(!isVisited[i]){
        		count++;
        		dfs(M, i, isVisited);
        	}
        }
        return count;
    }
	public void dfs(int[][] M,int i,boolean[] isVisited){
		isVisited[i]=true;
		for(int k=0;k<M[i].length;k++){
			if(M[i][k]==1&&!isVisited[k]){
				isVisited[k]=true;
				dfs(M, k, isVisited);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fivefoursix six=new Fivefoursix();
		int[][] M={{1,1,0},
		           {1,1,1},
		           {0,1,1}};
		System.out.println(six.findCircleNum(M));
	}

}
