import java.util.*;

public class practiceimplementation {

    static class myhashmap<K,V>{

        private static final int DEFAULT_CAPACITY=4;
        private static final float DEFAULT_LOAD_CAPACITY=0.75f;
        private class node{
            K key;
            V value;
            public node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }


        private int n;
        private LinkedList<node>[] buckets;
        
        private void initbuckets(int N){
            buckets=new LinkedList[N];
            for(int i=0; i<buckets.length;i++){
                buckets[i]=new LinkedList<>();//EMPTY
            }
        }

        private int hashfucn(K key){
            int hc= key.hashCode();
            return (Math.abs(hc))%buckets.length;
        }


        //traverses
        private int searchinbucket(LinkedList<node> ll, K key){
            for(int i=0; i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }

        private  void rehash(){
            LinkedList<node>[] oldbucket=buckets;
            initbuckets(oldbucket.length*2);
            n=0;
            for(var buckets:oldbucket){
                for(var node:buckets){
                    put(node.key,node.value);
                }
            }
        }

        
        public myhashmap(){
            initbuckets(DEFAULT_CAPACITY);
        }


        public int capacity(){
            return buckets.length;
        }

        public float load(){
            return (n*1.0f)/buckets.length;
        }


        public int size(){
            return n;
        }

        public  void put(K key, V value){
            int bi=hashfucn(key);
            LinkedList<node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket, key);
            if(ei==-1){//insert
                node newone=new node(key, value);
                currbucket.add(newone);
                n++;
            }else{//update
                node currnode=currbucket.get(ei);
                currnode.value=value;//here second value is input parameter value
            }
            //rehash
            if(n>=buckets.length*DEFAULT_LOAD_CAPACITY){
            rehash();
            }
        }


        public V get(K key){
            int bi=hashfucn(key);
            LinkedList<node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket, key);
            if(ei!=-1){
                node currnode=currbucket.get(ei);
                return currnode.value;
            }
            return null;
        }

        public V remove(K key){
            int bi=hashfucn(key);
            LinkedList<node> currbucket=buckets[bi];
            int ei=searchinbucket(currbucket, key);
            if(ei!=-1){
                node currnode=currbucket.get(ei);
                V val=currnode.value;
                currbucket.remove(ei);
                n--;
                return val;
            }
            return null;
        }










    }
    
    public static void main(String[] args) {
        myhashmap<String, Integer> mp= new myhashmap<>();
        System.out.println("testing put");
        mp.put("a", 1);
        mp.put("b", 3);
        mp.put("c", 8);
        System.out.println(mp.size());
        mp.put("c", 9);
        System.out.println(mp.size());


        System.out.println(mp.get("c"));
    }
}
