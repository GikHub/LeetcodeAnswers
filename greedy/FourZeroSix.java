package greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class FourZeroSix {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o1[1]-o2[1];
				}
				return o2[0]-o1[0];
			}
		});
		List<int[]> resultList=new LinkedList<int[]>();
		for(int i=0;i<people.length;i++){
			int[] p=people[i];
			resultList.add(p[1],p);
		}
		int[][] result=new int[resultList.size()][2];
		for(int i=0;i<resultList.size();i++){
			result[i]=resultList.get(i);
		}
		return result;
	}
	/**
	 * 每次寻找元素耗时太长
	 * @param people
	 * @return
	 */
	/*public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
		});
		List<int[]> peopleList=new ArrayList<int[]>();
		List<int[]> resultList=new LinkedList<int[]>();
		for(int i=0;i<people.length;i++){
			peopleList.add(people[i]);
			resultList.add(people[i]);
		}
		for(int i=peopleList.size()-1;i>=0;i--){
			int[] peoples=peopleList.get(i);
			int higherNum=peoples[1];
			if(higherNum!=0){
				resultList.remove(peoples);
				int count=0;
				int insertIndex=0;
				inner: for(int j=0;j<resultList.size();j++){
					if(resultList.get(j)[0]>=peoples[0]){
						count++;
						if(count==higherNum){
							insertIndex=j+1;
							break inner;
						}
					}
				}
				resultList.add(insertIndex,peoples);
			}
		}
		int[][] result=new int[resultList.size()][2];
		for(int i=0;i<resultList.size();i++){
			result[i]=resultList.get(i);
		}
		return result;
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] nums={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		FourZeroSix six=new FourZeroSix();
		int[][] results=six.reconstructQueue(nums);
		for(int[] result:results){
			System.out.print(result[0]+","+result[1]);
			System.out.print("	");
		}
	}

}
