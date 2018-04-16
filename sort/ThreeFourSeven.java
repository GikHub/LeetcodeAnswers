package sort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Õ∞≈≈–Ú«ÛTop K
 * @author Administrator
 *
 */
public class ThreeFourSeven {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> resultList=new ArrayList<Integer>();
		Map<Integer,Integer> countMap=new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(countMap.containsKey(nums[i])){
				countMap.put(nums[i],countMap.get(nums[i])+1);
			}
			else{
				countMap.put(nums[i],1);
			}
		}
		List<Integer>[] countArray=new ArrayList[nums.length+1];
		Set<Integer> keySet=countMap.keySet();
		Iterator<Integer> it=keySet.iterator();
		while (it.hasNext()) {
			int key=it.next();
			if(countArray[countMap.get(key)]!=null){
				countArray[countMap.get(key)].add(key);
			}
			else{
				List<Integer> tempList=new ArrayList<Integer>();
				tempList.add(key);
				countArray[countMap.get(key)]=tempList;
			}
		}
		int count=0;
		for(int i=countArray.length-1;i>=0;i--){
			if(countArray[i]!=null){
				List<Integer> tempList=new ArrayList<Integer>();
				if(k-count>=countArray[i].size()){
					tempList=countArray[i];
				}
				else{
					tempList=countArray[i].subList(0,k-count+1);
				}
				resultList.addAll(tempList);
				count+=tempList.size();
			}
			if(count>=k){
				break;
			}
		}
        return resultList;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeFourSeven seven=new ThreeFourSeven();
		int nums[]={1,2};
		int k=2;
		System.out.println(seven.topKFrequent(nums, k));
	}

}
