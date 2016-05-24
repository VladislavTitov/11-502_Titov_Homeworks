public class Main {
    public static void main(String[] args) throws InterruptedException{
        String strWithBrackets = "(())()(()()";
        char[] arrayWithBrackets = strWithBrackets.toCharArray();
        Store store = new Store(strWithBrackets);
        /*BracketThreads bt1 = new BracketThreads(store, 0, arrayWithBrackets);
        BracketThreads bt2 = new BracketThreads(store, 1, arrayWithBrackets);
        bt1.thread.join();
        bt2.thread.join();*/

        BracketThreads2 bt1 = new BracketThreads2(store, 0);
        BracketThreads2 bt2 = new BracketThreads2(store, 1);

        System.out.println(store.getStack());
    }
}