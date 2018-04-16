package greedy;
import java.util.Arrays;


public class Fourfivefive {
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int sIndex=0;
        for(int i=0;i<g.length;i++){
        	while (sIndex<s.length&&g[i]>s[sIndex]) {
				sIndex++;
			}
        	if(sIndex<s.length&&g[i]<=s[sIndex]){
        		result++;
        		sIndex++;
        	}
        }
        return result;
    }

	
	
	public static void main(String[] args) {
		Fourfivefive five=new Fourfivefive();
		int[] g={1,2};
		int[] s={1,2,3};
		System.out.println(five.findContentChildren(g, s));
	}

}
