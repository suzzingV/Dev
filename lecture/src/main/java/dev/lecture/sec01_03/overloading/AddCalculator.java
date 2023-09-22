package dev.lecture.sec01_03.overloading;

public class AddCalculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    //return 타입만 다르게 오버로딩 불가
//    public long add(int num1, int num2) {
//        return num1 + num2;
//    }

    public long add(long num1, long num2) {
        return num1 + num2;
    }
    public double add(double num1, double num2) {
        return num1 + num2;
    }
}
