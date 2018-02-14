public class FibIt implements  SeqIt {
    private Fib fib1;
    public FibIt(Fib inFib) {
        this.fib1 = inFib;
    }

    public int next() {

        return 0;
    }

    public boolean hasNext() {

        return false;
    }
}