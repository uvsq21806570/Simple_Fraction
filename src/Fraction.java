public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public String toString() {
        if (den == 0)
            return "NaN ";
        return this.num + "/" + this.den;
    }
}