package graphtheory.dfs;

public class Twozerozero {
	public int numIslands(char[][] grid) {
		int count=0;
		for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]=='1'){
        			count+=dfs(grid, i, j);
        		}
        	}
        }
		return count;
    }
	public int dfs(char[][] M,int i,int j){
		if(i<0||i>=M.length||j<0||j>=M[0].length){
			return 0;
		}
		if(M[i][j]=='0'){
			return 0;
		}
		M[i][j]='0';
		return Math.max(1,Math.max(Math.max(dfs(M, i-1, j),dfs(M, i+1, j)),Math.max(dfs(M, i, j-1),dfs(M, i, j+1))));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*11000
		11000
		00100
		00011*/
		
		/*11110
		11010
		11000
		00000*/
		Twozerozero zero=new Twozerozero();
		char[][] grid={
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'},
		};
		System.out.println(zero.numIslands(grid));
	}

}
