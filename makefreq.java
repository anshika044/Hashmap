import java.util.*;
public class makefreq {

    public static void main(String[] args) {
        int[] arr ={1,4,2,5,1,4,4,6,4,4,5};
        Map<Integer,Integer> freq=new HashMap<>();
        for(int el: arr){
            if(!freq.containsKey(el)){
                freq.put(el,1);
            }
            else{
                freq.put(el,freq.get(el)+1);
            }
        }
        System.out.println("frequency map");
        System.out.println(freq.entrySet());

        int maxfreq =0, anskey=-1;

        // for(var e : freq.entrySet()){
        //     if(e.getValue() > maxfreq){
        //         maxfreq=e.getValue();
        //         anskey=e.getKey();
        //     }
        // }

        for(var key:freq.keySet()){
            if(freq.get(key)> maxfreq){
                maxfreq=freq.get(key);
                anskey=key;
            }
        }
        System.out.printf("%d having the key %d times",anskey,maxfreq);
    }
    
}
