// Iterate through the fib sequence
public class Fib extends Seq{
	protected int firstOne;
	protected int firstTwo;
	protected int last1;
	private static int counter = 0;
 
	public static int getCount(){
		return counter;
	}
 
  // Creates a new Iterator and returns it
  public FibIt createSeqIt(){
      return new FibIt(this);
  }
 
	public Fib(int first1, int first2, int last){
		this.firstOne = first1;
		this.firstTwo = first2;
		this.last1 = last;
		counter++;
	} // Constructor

  public int upperBound(){
			return last1; 
	} // Returns Upper Bound
 
  @Override
  public AList expand() {
    AList temp = new AList();
    FibIt iterator = this.createSeqIt();
    while(true) {
      try { // Try moving to next
        temp.add(iterator.next());
      } catch(UsingIteratorPastEndException e) {  // If you go out of bounds
        break;  // Break out of the while loop; you've already reached the end.
      }
    }
    return temp;
  } // Return expanded seq as AList

  @Override
  public AList flatten() {
    AList temp = new AList();
    temp.add(this);
    return temp;
  } // Return self for flatten
 
	@Override
	public String toString(){
		String tempFirst = String.valueOf(firstOne);
		String tempLast = String.valueOf(firstTwo);
		String valueOf =String.valueOf(last1);
		return "< " + tempFirst + ", " + tempLast + " to " + valueOf + " >";
	}
}	
	

