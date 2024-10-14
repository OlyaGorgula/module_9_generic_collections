public class MyHashMap<K, V> {
    private int sizeBuckets = 16;
    private int sizeMap = 0;
    private Node<K, V>[] tableBuckets = new Node[sizeBuckets];

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static class Node<K, V> {// entry
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getIndexBucketsByKey(K k){
        int hash = hash(k);
        int index = getIndexBuckets(hash);
        return index;
    }

    private int getIndexBuckets(int hash){
        int index = (sizeBuckets - 1) & hash;
        return index;
    }

    private Node<K, V>[] node(K k) {
        Node<K, V> firstNode = tableBuckets[getIndexBucketsByKey(k)];
        Node<K, V> x = firstNode;
        Node<K, V> prev = null;
        while (x != null){
            if (x.key.equals(k)){
                return new Node[]{prev, x};
            }
            prev = x;
            x = x.next;
        }
        return new Node[]{prev, null};
    }

    private void addValue(K k, V v) {
        Node<K, V>[] arrayNode = node(k);
        Node<K, V> prevNode = arrayNode[0];
        Node<K, V> currentNode = arrayNode[1];
        if (currentNode == null){
            final Node<K, V> lastNode = prevNode;
            final Node<K, V> newNode = new Node<>(hash(k), k, v, null);
            if (lastNode == null) {
                tableBuckets[getIndexBuckets(newNode.hash)] = newNode;
            }
            else
                lastNode.next = newNode;
            sizeMap++;
        }else {
            currentNode.value = v;
        }
    }

    //додає елемент в кінець
    public void put(K key, V value){
        addValue(key, value);
    }

    private V delNode(Node<K, V>[] arrayNode) {
        Node<K, V> prevNode = arrayNode[0];
        Node<K, V> currentNode = arrayNode[1];
        if (currentNode == null) return null;

        final V element = currentNode.value;
        final Node<K, V> next = currentNode.next;
        if (prevNode != null){
            prevNode.next = next;
        }else {
            tableBuckets[getIndexBuckets(currentNode.hash)] = next;
        }

        sizeMap --;
        return element;
    }

    //видаляє елемент із вказаним індексом
    public V remove(K key){
        return delNode(node(key));
    }

    //очищає колекцію
    public void clear(){
        for (int i = 0; i < tableBuckets.length; ++i)
            tableBuckets[i] = null;
        sizeMap = 0;
    }

    //повертає розмір колекції
    public int size(){
        return sizeMap;
    }

    // повертає елемент за індексом
    public V get(K key){
        Node<K, V>[] arrayNode = node(key);
        Node<K, V> node = arrayNode[1];
        if (node == null) return null;
        return node.value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<tableBuckets.length; i++){
            Node<K, V> firstNode = tableBuckets[i];
            if (firstNode == null) continue;
            result.append(i+"//");
            Node<K, V> x = firstNode;
            while (x != null){
                result.append(x.key + "=" + x.value);
                x = x.next;
                result.append(", ");
            }
        }
        if (result.length() > 1){
            String sign = ""+result.charAt(result.length()-2);
            if (sign.equals(",")) result.delete(result.length()-2, result.length());
        }
        return  "myHashMap={" + result + '}';
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        System.out.println("Add key = 1 value = 10");
        myHashMap.put(1,10);
        System.out.println("Add key = 1 value = 100");
        myHashMap.put(1,100);
        System.out.println("Add key = 2 value = 20");
        myHashMap.put(2,20);
        System.out.println("Add key = 300000000 value = 30");
        myHashMap.put(300000000,30);
        System.out.println("Added "+myHashMap);
        System.out.println("key 1 = "+myHashMap.get(1));
        System.out.println("key 300000000 = "+myHashMap.get(300000000));
        System.out.println("key 2 = "+myHashMap.get(2));
        System.out.println("remove key 1 = "+myHashMap.remove(1) +" "+ myHashMap+" size = "+myHashMap.size());
        System.out.println("remove key 2 = "+myHashMap.remove(2) +" "+ myHashMap+" size = "+myHashMap.size());
        System.out.println("remove key 300000000 = "+myHashMap.remove(300000000) +" "+ myHashMap+" size = "+myHashMap.size());
        myHashMap.put(4,40);
        myHashMap.put(5,50);
        myHashMap.put(51,511);
        myHashMap.put(6,60);
        System.out.println("Added "+myHashMap);
        System.out.println("size = "+myHashMap.size());
        myHashMap.clear();
        System.out.println("Clear "+myHashMap);

    }
}
