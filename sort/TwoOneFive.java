package sort;
/**
 * 快速选择算法(数组中找出第K大的数)
 * @author Administrator
 *
 */
public class TwoOneFive {
	/**
	 * 对于索引pivotIndex，将数组划分为如此：索引小于pivotIndex的数都比nums[pivot]小，索引大于pivotIndex的数都比nums[pivot]大
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 * @param pivotIndex
	 * @return
	 */
	private int partition(int[] nums,int startIndex,int endIndex,int pivotIndex){
		if(startIndex==endIndex){
			return startIndex;
		}
		if(pivotIndex!=startIndex){
			swap(nums,startIndex,pivotIndex);
		}
		int left=startIndex;
		int right=endIndex;
		while (left<right) {
			inner: while(left<right){
				if(nums[right]>nums[pivotIndex]){
					break inner;
				}
				right--;
			}
			inner: while(left<right){
				if(nums[left]<nums[pivotIndex]){
					break inner;
				}
				left++;
			}
			if(left==right){
				swap(nums,startIndex,left);
			}
			else{
				swap(nums,left,right);
			}
		}
		return left;
	}
	/**
	 * 在数组nums中交换索引index1和index2的数字
	 * @param nums
	 * @param index1
	 * @param index2
	 */
	private void swap(int[] nums,int index1,int index2){ 
		int temp=nums[index1];
		nums[index1]=nums[index2];
		nums[index2]=temp;
	}
	/**
	 * 找到第K大的数
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
        if(nums.length==1&&k==1){
        	return nums[0];
        }
        int startIndex=0;
        int endIndex=nums.length-1;
        int pivot=startIndex;
        int middle=partition(nums,startIndex,endIndex,pivot);
        while (middle+1!=k) {
			if(middle+1<k){
				startIndex=middle+1;
				pivot=startIndex;
				middle=partition(nums,startIndex,endIndex,pivot);
			}
			else{
				endIndex=middle-1;
				pivot=startIndex;
				middle=partition(nums, startIndex, endIndex, pivot);
			}
			
		}
		return nums[middle];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoOneFive five=new TwoOneFive();
		int[] nums={3,2,1,5,6,4};
		int k=2;
		System.out.println(five.findKthLargest(nums, k));
	}

}
