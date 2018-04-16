package greedy;

public class Sixsixfive {
	public boolean checkPossibility(int[] nums) {
		int changeChance=1;
		if(nums.length==1){
			return true;
		}
		if(nums.length==2){
			return true;
		}
		if(nums[1]<nums[0]){
			int temp=nums[1];
			nums[1]=nums[0];
			if(nums[1]>nums[2]){
				nums[1]=temp;
				nums[0]=nums[1];
			}
			changeChance--;
		}
		for(int i=2;i<nums.length-1;i++){
			if(nums[i]<nums[i-1]){
				if(changeChance>0){
					int temp=nums[i];
					//修改后一个数
					nums[i]=nums[i-1];
					if(nums[i]>nums[i+1]){
						nums[i]=temp;
						nums[i-1]=nums[i];
						if(nums[i-1]<nums[i-2]){
							return false;
						}
					}
					//修改前一个数
					changeChance--;
				}
				else{
					return false;
				}
			}
		}
		//检查最后一个数
		if(nums[nums.length-1]<nums[nums.length-2]){
			if(changeChance>0){
				nums[nums.length-1]=nums[nums.length-2];
				changeChance--;
			}
			else{
				return false;
			}
		}
		return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sixsixfive five=new Sixsixfive();
		int[] nums={4,2,3};
		System.out.println(five.checkPossibility(nums));
	}

}
