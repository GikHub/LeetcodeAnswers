package doublepointer;
import java.util.ArrayList;
import java.util.List;



public class Eighteight {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0){
			for(int i=0;i<nums2.length;i++){
				nums1[i]=nums2[i];
			}
			return;
		}
		if(n==0){
			return;
		}
		int[] nums3=new int[m];
		int[] nums4=new int[n];
		for(int i=0;i<m;i++){
			nums3[i]=nums1[i];
		}
		for(int i=0;i<n;i++){
			nums4[i]=nums2[i];
		}
		List<Integer> list=new ArrayList<Integer>();
		int oneIndex=0;
        int twoIndex=0;
        while (oneIndex<nums3.length&&twoIndex<nums4.length) {
        	if(nums3[oneIndex]<nums4[twoIndex]){
        		list.add(nums3[oneIndex]);
        		oneIndex++;
        	}
        	else{
        		list.add(nums4[twoIndex]);
        		twoIndex++;
        	}
		}
        if(oneIndex>=nums3.length){
        	for(int i=twoIndex;i<nums4.length;i++){
        		list.add(nums4[i]);
        	}
        }
        else if(twoIndex>=nums4.length){
        	for(int i=oneIndex;i<nums3.length;i++){
        		list.add(nums3[i]);
        	}
        }
        int[] result=new int[list.size()];
        for(int i=0;i<result.length;i++){
        	result[i]=list.get(i);
        }
        for(int i=0;i<result.length;i++){
        	nums1[i]=result[i];
        }
    }
	public static void main(String[] args){
		int[] nums1={1,0};
		int m=1;
		int[] nums2={2};
		int n=1;
		Eighteight eight=new Eighteight();
		eight.merge(nums1, m, nums2, n);
		for(int i=0;i<nums1.length;i++){
			System.out.println(nums1[i]);
		}
	}
}
