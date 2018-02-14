public class ForIt implements SeqIt {
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
    }

    public int next() {
        switch (direction) {
            case POSITIVE:
                if (curNum < endNum)
                    curNum = initNum + (stepNum * count);
                break;
            case NEGATIVE:
                if (curNum > endNum)
                    curNum = initNum + (stepNum * count);
                break;
            default: break;
        }
        count++;

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