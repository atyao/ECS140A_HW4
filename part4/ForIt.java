public class ForIt implements SeqIt {
    For forRef;
    private Dir direction;
    private enum Dir {
        POSITIVE,
        NEGATIVE,
        ZERO
    }
    int initNum = 0;
    int endNum = 0;
    int stepNum = 0;

    int curNum = 0;
    int count = 0;

    public ForIt(For inFor) {
        int stepDir = inFor.step1;

        if (stepDir > 0)
            direction = Dir.POSITIVE;
        else if (stepDir < 0)
            direction = Dir.NEGATIVE;
        else
            direction = Dir.ZERO;

        initNum = inFor.first1;
        endNum = inFor.last1;
        stepNum = inFor.step1;

        curNum = initNum;

        forRef = inFor;
        forRef.sum1 = 0;
    }

    public int next() {
        if (!(hasNext())) {
            System.err.println("ForIt called past end");
            System.exit(1);
        }

        curNum = initNum + (stepNum * count);
        count++;

        forRef.sum1 += curNum;
        return curNum;
    }

    public boolean hasNext() {
        switch (direction) {
            case POSITIVE:
                if ((initNum + (stepNum * count)) > endNum)
                    return false;
                break;
            case NEGATIVE:
                if ((initNum + (stepNum * count)) < endNum)
                    return false;
                break;
            case ZERO:
                return true;
            default:
                break;
        }
        return true;
    }
}