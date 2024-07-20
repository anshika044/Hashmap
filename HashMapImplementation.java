import java.util.LinkedList;

public class HashMapImplementation {

    static class myhashmap<K,V>{

        public static final int DEFAULT_CAPACITY =4;
        public static final float DEFAULT_LOAD_FACTOR=0.75f;
        private class node{

            K key;
            V value;
            public node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n;//no of entries in map
        private LinkedList<node>[] buckets;

        private void initbuckets(int N){//N - capacity/size of bucket array
           buckets=new LinkedList[N];
           for( int i=0; i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
           }
        }

        private int HashFunc(K key){
           int hc =key.hashCode(); 
           return (Math.abs(hc)) % buckets.length;
        }



        //traverse the ll and looks for a node with key,if found it returns its index otherwise it returns null
        private int searchInBucket(LinkedList<node> ll, K key){
            for(int i=0; i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }

        private void rehash(){
        LinkedList<node>[] oldbuckets=buckets;
        initbuckets(oldbuckets.length*2);
        n=0;
        for(var buckets:oldbuckets){
            for(var node: buckets){
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
            return(n*1.0f)/buckets.length;
        }

        public int size(){//retuen the no of entries
          return n;
        }

        public void put(K key, V value){//insert/update
        int bi= HashFunc(key);
        LinkedList<node> currbucket= buckets[bi];
        int ei =searchInBucket(currbucket,key);
        if(ei==-1){//entry index //key does't exist,we have to insert a new node
            node Node =new node(key,value);
            currbucket.add(Node);
            n++;
        }else{//update case
            node currnode=currbucket.get(ei);
            currnode.value=value;

        }
        if(n>=buckets.length*DEFAULT_LOAD_FACTOR){
            rehash();
        }
        
        }

        public V get(K key){
        int bi =HashFunc(key);
        LinkedList<node> currbucket = buckets[bi];
        int ei=searchInBucket(currbucket, key);
        if(ei!=-1){//key exists
           node currnode= currbucket.get(ei);
           return currnode.value;
        }

        //you can use else too but as if is already there so no need just write return
        //key doesn't exist
        return null;
    }

        public V remove(K key){
        int bi=HashFunc(key);
        LinkedList<node> currbucket= buckets[bi];
        int ei= searchInBucket(currbucket, key);
        if(ei!=-1){
         node currnode=currbucket.get(ei);
         V val =currnode.value;
         currbucket.remove(ei);
         n--;
         return val; 
        }
        //key doesn't exist
        return null;

        }

    }

    public static void main(String[] args) {
        myhashmap<String, Integer> mp = new myhashmap<>();
        System.out.println("testing put");
        mp.put("a", 1);
        mp.put("b", 2);
        mp.put("c", 3);
        mp.put("d", 4);
        mp.put("y", 0);
        System.out.println("testing size "+ mp.size());
        mp.put("c",9);
        System.out.println(mp.size());

        //testing get
        System.out.println(mp.get("a"));
        System.out.println(mp.get("b"));
        System.out.println(mp.get("c"));
        System.out.println(mp.get("o"));

        //testing remove

        System.out.println(mp.remove("c"));//9
        System.out.println(mp.remove("c"));//null
        System.out.println(mp.size());

        //
        System.out.println("capacity "+ mp.capacity());
        System.out.println("load "+ mp.load());

    }
    
}
