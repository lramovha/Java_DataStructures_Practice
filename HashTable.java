public class HashTable {
    private static final int TABLE_SIZE = 10;
    private int [] table;

    public HashTable() {
        table = new int[TABLE_SIZE];
    }
    
    public int hash(String key) {
        return key.hashCode() % TABLE_SIZE;
    }

    public void put(String key, int value) {
        int index = hash(key);
        table[index] = value;
    }

    public int get(String key) {
        int index = hash(key);
        return table[index];
    }

    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("John", 123456);
        hashTable.put("Jane", 234567);
        hashTable.put("Ramovha", 781568);
        hashTable.put("Lasy", 345678);
        hashTable.put("Mash", 365464);
        
        hashTable.printTable();
    }

}
