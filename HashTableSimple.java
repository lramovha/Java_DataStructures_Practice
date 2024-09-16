import java.util.HashMap;
import java.util.Map;

public class HashTableSimple {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> fruitsInventory = new HashMap<>();

        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        fruitsInventory.put("Apple", 10);
        fruitsInventory.put("Banana", 15);
        fruitsInventory.put("Orange", 20);

        System.out.println("HashMap: " + map);
        System.out.println("Fruits Inventory: " + fruitsInventory);
        System.out.println("Apple in stock: " + fruitsInventory.get("Apple"));
        System.out.println("Banana in stock: " + fruitsInventory.get("Banana"));
        System.out.println("Orange in stock: " + fruitsInventory.get("Orange"));

        System.out.println("Is HashMap empty? " + map.isEmpty());
        System.out.println("Size of HashMap: " + map.size());

        map.remove("Bob");
        System.out.println("HashMap after removing Bob: " + map);
        
        
    }
}
