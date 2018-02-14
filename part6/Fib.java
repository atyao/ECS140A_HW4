// Iterate through the fib sequence
public class Fib extends Seq {
    protected int firstOne;
    protected int firstTwo;
    protected int last1;
    private static int counter = 0;

    public static int getCount() {
        return counter;
    }

    public FibIt createSeqIt(){
        return new FibIt(this);
    }

    public Fib(int first1, int first2, int last) {
        this.firstOne = first1;
        this.firstTwo = first2;
        this.last1 = last;
        counter++;

    }

    public int upperBound() {
        return last1;
    }

    @Override
    public String toString() {
        String tempFirst = String.valueOf(firstOne);
        String tempLast = String.valueOf(firstTwo);
        String valueOf = String.valueOf(last1);
        return "< " + tempFirst + ", " + tempLast + " to " + valueOf + " >";
    }
}	


