package ru.itis.inform;

public class Rational {
    private int a;
    private int b;

    public Rational(int a, int b) {
        this.a = a;
        if(b != 0){
            this.b = b;
        }else throw new IllegalArgumentException();

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
