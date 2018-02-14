public class FibIt implements  SeqIt {
    int cur1 = 0;
    int cur2 = 0;
    int last = 0;

    int count = 0;

    public FibIt(Fib inFib) {
        cur1 = inFib.firstOne;
        cur2 = inFib.firstTwo;
        last = inFib.last1;
    }

    public int next() {
        if (count == 0) {
            count++;
            return cur1;
        }
        else if (count == 1) {
            count++;
            return cur2;
        }
        int newCur = cur1 + cur2;
        cur1 = cur2;
        cur2 = newCur;
        return newCur;
    }

    public boolean hasNext() {
        if (cur1 == last && count == 0)
            return true;
        if (cur1 + cur2 <= last)
            return true;
        else
            return false;
    }
}