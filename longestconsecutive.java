import java .util.*;
public class longestconsecutive {

    public int longestconsecutivee(int[] nums){
      HashSet<Integer> st= new HashSet<>();
      for(int num:nums){
        st.add(num);
      }
 
      int maxstreak=0;
      for(int num:st){
        if(!st.contains(num-1)){//starting point mil gya
         int currnum=num;//1
         int currstreak=1;

         while(st.contains(currnum+1)){
            currstreak++;
            currnum++;
         }
         maxstreak=Math.max(maxstreak, currstreak);
        }
      }

      return maxstreak;








    }
    
}
