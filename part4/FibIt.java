// Iterates through the fib sequence
public class FibIt implements  SeqIt {
    int cur1 = 0;
    int cur2 = 0;
    int last = 0;

    // Used for the first two elements
    int count = 0;

    public FibIt(Fib inFib) {
        cur1 = inFib.firstOne;
        cur2 = inFib.firstTwo;
        last = inFib.last1;
    }

    // Iterate to next fibonacci sequence element
    public int next() {
        // Check if fib will go past the end number
        if (!(hasNext())) {
            System.err.println("FibIt called past end");
            System.exit(1);
        }

        // On the first two counts just return the first two
        // elements in the sequence
        if (count == 0) {
            count++;
            return cur1;
        }
        else if (count == 1) {
            count++;
            return cur2;
        }

        // Move cur1 and cur2 forward in the sequence
        int newCur = cur1 + cur2;
        cur1 = cur2;
        cur2 = newCur;

        return newCur;
    }

    // Check if there is a next element in the sequence
    public boolean hasNext() {
        if (cur1 == last && count == 0)
            return true;
        if (cur1 + cur2 <= last)
            return true;
        else
            return false;
    }
}