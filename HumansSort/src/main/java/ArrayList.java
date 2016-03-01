public class ArrayList<T> {

    public final int MAX_AGE = 150;
    private Object[] array;
    private int count;

    public ArrayList() {
        this.array = new Object[MAX_AGE];
        for (int i = 0; i < MAX_AGE; i++){
            array[i] = null;
        }
        this.count = 0;
    }

    public void add(T element, int index) {
        this.array[index] = element;
        count++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < this.count) {
            return (T)this.array[index];
        } else throw new IllegalArgumentException();
    }

}
