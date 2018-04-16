package graphtheory.bfs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过BFS算法求迷宫的最短路径
 * 迷宫：
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 其中1表示可以通过，0表示不能通过
 * 求从左上角到某点（targetR,targetC）的最短路径
 * @author Administrator
 *
 */
public class MinPathLength {
	public int getMinPathLength(int[][] grids,int targetR,int targetC){
		//方向
		int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
		//最大行数
		int maxRow=grids.length;
		//最大列数
		int maxColumn=grids[0].length;
		//初始位置
		Position initPosition=new Position(0,0,1);
		//用来保存每次遍历下,该层的位置
		List<Position> positionList=new ArrayList<Position>();
		positionList.add(initPosition);
		grids[0][0]=0;
		cycle:for(;;){
			List<Position> tempList=new ArrayList<Position>();
			 for(Position position:positionList){
				 for(int i=0;i<4;i++){
					Position tempPosition=new Position(position.r+direction[i][0],position.c+direction[i][1],position.length+1);
					//坐标合法性校验
					if(tempPosition.r<0||tempPosition.r>maxRow-1||tempPosition.c<0||tempPosition.c>maxColumn-1){
						continue;
					}
					if(grids[tempPosition.r][tempPosition.c]!=1){
						continue;
					}
					//遍历过的点标记为0（防止发生回溯）
					grids[tempPosition.r][tempPosition.c]=0;
					if(tempPosition.r==targetR-1&&tempPosition.c==targetC-1){
						return tempPosition.length;
					}
					if(tempPosition.r==maxRow-1&&tempPosition.c==maxColumn-1){
						break cycle;
					}
					tempList.add(tempPosition);
				}
			}
			positionList.clear();
			positionList.addAll(tempList);
		}
		return -1;
	}
	/**
	 * 获取最短路径的行走方向(上U下D左L右R)
	 * @param grids
	 * @param targetR
	 * @param targetC
	 * @return
	 */
	public String getMinPathLengthPath(int[][] grids,int targetR,int targetC){
		//方向
		int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
		//最大行数
		int maxRow=grids.length;
		//最大列数
		int maxColumn=grids[0].length;
		//初始位置
		Position initPosition=new Position(0,0,1);
		//用来保存每次遍历下,该层的位置
		List<Position> positionList=new ArrayList<Position>();
		positionList.add(initPosition);
		grids[0][0]=0;
		Position finalPositon=null;
		cycle:for(;;){
			List<Position> tempList=new ArrayList<Position>();
			 for(Position position:positionList){
				 for(int i=0;i<4;i++){
					Position tempPosition=new Position(position.r+direction[i][0],position.c+direction[i][1],position.length+1);
					//坐标合法性校验
					if(tempPosition.r<0||tempPosition.r>maxRow-1||tempPosition.c<0||tempPosition.c>maxColumn-1){
						continue;
					}
					if(grids[tempPosition.r][tempPosition.c]!=1){
						continue;
					}
					//遍历过的点标记为0（防止发生回溯）
					grids[tempPosition.r][tempPosition.c]=0;
					String tempDirection="";
					if(i==0){
						tempDirection="D";
					}
					else if(i==1){
						tempDirection="U";
					}
					else if(i==2){
						tempDirection="R";
					}
					else{
						tempDirection="L";
					}
					List<String> tempDirectionList=new ArrayList<String>();
					tempDirectionList.addAll(position.getDirectionList());
					tempDirectionList.add(tempDirection);
					tempPosition.setDirectionList(tempDirectionList);
					if(tempPosition.r==targetR-1&&tempPosition.c==targetC-1){
						finalPositon=tempPosition;
						break cycle;
					}
					if(tempPosition.r==maxRow-1&&tempPosition.c==maxColumn-1){
						break cycle;
					}
					tempList.add(tempPosition);
				}
			}
			positionList.clear();
			positionList.addAll(tempList);
		}
		if(finalPositon!=null){
			List<String> directionList=finalPositon.getDirectionList();
			String position="";
			for(String d:directionList){
				position+=d;
			}
			return position;
		}
		return "";
	}
	
	/**
	 * 位置
	 * @author Administrator
	 *
	 */
	private class Position{
		//行数
		int r;
		//列数
		int c;	
		//路径长度
		int length;
		//方向列表
		List<String> directionList=new ArrayList<String>();
		public Position(int r,int c,int length) {
			this.r=r;
			this.c=c;
			this.length=length;
		}
		private void setDirectionList(List<String> directionList){
			this.directionList.addAll(directionList);
		}
		private List<String> getDirectionList(){
			return directionList;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinPathLength minPathLength=new MinPathLength();
		int[][] grids={{1,1,0,1},
					   {1,0,1,0},
					   {1,1,1,1},
					   {1,0,1,1}};
		int targetR=4;
		int targetC=4;
		System.out.println(minPathLength.getMinPathLengthPath(grids, targetR, targetC));
	}

}
