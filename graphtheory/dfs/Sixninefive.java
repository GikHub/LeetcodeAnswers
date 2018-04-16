package graphtheory.dfs;

public class Sixninefive {
	public int maxAreaOfIsland(int[][] grid) {
		int max=0;
		int maxR=grid.length;
		int maxC=grid[0].length;
		for(int i=0;i<maxR;i++){
			for(int j=0;j<maxC;j++){
				if(grid[i][j]==1){
					max=Math.max(max,dfs(grid, i, j));
				}
			}
		}
		return max;
    }
	/**
	 * dfs
	 * @param grid
	 * @param i ÐÐ
	 * @param j ÁÐ
	 * @return
	 */
	public int dfs(int[][] grid,int i,int j){
		int maxR=grid.length;
		int maxC=grid[0].length;
		if(i>=maxR||j>=maxC||i<0||j<0||grid[i][j]==0){
			return 0;
		}
		grid[i][j]=0;
		return dfs(grid, i-1, j)+dfs(grid, i+1, j)+dfs(grid, i, j-1)+dfs(grid, i, j+1)+1;
	}
	public static void main(String[] args) {
		Sixninefive five=new Sixninefive();
		int[][] grid={{1,1,0,0,0}
					,{1,1,0,0,0}
					,{0,0,0,1,1}
					,{0,0,0,1,1}};
		System.out.println(five.maxAreaOfIsland(grid));
	}	
}
