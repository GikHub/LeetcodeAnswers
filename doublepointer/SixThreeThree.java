package doublepointer;

public class SixThreeThree {
	public boolean judgeSquareSum(int c) {
		if(c==0||c==1){
			return true;
		}
		int left=0;
		int right=(int)Math.floor(Math.sqrt(c));
		int result=0;

		while (left<=right) {
			result=left*left+right*right;
			if(result==c){
				return true;
			}
			if(result<c){
				left++;
			}
			else if(result>c){
				right--;
			}
			
		}
		return false;
    }
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SixThreeThree three=new SixThreeThree();
		System.out.println(three.judgeSquareSum(100));
	}

}
