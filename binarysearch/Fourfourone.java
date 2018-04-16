package binarysearch;

public class Fourfourone {
	public int arrangeCoins(int n) {
		int level=1;
		int left=n;
		while(left>level){
			left-=level;
			level++;
		}
		if(left<level){
			level--;
		}
        return level;
    }
	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		Fourfourone one=new Fourfourone();
		System.out.println(one.arrangeCoins(3));
	}

}
