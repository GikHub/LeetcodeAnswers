package graphtheory.dfs;
import java.util.ArrayList;
import java.util.List;


public class Fouroneseven {
	private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> resultList=new ArrayList<int[]>();
		if(matrix.length==0||matrix[0].length==0){
			return resultList;
		}
		boolean[][] canPacific=new boolean[matrix.length][matrix[0].length];
		boolean[][] canAtalantic=new boolean[matrix.length][matrix[0].length];
		int m=matrix.length;
		int n=matrix[0].length;
		for(int i=0;i<m;i++){
			dfs(matrix, i,0, canPacific);
			dfs(matrix,i, n-1, canAtalantic);
		}
		for(int i=0;i<n;i++){
			dfs(matrix, 0, i,canPacific);
			dfs(matrix,m-1,i,canAtalantic);
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(canPacific[i][j]&&canAtalantic[i][j]){
					int[] temp={i,j};
					resultList.add(temp);
				}
			}
		}
		return resultList;
	}
	private void dfs(int[][] matrix,int r,int c,boolean[][] canReach){
		if(r<0||r>=matrix.length||c<0||c>=matrix[0].length){
			return;
		}
		if(canReach[r][c]){
			return;
		}
		canReach[r][c]=true;
		for(int i=0;i<directions.length;i++){
			int nextR=r+directions[i][0];
			int nextC=c+directions[i][1];
			if(nextR<0||nextR>=matrix.length||nextC<0||nextC>=matrix[0].length||matrix[r][c]>matrix[nextR][nextC]){
				continue;
			}
			dfs(matrix, nextR, nextC, canReach);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fouroneseven seven=new Fouroneseven();
		
	}

}
