package greedy;

public class Threenineone {

	 public boolean isSubsequence(String s, String t) {
		 int currentIndex=-1;
		 for(int i=0;i<s.length();i++){  //sµÄÖ¸Õë
			 currentIndex=t.indexOf(s.charAt(i),currentIndex+1);
			 if(currentIndex==-1){
				 return false;
			 }
		 }
		 return true;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Threenineone one=new Threenineone();
		String s="leeeeeetcode";
		String t="lyyyeyyyeyyyeyyytyyyyyycyyyoyyydyyye";
		//String t="yyyyylyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyycyyyyyyyyyyyyyyyyyyyyyyoyyyyyyyyyyyyyyyyyyyydyyyyyyyyyyyyyyyye";
		System.out.println(one.isSubsequence(s,t));
	}

}
