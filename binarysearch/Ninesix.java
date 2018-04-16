package binarysearch;

public class Ninesix {
	public int mySqrt(int x) {
		if(x<=1){
			return x;
		}
		int left=1;
		int right=x;
		int middle=1;
		while(right-left>1){
			middle=left+(right-left)/2;
			int result=x/middle;
			if(result>middle){
				left=middle;
			}
			else if(result<middle){
				right=middle;
			}
			else{
				return result;
			}
		}
		return left;
        
    }	
	public static void main(String[] args) {
		Ninesix ninesix=new Ninesix();
		System.out.println(ninesix.mySqrt(8));
	}

}
