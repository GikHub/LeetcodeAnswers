package doublepointer;

public class Sixeightzero {
	public boolean validPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while (left<right) {
			if(s.charAt(left)!=s.charAt(right)){
				return isPalindrome(s,left,right-1)||isPalindrome(s,left+1,right);
			}
			left++;
			right--;
		}
		return true;
    }
	/**
	 * 判断一个字符串是不是回文字符串
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s,int left,int right){
		int start=left;
		int end=right;
		while (start<end) {
			if(s.charAt(start)==s.charAt(end)){
				start++;
				end--;
				continue;
			}
			return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sixeightzero zero=new Sixeightzero();
		String s="abca";
		System.out.println(zero.validPalindrome(s));
	} 
}
