package doublepointer;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator;
import java.util.List;


public class FiveTwoFour {
	public String findLongestWord(String s, List<String> d) {
		//对字典按照字符串长度倒序排序，若字符串长度一样，则按照字典顺序排序
		Collections.sort(d,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()){
					return -1;
				}
				else if (o1.length()<o2.length()){
					return 1;
				}
				int index=0;
				while (index<o1.length()) {
					if(o1.charAt(index)<o2.charAt(index)){
						return -1;
					}
					else if(o1.charAt(index)>o2.charAt(index)){
						return 1;
					}
					index++;
				}
				return 0;
			}
		});
		for(String dict:d){
			int sIndex=0;
			int dIndex=0;
			while (sIndex<s.length()&&dIndex<dict.length()) {
				if(s.charAt(sIndex)==dict.charAt(dIndex)){
					sIndex++;
					dIndex++;
				}
				else{
					sIndex++;
				}
			}
			if(dIndex==dict.length()){
				return dict;
			}
		}
        return "";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FiveTwoFour four=new FiveTwoFour();
		String s="aewfafwafjlwajflwajflwafj";
		String[] d={"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
		List<String> list=new ArrayList<String>();
		for(int i=0;i<d.length;i++){
			list.add(d[i]);
		}
		System.out.println(four.findLongestWord(s, list));
	}

}
