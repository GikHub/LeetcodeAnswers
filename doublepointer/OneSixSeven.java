package doublepointer;

public class OneSixSeven {
	
	public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
		int left=0;
        int right=numbers.length-1;
        int sum=0;
        while (left<=right) {
        	sum=numbers[left]+numbers[right];
        	if(sum==target){
        		result[0]=left+1;
        		result[1]=right+1;
        		break;
        	}
        	if(sum>target){
        		right--;
        	}
        	if(sum<target){
        		left++;
        	}
		}
        return result;
    }
	public static void main(String[] args) {
		OneSixSeven seven=new OneSixSeven();
		int[] numbers={2, 7, 11, 15};
		int target=9;
		int[] result=seven.twoSum(numbers, target);
		System.out.println(result[0]+":"+result[1]);
	}

}
