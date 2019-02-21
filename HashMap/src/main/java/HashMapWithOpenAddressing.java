/*
* This class to work with hash maps with
* a method to deprivation of the collision of "open addressing"
* without the delete method.
*/

public class HashMapWithOpenAddressing<K, V> implements HashTable<K, V> {
    private Pair<K, V>[] hashTable;
    private int size = 0;
    private float workload;

    public HashMapWithOpenAddressing() {
        hashTable = new Pair[16];
        workload = hashTable.length * 0.75f;
    }

    public boolean put(K key, V value) {
        if(size + 1 >= workload){
            workload *= 2;
            increaseSizeHashTable();
        }

        int index = hash(key);
        Pair<K, V> tempPair = new Pair<>(key, value);
        if(hashTable[index] == null){
            return simpleAdd(index, tempPair);
        }

        for(int i = index + 1; i != index ; i = (i + 1) % hashTable.length){
            if(hashTable[i] == null){
                return simpleAdd(i, tempPair);
            }
        }
        return false;
    }
    private void increaseSizeHashTable(){
        Pair<K, V>[] oldHashTable = hashTable;
        hashTable = new Pair[oldHashTable.length * 2];
        size = 0;
        for(Pair<K, V> tempPair : oldHashTable){
            if(tempPair != null){
                put(tempPair.getKey(), tempPair.getValue());
            }
        }
    }
    private boolean simpleAdd(int index, Pair<K, V> pair){
        hashTable[index] = pair;
        size += 1;
        return true;
    }
    public V get(K key) {
        int index = hash(key);

        if(hashTable[index].getKey() == key){
            return hashTable[index].getValue();
        }

        for(int i = index + 1; i != index; i = (i + 1) % hashTable.length){
            if(hashTable[i].getKey() != key){
                return hashTable[i].getValue();
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    private int hash(K key){
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }
}
