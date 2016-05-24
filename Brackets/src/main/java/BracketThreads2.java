public class BracketThreads2 implements Runnable{
    Thread thread;
    private Store store;
    int n;
    String name;

    public BracketThreads2(Store store, int number) {
        this.store = store;
        n = number;
        name = "Thread" + n;
        thread = new Thread(this, name);
        thread.start();
    }


    public void run() {
        if (n == 0){
            store.add(store.getHead());
        }
        while (store.lengthOfBrackets != 0) {
            char bracket = store.getHead();
            if (store.empty()){
                store.add(bracket);
                continue;
            }
            if (store.lookHead() == 40 & bracket == 41 || store.lookHead() == 91 & bracket == 93 || store.lookHead() == 123 & bracket == 125){
                store.delete();
                continue;
            }
            store.add(bracket);
        }
    }
}
