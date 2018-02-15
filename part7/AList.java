import java.util.*; // For ArrayList

public class AList{
    private ArrayList<Object> array = new ArrayList<Object>();
    
    public void add(Seq s) {
        array.add(s);
    } // Adds a Sequence to the ArrayList
    
    public void add(AList a) {
        array.add(a);
    } // Adds another AList to the ArrayList
    
    public void add(int i) {
        array.add(new Integer(i));
    } // Wraps Integer and adds to the ArrayList
    
    @Override
	  public String toString(){
		    String temp = "[";
        boolean empty = true; // If empty, requires 2 spaces
        
        for (Object x : array) {
            empty = false;
            temp += " ";
            temp += x.toString();
        } // Iterate through and print each; also set off empty
        
        if(empty) { temp += " ";} // Will add extra space if empty
        temp += " ]";
        return temp;
	  } // Prints to string
}