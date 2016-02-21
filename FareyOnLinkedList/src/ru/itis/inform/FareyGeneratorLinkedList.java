package ru.itis.inform;

public class FareyGeneratorLinkedList {

    LinkedList<Rational> rationalList = new LinkedList<>();

    public FareyGeneratorLinkedList(int n) {
        this.generate(n);
    }

    private void generate(int n){

        Rational z = new Rational(0, 1);
        Rational a = new Rational(1, 1);

        rationalList.add(a);
        rationalList.add(z);


        for (int i = 2; i <= n; i++){

            while(rationalList.iterator.hasNext()){
                if (rationalList.iterator.hasPrevious()) {
                    int denominator = rationalList.iterator.peekPrevious().getB() + rationalList.iterator.peekNext().getB();

                    if (denominator == i) {

                        int numerator = rationalList.iterator.peekPrevious().getA() + rationalList.iterator.peekNext().getA();
                        Rational fraction = new Rational(numerator, denominator);
                        rationalList.iterator.insert(fraction);

                        if (rationalList.iterator.hasNext()) {
                            rationalList.iterator.next();
                        }
                    }
                }

                if (rationalList.iterator.hasNext()) {
                    rationalList.iterator.next();
                }
            }
            rationalList.iterator.back();
        }
    }

    public void showSetFarey(){

        while (rationalList.iterator.hasNext()){
            System.out.println(rationalList.iterator.peekNext().getA() + "/" + rationalList.iterator.peekNext().getB() + "; ");
        }
    }
}
