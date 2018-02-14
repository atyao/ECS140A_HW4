public class ForUser {
    public static int sum1(For r) {
        ForIt someFor = new ForIt(r);
        int sumCount = 0;
        int num = 10;
        int sum = 0;
        while( ++sumCount <= num && someFor.hasNext() ) {
            sum += someFor.next();
        }
        return sum;
    }
}