import java.util.*;


public class method {



static void hashmapmethods(){
//syntax
Map<String, Integer> mp=new HashMap<>();
//adding elements
mp.put("anshika",21);
mp.put("mohit",22);
mp.put("mahika",21);
mp.put("vaibhav",22);
mp.put("bhaiya",27);

//getting value of a key from the hashmap
System.out.println(mp.get("anshika"));
System.out.println(mp.get("mona"));

//changing/updating value of a key in the hashmap
mp.put("mohit", 23);
System.out.println(mp.get("mohit"));


//remove a pair from hashmap
System.out.println(mp.remove("vaibhav"));
System.out.println(mp.remove("riya"));

//checking if key is in the map
System.out.println(mp.containsKey("anshika")); //true
System.out.println(mp.containsKey("vaibhav")); //false

//adding a new entry only if the new key doesn't exist already
mp.putIfAbsent("yashika", 25); // will enter
mp.putIfAbsent("mohit", 23); //will not enter

//get all keys in the hashmap
System.out.println(mp.keySet());

//get all values in the hashmap
System.out.println(mp.values());

//get all the entries in the hashmap
System.out.println(mp.entrySet());

//traverse all entries of hashmap-multiple methods
for(String Key: mp.keySet()){
    System.out.printf("Age of %s is %d\n",Key,mp.get(Key));
}

System.out.println();

for(Map.Entry<String , Integer> e: mp.entrySet()){
    System.out.printf("Age is %s is %d\n", e.getKey(),e.getValue());
}

System.out.println();

for(var e: mp.entrySet()){
    System.out.printf("Age is %s is %d\n", e.getKey(),e.getValue());
}





}
    public static void main(String[] args) {
        hashmapmethods();
    }
}
