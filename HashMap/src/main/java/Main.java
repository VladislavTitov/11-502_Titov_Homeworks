public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("key", "Vlad");
        hashMap.put("key", "Test");
        hashMap.put("0", "gjno");
        hashMap.put("idx", "jgnejen");
        hashMap.put(null, "null");
        hashMap.delete("0");
        hashMap.delete("0");
        hashMap.delete(null);

    }
}
