public class VectorCode {
    private int length;
    private int[] vector;
    private LinkedListForVector vectorList = new LinkedListForVector();

    public VectorCode(int[] vector) {
        this.vector = vector;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != 0) {
                vectorList.addLast(i, vector[i]);
            }
        }
        this.length = vector.length;
    }

    public VectorCode() {
    }

    public LinkedListForVector getVectorList() {
        return vectorList;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] decode(){
        Node v = vectorList.getFirst();
        int[] decodeVector = new int[vectorList.getLast().getNumber() + 1];
        for (int i = 0; i < vectorList.getLast().getNumber() + 1; i++){
            if (i == v.getNumber()){
                decodeVector[i] = v.getValue();
                v = v.getNext();
            }else{
                decodeVector[i] = 0;
            }
        }
        this.vector = decodeVector;
        return decodeVector;
    }

    public void insert(int pos, int element){
        Node f = vectorList.getFirst();
        int i = 0;
        if (pos < 0){
            System.out.println("Illegal position");
            return;
        }else if (pos < vectorList.getFirst().getNumber()){
            vectorList.addFirst(pos, element);
            length++;
            return;
        }else if (pos > vectorList.getLast().getNumber()){
            vectorList.addLast(pos, element);
            length++;
            return;
        }else while(i < vectorList.getCount()){
            if (pos == f.getNumber()){
                f.setValue(element);
                return;
            }
            f = f.getNext();
            i++;
        }
    }

    public void printList(){
        vectorList.show();
    }

    public void delete(int pos){
        if (pos > vectorList.getLast().getNumber() || pos < vectorList.getFirst().getNumber()){
            return;
        }
        Node f = vectorList.getFirst();
        int i = 0;
        while (i < vectorList.getCount()){
            if (pos == f.getNumber()){
                vectorList.remove(pos);
                return;
            }
            f = f.getNext();
            i++;
        }
    }

    public int scalarProduct(VectorCode v){
        Node f1 = vectorList.getFirst();
        Node f2 = v.vectorList.getFirst();
        int scProd = 0;
        int i = 0;
        int j = 0;
        while (i < vectorList.getCount() & j < v.vectorList.getCount()){
            if (f1.getNumber() > f2.getNumber()){
                f2 = f2.getNext();
                j++;
            }else if (f1.getNumber() < f2.getNumber()){
                f1 = f1.getNext();
                i++;
            }else if (f1.getNumber() == f2.getNumber()){
                scProd += f1.getValue()*f2.getValue();
                f1 = f1.getNext();
                f2 = f2.getNext();
                i++;
                j++;
            }
        }
        return scProd;
    }

    public VectorCode sum(VectorCode v){
        VectorCode vectorSum = new VectorCode();
        Node f1 = vectorList.getFirst();
        Node f2 = v.vectorList.getFirst();
        vectorSum.setLength(length > vectorSum.getLength() ? length : vectorSum.getLength());
        int i = 0;
        int j = 0;
        while (i < vectorList.getCount() & j < v.vectorList.getCount()){
            if (f1.getNumber() < f2.getNumber()){
                vectorSum.vectorList.addLast(f1.getNumber(), f1.getValue());
                f1 = f1.getNext();
                i++;

            }else if(f1.getNumber() > f2.getNumber()){
                vectorSum.vectorList.addLast(f2.getNumber(), f2.getValue());
                f2 = f2.getNext();
                j++;

            }else if (f1.getNumber() == f2.getNumber()) {
                int a = f1.getValue() + f2.getValue();
                vectorSum.vectorList.addLast(f1.getNumber(), a);
                f1 = f1.getNext();
                f2 = f2.getNext();
                i++;
                j++;
            }
        }
        while (i < vectorList.getCount()){
            vectorSum.vectorList.addLast(f1.getNumber(), f1.getValue());
            f1 = f1.getNext();
            i++;
        }
        while (j < v.vectorList.getCount()){
            vectorSum.vectorList.addLast(f2.getNumber(), f2.getValue());
            f2 = f2.getNext();
            j++;
        }
        return vectorSum;
    }

    public VectorCode vectorSum(){
        VectorCode resVec = new VectorCode();
        resVec.setLength(length);
        decode();
        //int c = length;
        int sum = 0;
        int j = 0;
        for (int i = length -1; i >= 0; i--){
            sum += vector[i];
            resVec.vectorList.addLast(j++, sum);
        }
        return resVec;
    }

    public void mult(int a, int c){
        Node f = vectorList.getFirst();
        int i = 0;
        while (i < vectorList.getCount()){
            if (f.getValue() == a){
                f.setValue(f.getValue()*c);
            }
            f = f.getNext();
            i++;
        }
    }
}
