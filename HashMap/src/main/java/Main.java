public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.add("key", "Vlad");
        hashMap.add("key", "Test");
        hashMap.add("0", "gjno");
        hashMap.add("idx", "jgnejen");
        hashMap.add(null, "null");
        /*hashMap.delete("0");
        hashMap.delete("0");
        hashMap.delete(null);*/
        hashMap.resize();
    }
}
