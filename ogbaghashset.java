import java.util.*;

public class ogbaghashset {

    static int maxnumbersontable(int[] bag){
        HashSet<Integer> table=new HashSet<>();
        int max=0;
        for(int i=0; i<bag.length; i++){
            int num=bag[i];
            if(table.contains(num)){
                table.remove(num);
            }else{
                table.add(num);
                max=Math.max(max, table.size());
            }
        }
        return max;

    }

public static void main(String[] args) {
    int[] nums={1,1,2,2,3,3};
    System.out.println(maxnumbersontable(nums));
}
    
}
