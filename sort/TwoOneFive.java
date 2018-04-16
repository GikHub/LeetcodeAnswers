package sort;
/**
 * ����ѡ���㷨(�������ҳ���K�����)
 * @author Administrator
 *
 */
public class TwoOneFive {
	/**
	 * ��������pivotIndex�������黮��Ϊ��ˣ�����С��pivotIndex��������nums[pivot]С����������pivotIndex��������nums[pivot]��
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
	 * ������nums�н�������index1��index2������
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
	 * �ҵ���K�����
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
