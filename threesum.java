import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threesum {

    public List<List<Integer>> threeSum(int[] nums) {
    Set<Integer> st=new HashSet<>();
    Arrays.sort(nums);

    for(int i=0; i<nums.length-2; i++){
        int start=i+1;
        int end=nums.length-1;


        while(start<end){
            int sum=nums[i]+nums[start]+nums[end];
            if(sum==0){
                st.add(Arrays.asList(nums[i],nums[start],nums[end]));
                
                start++;
                end--;
            }
        }
    }
    
    
}
}