public class BracketThreads implements Runnable{
    Thread thread;
    private Store store;
    char[] array;
    int n;
    String name;

    public BracketThreads(Store store, int number, char[] array) {
        this.store = store;
        this.array = array;
        n = number;
        name = "Thread" + n;
        thread = new Thread(this, name);
        thread.start();
    }


    public void run() {
        if (n == 0){
            store.add(array[n]);
            n += 2;
        }
        for (int i = n; i < array.length; i += 2) {
            char bracket = array[i];
            if (store.empty()){
                store.add(bracket);
                continue;
            }
            if (store.lookHead() == 40 & bracket == 41 || store.lookHead() == 91 & bracket == 93 || store.lookHead() == 123 & bracket == 125){
                store.delete();
                System.out.println(i + "i after continue");
                continue;
            }
            System.out.println(i + "i before continue");
            store.add(bracket);
        }
    }
}
