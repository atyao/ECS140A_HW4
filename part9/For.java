public class For extends Seq{
	protected int first1;
	protected int last1;
	protected int step1;
	private static int counter = 0;
 
	public static int getCount(){
		return counter;
	}
 
  // Creates a new Iterator and returns it
  public ForIt createSeqIt() {
    return new ForIt(this);
  }
 
	public For(int first, int last, int step){
		first1 = first;
		last1 = last;
		step1 = step;
		toString();
		counter++;
	} // Constructor
 
	public int upperBound(){
		if (step1>0)
			return last1;
		else 
			return first1;  
	} // Returns UpperBound
  
  @Override
  public AList expand() {
    AList temp = new AList();
    ForIt iterator = this.createSeqIt();
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
		String tempFirst = String.valueOf(first1);
		String tempLast = String.valueOf(last1);
		String valueOf =String.valueOf(step1);
		return "{ " + tempFirst + " to " + tempLast + " by " + valueOf + " }";
	}
}	
	