package graphtheory.dfs;

public class OneThreeZero {
	/**
	 * 新思路：将矩阵四个边上的O通过DFS标记完成后，剩下的O全部修改为X，然后再把原来四个边标记的O还原回来
	 * @param board
	 */
	public void solve(char[][] board) {
		if(board==null||board.length==0||board[0].length==0){
			return;
		}
		int m=board.length;
		int n=board[0].length;
		//通过DFS标记四个边上的'O'
		for(int i=0;i<m;i++){
			dfs(board, i,0);
			dfs(board, i,n-1);
		}
		for(int i=0;i<n;i++){
			dfs(board,0,i);
			dfs(board,m-1,i);
		}
		//将矩阵中剩下的'O'换成'X'，并且将'T'还原为'O'
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]=='T'){
					board[i][j]='O';
				}
				else if(board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}
		
	}
	/**
	 * DFS
	 * @param board
	 * @param i
	 * @param j
	 */
	public void dfs(char[][] board,int i,int j){
		if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
			return;
		}
		//用来标记矩阵四个边上的'O'
		board[i][j]='T';
		dfs(board, i-1, j);
		dfs(board, i+1, j);
		dfs(board, i, j-1);
		dfs(board, i, j+1);
	}
	/**
	 * 递归层数太深，导致栈内存溢出
	 */
	/*public void solve(char[][] board) {
       for(int i=0;i<board.length;i++){
    	   for(int j=0;j<board[i].length;j++){
    		   dfs(board, i, j);
    	   }
       }
    }
	public void dfs(char[][] board,int i,int j){
		if(i>=board.length||i<0||j>=board[0].length||j<0){
			return;
		}
		if(i==0||i==board.length-1||j==0||j==board[0].length-1){
			return;
		}
		if(board[i][j]=='x'||board[i][j]=='X'){
			return;
		}
		board[i][j]='X';
		dfs(board, i-1, j);
		dfs(board, i+1, j);
		dfs(board, i, j-1);
		dfs(board,i,j+1);
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board={
						{'X','X', 'X', 'X'},
						{'X', 'O', 'O', 'X'},
						{'X','X', 'X','X'},
						{'X','O','X','X'}
						};
		OneThreeZero zero=new OneThreeZero();
		zero.solve(board);
		System.out.println(board);
	}

}
