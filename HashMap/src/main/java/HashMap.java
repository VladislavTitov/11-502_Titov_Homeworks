public class HashMap<E, K> {
    private Entry<E, K>[] table;
    private int capacity;
    private final double LOAD_FACTOR = 0.75;
    private double threshold;
    private int size;

    public HashMap(){
        this.capacity = 16;
        this.table = new Entry[capacity];
        this.size = 0;
        this.threshold = capacity*LOAD_FACTOR;
    }

    public void add(K key, E element){
        put(key, element, this.table);
    }

    private void put(K key, E element, Entry<E, K>[] table){
        if (key == null){
            putForNullKey(element, table);
            return;
        }
        int hash = hash(key.hashCode());
        int index = indexFor(hash, capacity);
        if (table[index] == null){
            table[index] = new Entry<E, K>(element, key, hash, null);
        }else {
            Entry<E, K> entry = table[index];
            while (entry != null){
                if (entry.getHash() == hash && (entry.getKey() == key || key.equals(entry.getKey()))){
                    entry.setData(element);
                    if (size >= threshold){
                        resize();
                    }
                    return;
                }
                entry = entry.getNext();
            }
            addEntry(key, element, hash, index);
        }
        size++;
        if (size >= threshold){
            resize();
        }
    }

    private void putForNullKey(E element, Entry<E, K>[] table){
        if (table[0] == null){
            table[0] = new Entry<E, K>(element, null, 0, null);
        }else{
            Entry<E, K> entry = table[0];
            while (entry.getNext() != null){
                if (entry.getKey() == null){
                    entry.setData(element);
                    if (size >= threshold){
                        resize();
                    }
                    return;
                }
                entry = entry.getNext();
            }
            addEntry(null, element, 0, 0);
        }
        size++;
        if (size >= threshold){
            resize();
        }
    }

    private void addEntry(K key, E element, int hash, int index){
        Entry<E, K> bufEntry = table[index];
        table[index] = new Entry<E, K>(element, key, hash, bufEntry);
    }

    public void delete(K key){
        if (key == null){
            deleteForNullKey();
            return;
        }
        int hash = hash(key.hashCode());
        int index = indexFor(hash, capacity);
        if (table[index] == null){
            System.out.println("Don't have this element!");
            return;
        }else if (table[index].getHash() == hash && (table[index].getKey() == key || key.equals(table[index].getKey()))){
            table[index] = table[index].getNext();
            size--;
            return;
        }else{
            Entry<E, K> entry = table[index];
            while (entry.getNext() != null){
                if (entry.getNext().getHash() == hash && (entry.getNext().getKey() == key || key.equals(entry.getNext().getKey()))){
                    entry.removeNext();
                    size--;
                    return;
                }
                entry = entry.getNext();
            }
        }
        System.out.println("Don't have this element!");
    }

    private void deleteForNullKey(){
        if (table[0] == null){
            System.out.println("Don't have this element!");
            return;
        }else if (table[0].getKey() == null){
            table[0] = table[0].getNext();
            size--;
            return;
        }else{
            Entry<E, K> entry = table[0];
            while (entry.getNext() != null){
                if (entry.getNext().getKey() == null){
                    entry.removeNext();
                    size--;
                    return;
                }
                entry = entry.getNext();
            }
        }
    }

    private int hash(int hashCode){
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public int getSize() {
        return size;
    }

    public void resize(){
        this.capacity *= 2;
        Entry<E, K>[] newTable = new Entry[this.capacity];
        this.table = transfer(newTable);
        threshold *= 2;

    }

    private Entry<E, K>[] transfer(Entry<E, K>[] newTable){
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null){
                Entry itEntry = table[i];
                while (itEntry != null){
                    put((K)itEntry.getKey(), (E) itEntry.getData(), newTable);
                    size--;
                    itEntry = itEntry.getNext();
                }
            }
        }
        return newTable;
    }
}
