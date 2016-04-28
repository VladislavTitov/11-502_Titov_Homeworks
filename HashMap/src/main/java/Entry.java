public class Entry<E, K> {

    private E data;
    private K key;
    private int hash;
    private Entry<E, K> next;

    public Entry() {
    }

    public Entry(E data, K key, int hash, Entry next) {
        this.data = data;
        this.key = key;
        this.hash = hash;
        this.next = next;
    }

    public void removeNext(){
        if (next == null){
            return;
        }else{
            this.next = next.next;
        }
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public K getKey() {
        return key;
    }

    public Entry<E, K> getNext() {
        return next;
    }

    public int getHash() {
        return hash;
    }
}
