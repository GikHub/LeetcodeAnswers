package binarysearch;

public class Fivefourzero {
	public int singleNonDuplicate(int[] nums) {
	    int l = 0, h = nums.length - 1;
	    while(l < h) {
	        int m = l + (h - l) / 2;
	        if(m % 2 == 1) m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
	        if(nums[m] == nums[m + 1]) l = m + 2;
	        else h = m;
	    }
	    return nums[l];
	}
	/*public int singleNonDuplicate(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int start=0;
		int end=nums.length-1;
		int middle=start;
		while (start<=end) {
			middle=start+(end-start)/2;
			if(middle==0){
				if(nums[middle]!=nums[middle+1]){
					return nums[middle];
				}
			}
			if(middle==nums.length-1){
				if(nums[middle-1]!=nums[middle]){
					return nums[middle];
				}
			}
			if(nums[middle+1]!=middle&&nums[middle-1]!=middle){
				return nums[middle];
			}
			if(nums[middle+1]==nums[middle]){
				start=middle;
				if(end-start==1){
					return nums[start-1];
				}
			}
			if(nums[middle-1]==nums[middle]){
				end=middle;
				if(end-start==1){
					return nums[end+1];
				}
			}
		}
		return -1; 
    }*/
	public static void main(String[] args) {
		Fivefourzero zero=new Fivefourzero();
		int[] nums={1,1,2,3,3,4,4,8,8};
		System.out.println(zero.singleNonDuplicate(nums));
	}

}
