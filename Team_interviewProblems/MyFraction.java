package Team_interviewProblems;

public class MyFraction {
    private int numerator, denominator;

    MyFraction(int[] arr) {
        if (arr[1] == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        if (arr.length != 2) throw new IllegalArgumentException("The array must be size 2.");
        numerator = arr[0];
        denominator = arr[1];
        makeReducedFraction(numerator, denominator);
    }

    private void makeReducedFraction(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        numerator /= a;
        denominator /= a;

    }

    @Override
    public String toString() {
        if (numerator == 0)
            return "0";
        return numerator + "/" + denominator;
    }
}