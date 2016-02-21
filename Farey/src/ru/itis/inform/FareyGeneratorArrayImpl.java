package ru.itis.inform;

public class FareyGeneratorArrayImpl {

    public FareyGeneratorArrayImpl(int n) {
        this.generate(n);
    }

    private void generate(int n){

        Rational[] RationalNumbers = new Rational[200];
        RationalNumbers[0] = new Rational(0, 1);
        RationalNumbers[1] = new Rational(1, 1);
        int k = 2;

        for (int i = 2; i <= n; i++){
            int j = 0;

            while (j <= k-2){
                if((RationalNumbers[j].getB() + RationalNumbers[j+1].getB()) == i){

                    int u = RationalNumbers[j].getA() + RationalNumbers[j+1].getA();
                    int o = RationalNumbers[j].getB() + RationalNumbers[j+1].getB();

                    for (int m = 100; m > j+1; m--){
                        RationalNumbers[m] = RationalNumbers[m-1];
                    }

                    RationalNumbers[j+1] = new Rational(u, o);

                    j++;
                    k++;
                }
                j++;
            }
        }

        for (int i = 0; i < 100; i++){
            System.out.print(RationalNumbers[i].getA() + "/" + RationalNumbers[i].getB() + ", ");
        }
    }
}
