// Gets the sum of the for loop
public class ForUser {
    public static int sum1(For r) {
        ForIt someFor = new ForIt(r);

        int num = 10;
        int sum = 0;
        int sumCount = 0;

        // Sum the sequence and prevent from going over num times
        while( ++sumCount <= num && someFor.hasNext() ) {
            try { // Necessary to avoid "Must be caught or declared to be thrown" error
                sum += someFor.next();
            } catch(UsingIteratorPastEndException e) { } // Do nothing; .hasNext() avoids this.
        }
        return sum;
    }
    public static int sum2(For r) {
        ForIt someFor = new ForIt(r);

        int num = 10;
        int sum = 0;
        int sumCount = 0;

        // Sum the sequence and prevent from going over num times
        while( ++sumCount <= num ) {
            try { // Try moving to next
                sum += someFor.next();
            } catch(UsingIteratorPastEndException e) {  // If you go out of bounds
                break;  // Break out of the for loop; you've already reached the end.
            }
        }
        return sum;
    }
}