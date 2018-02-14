// Gets the sum of the for loop
public class ForUser {
    public static int sum1(For r) {
        ForIt someFor = new ForIt(r);

        int num = 10;
        int sum = 0;
        int sumCount = 0;
        try {
            // Sum the sequence and prevent from going over num times
            while( ++sumCount <= num && someFor.hasNext() ) {

                sum += someFor.next();
            }
            return sum;
        }catch (UsingIteratorPastEndException e){
            System.out.println("oops2! caught UsingIteratorPastEndException");
        }
        return sum;
    }
}