public class ArrayList<T> {

    public final int MAX_SIZE = 150;
    private int size;
    private Object[] array;
    private int count;

    public ArrayList() {
        this.array = new Object[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++){
            array[i] = null;
        }
        this.count = 0;
    }

    public ArrayList(int size){
        this.array = new Object[size];
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        this.size = size;
        this.count = 0;
    }

    public void add(T element, int index) {
        this.array[index] = element;
        count++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < MAX_SIZE) {
            return (T)this.array[index];
        } else throw new IllegalArgumentException();
    }

}
