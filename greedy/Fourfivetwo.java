package greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Fourfivetwo {
	public int findMinArrowShots(int[][] points) {
		if(points.length==0){
			return 0;
		}
		Arrays.sort(points,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]){
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		int end=Integer.MAX_VALUE;
		int num=1;
		for(int i=0;i<points.length;i++){
			if(points[i][0]<=end){
				end=points[i][1]<end?points[i][1]:end;
			}
			else{
				num++;
				end=points[i][1];
			}
		}
		return num;
	}
	public int findMinArrowShots1(int[][] points) {
        List<Map<String,Integer>> balloonList=new ArrayList<Map<String,Integer>>();
        if(points.length==0){
        	return 0;
        }
        for(int i=0;i<points.length;i++){
        	Map<String,Integer> balloonMap=new HashMap<String, Integer>();
        	balloonMap.put("left",points[i][0]);
        	balloonMap.put("right",points[i][1]);
        	balloonList.add(balloonMap);
        }
        int shots=0;
        while(balloonList.size()>0){
        	Map<String,Object> greedyMap=findMaxPublicCollection(balloonList);
        	List<Map<String,Integer>> maxList=(List<Map<String, Integer>>) greedyMap.get("maxList");
        	//开枪并从原集合中去掉爆炸的气球
        	//每个气球都没有交集
        	if(maxList.size()==0){
        		balloonList.remove(0);
        		shots++;
        	}
        	else{
        		balloonList.removeAll(maxList);
        		shots++;
        	}
        	
        }
        return shots;
    }
	/**
	 * 找到最大公共集合（贪心策略）
	 * @param balloonList
	 * @return
	 */
	public Map<String,Object> findMaxPublicCollection(List<Map<String,Integer>> balloonList){
		Map<String,Object> resultMap=new HashMap<String, Object>();
		Set<Integer> numSet=new HashSet<Integer>();
		for(Map<String,Integer> balloonMap:balloonList){
			int left=balloonMap.get("left");
			int right=balloonMap.get("right");
			numSet.add(left);
			numSet.add(right);
		}
		List<Integer> numList=new ArrayList<Integer>();
		Iterator<Integer> numIt=numSet.iterator();
		while (numIt.hasNext()) {
			numList.add(numIt.next());
		}
		Collections.sort(numList);
		int max=0;
		List<Map<String,Integer>> maxList=new ArrayList<Map<String,Integer>>();
		Map<String,Integer> commonMap=new HashMap<String, Integer>();
		int commonPoint=0;
		for(int i=0;i<numList.size()-1;i++){
			int left=numList.get(i);
			int right=numList.get(i+1);
			int common=0;
			List<Map<String,Integer>> commonList=new ArrayList<Map<String,Integer>>();
			int tempCommonPoint=right;
			for(Map<String,Integer> balloonMap:balloonList){
				int tempLeft=balloonMap.get("left");
				int tempRight=balloonMap.get("right");
				//if((tempLeft<=left&&tempRight>=right)||tempLeft==right||tempRight==left){
				if(tempCommonPoint>=tempLeft&&tempCommonPoint<=tempRight){
					common++;
					commonList.add(balloonMap);
				}
			}
			if(common>max){
				boolean isAllRight=true;
				List<Map<String,Integer>> tempBaloonList=new ArrayList<Map<String,Integer>>();
				tempBaloonList.addAll(balloonList);
				tempBaloonList.removeAll(commonList);
				inner:for(Map<String,Integer> tempBaloonMap:tempBaloonList){
					int tempRight=tempBaloonMap.get("right");
					if(tempRight<=tempCommonPoint){
						isAllRight=false;
						break inner;
					}
				}
				
				if(isAllRight){
					max=common;
					maxList=commonList;
					commonPoint=tempCommonPoint;
				}
			}
		}
		commonMap.put("point",commonPoint);
		resultMap.put("commonMap",commonMap);
		resultMap.put("maxList",maxList);
		return resultMap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fourfivetwo two=new Fourfivetwo();
		//[[9,17],[4,12],[4,8],[4,8],[7,13],[3,4],[7,12],[9,15]]
		int[][] points={{9,17}, {4,12}, {4,8}, {4,8},{7,13},{3,4},{7,12},{9,15}};
		//int[][] points={{1,2}, {3,4}, {5,6}, {7,8}};
		int shots=two.findMinArrowShots(points);
		System.out.println(shots);
	}

}
