public class HashTableGeneric<K, V> {
    private class HashNode<NodeKey, NodeValue> {
        private NodeKey key;
        private NodeValue value;
        private HashNode<NodeKey, NodeValue> next;

        public HashNode(NodeKey key, NodeValue value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableGeneric() {
        chainArray = new HashNode[M];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTableGeneric(int M) {
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (chainArray[index] == null) {
            chainArray[index] = new HashNode<>(key, value);
        } else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = new HashNode<>(key, value);
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    chainArray[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < M; i++) {
            chainArray[i] = null;
        }
        size = 0;
    }
    
    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print("Index " + i + ": ");
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        HashTableGeneric<String, Integer> table = new HashTableGeneric<>();
        table.put("Lasy", 23);
        table.put("mary", 24);
        table.put("Jim", 25);
        table.put("Mell", 23);
        table.put("Karin", 24);
        table.put("Blem", 25);
        table.printTable();
        System.out.println("Size: " + table.size());
        System.out.println("Is Empty: " + table.isEmpty());
        System.out.println("Contains: " + table.contains(23));
        System.out.println("Get Key: " + table.getKey(23));
        System.out.println("Get: " + table.get("Lasy"));
        System.out.println("Remove: " + table.remove("Lasy"));
        table.printTable();
    }
    
}
