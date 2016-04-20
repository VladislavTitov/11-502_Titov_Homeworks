class Heap {
    int[] data; // массив с элементами (индексация с 1, 0 - фиктивная вершина)
    int pnt = 0; // указаетель на последний элемент
    int iterations = 0;

    /* Конструктор */
    Heap(int size) {
        data = new int[size + 1];
    }

    /* Добавить элемент */
    void add(int x) {
        data[++pnt] = x;
        for (int v = pnt, p = v >> 1; p > 0 && data[p] > data[v]; swap(data, p, v), v = p, p >>= 1) {
            iterations++;
        }
    }

        /* Извлечь минимум */
    int extractMin() {
        int ret = data[1];
        swap(data, 1, pnt--);
        for (int v = 1; (v << 1) <= pnt; ) {
            int l = v << 1;
            int r = l + 1;
            if (r <= pnt && data[r] < data[l] && data[r] < data[v]) swap(data, v, v = r);
            else if (data[l] < data[v]) swap(data, v, v = l);
            else break;
            iterations++;
        }
        return ret;
    }

    private void swap(int[] a, int pos1, int pos2){
        int a1 = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = a1;
    }

    public int getIterations() {
        return iterations;
    }
}