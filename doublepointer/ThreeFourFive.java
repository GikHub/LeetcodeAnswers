package doublepointer;

public class ThreeFourFive {
	public String reverseVowels(String s) {
        char[] vowels={'a','e','i','o','u','A','E','I','O','U'};
		char[] chars=new char[s.length()];
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	chars[i]=c;
        }
        int left=0;
        int right=chars.length-1;
        while (left<right) {
        	boolean isLeftFound=false;
			inner :while (!isLeftFound&&left<=right) {
	        	for(int i=0;i<vowels.length;i++){
					if(chars[left]==vowels[i]){
						isLeftFound=true;
						break inner;
					}
				}
	        	left++;
			}
        	boolean isRightFound=false;
        	inner:while (!isRightFound&&right>=left) {
	        	for(int i=0;i<vowels.length;i++){
	        		if(chars[right]==vowels[i]){
	        			isRightFound=true;
	        			break inner;
	        		}
	        	}
	        	right--;
        	}
        	if(left<right&&isLeftFound&&isRightFound){
        		char temp=chars[left];
        		chars[left]=chars[right];
        		chars[right]=temp;
        		left++;
        		right--;
        	}
		}
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<chars.length;i++){
        	buffer.append(chars[i]);
        }
        return buffer.toString();
	} 
	public static void main(String[] args) {
		ThreeFourFive five=new ThreeFourFive();
		String s="leetcode";
		System.out.println(five.reverseVowels(s));
	}

}
