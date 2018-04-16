package greedy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sevensixthree {
	public List<Integer> partitionLabels(String S) {
		List<Integer> resultList=new ArrayList<Integer>();
		Map<Character,Integer> charMap=new HashMap<Character, Integer>();
		for(int i='a';i<'a'+26;i++){
			char charI=(char)i;
			int lastIndex=S.lastIndexOf(charI);
			charMap.put(charI,lastIndex);
		}
		int startIndex=0;
		int endIndex=0;
		while (startIndex<S.length()) {
			char c=S.charAt(startIndex);
			endIndex=charMap.get(c);
			for(int i=0;i<endIndex;i++){
				char tempC=S.charAt(i);
				int tempEndIndex=charMap.get(tempC);
				if(tempEndIndex>endIndex){
					endIndex=tempEndIndex;
				}
			}
			int size=endIndex-startIndex+1;
			resultList.add(size);
			startIndex=endIndex+1;
		}
		return resultList;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sevensixthree three=new Sevensixthree();
		String S="qiejxqfnqceocmy";
		List<Integer> resultList=three.partitionLabels(S);
		System.out.println(resultList);
	}

}
