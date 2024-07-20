import java.util.HashMap;

public class twosumhashmap {

public int[] twosum(int[] nums, int target){
    int n=nums.length;
    int[] ans={-1};
    HashMap<Integer,Integer> mp= new HashMap<>();
    for(int i=0; i<n; i++){
       int partner=target-nums[i];
       if(mp.containsKey(partner)){
        ans=new int[]{i,mp.get(partner)};
        return ans;
       }
       else{
        mp.put(nums[i],i);
       }
    }

return ans;



}
    
}
