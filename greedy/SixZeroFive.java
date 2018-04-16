package greedy;

public class SixZeroFive {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n==0){
			return true;
		}
		if(flowerbed.length==1){
			if(n==1){
				return flowerbed[0]==0;
			}
			return false;
		}
		if(flowerbed.length==2){
			if(n==1){
				if(flowerbed[0]==0&&flowerbed[1]==0){
					return true;
				}
			}
			return false;
		}
		//首先判断第一个位置的情况
		if(flowerbed[0]==0&&flowerbed[1]==0){
			flowerbed[0]=1;
			n--;
		}
		for(int i=1;i<flowerbed.length-1;i++){
			if(n==0){
				break;
			}
			if(flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
				flowerbed[i]=1;
				n--;
			}
		}
		//最后判断最后一个位置
		if(flowerbed[flowerbed.length-2]==0&&flowerbed[flowerbed.length-1]==0&&n!=0){
			flowerbed[flowerbed.length-1]=1;
			n--;
		}
		return n==0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SixZeroFive five=new SixZeroFive();
		int[] flowerbed = {0,0,1,0,0};
		int n=1;
		System.out.println(five.canPlaceFlowers(flowerbed,n ));
	}

}
