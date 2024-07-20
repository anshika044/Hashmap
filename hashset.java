import java.util.*;
public class hashset {

    public static void main(String[] args) {
        HashSet<String> st=new HashSet<>();
        st.add("james");
        st.add("bill");
        st.add("james");
        System.out.println(st);
        System.out.println(st.contains("james"));//true
        System.out.println(st.size());//2
        st.remove("james");
        System.out.println(st.contains("james"));//false
        System.out.println(st.size());//1
        st.add("mark");
        for(String s:st){
            System.out.println(s);
        }

    }
    
}
