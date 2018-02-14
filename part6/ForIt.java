// Iterates through the for loop
public class ForIt implements SeqIt {
    // Determines direction for loop is iterating
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
        // Check if step is negative or positive
        int stepDir = inFor.step1;
        if (stepDir > 0)
            direction = Dir.POSITIVE;
        else if (stepDir < 0)
            direction = Dir.NEGATIVE;
        else
            direction = Dir.ZERO;

        // Copy values to class
        initNum = inFor.first1;
        endNum = inFor.last1;
        stepNum = inFor.step1;
        curNum = initNum;
    }

    // Iterate through loop by one step
    public int next() {
        // Check if for loop will go past the end number
        if (!(hasNext())) {
            System.err.println("ForIt called past end");
            System.exit(1);
        }

        curNum = initNum + (stepNum * count);
        count++;

        return curNum;
    }

    // Check if there is a next element in the loop
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