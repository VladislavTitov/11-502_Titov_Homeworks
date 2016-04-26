public class Main {
    public static void main(String[] args) {
        int [] array = {1, 12, 23, 123, 54, 78, 78, 10, 234, 98, 287, 78};
        HashTable hashTable = new HashTable(array);
        hashTable.delete(78);
        hashTable.delete(78);
    }
}
