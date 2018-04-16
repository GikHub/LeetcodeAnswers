package graphtheory.dfs;

public class OneThreeZero {
	/**
	 * ��˼·���������ĸ����ϵ�Oͨ��DFS�����ɺ�ʣ�µ�Oȫ���޸�ΪX��Ȼ���ٰ�ԭ���ĸ��߱�ǵ�O��ԭ����
	 * @param board
	 */
	public void solve(char[][] board) {
		if(board==null||board.length==0||board[0].length==0){
			return;
		}
		int m=board.length;
		int n=board[0].length;
		//ͨ��DFS����ĸ����ϵ�'O'
		for(int i=0;i<m;i++){
			dfs(board, i,0);
			dfs(board, i,n-1);
		}
		for(int i=0;i<n;i++){
			dfs(board,0,i);
			dfs(board,m-1,i);
		}
		//��������ʣ�µ�'O'����'X'�����ҽ�'T'��ԭΪ'O'
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
		//������Ǿ����ĸ����ϵ�'O'
		board[i][j]='T';
		dfs(board, i-1, j);
		dfs(board, i+1, j);
		dfs(board, i, j-1);
		dfs(board, i, j+1);
	}
	/**
	 * �ݹ����̫�����ջ�ڴ����
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
