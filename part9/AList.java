import java.util.*; // For ArrayList

public class AList implements AListEntry{
    ArrayList<AListEntry> array = new ArrayList<AListEntry>();
    private boolean isAList = false; // Boolean to prevent flattening in expand
    
    public void add(int i) {
        array.add(new Integer(i));
    } // Adds an Integer to the ArrayList
    
    public void add(AListEntry a) {
        array.add(a);
    } // Adds a For, Fib, Integer, or AList to the ArrayList
    
    public AList expand() {
        AList temp = new AList();
        temp.isAList = true;  // Marks this AList as an actual AList
        for (AListEntry x : array) {  // Iterate through all current AListEntrys
            AList temp2 = x.expand();  // Recursively expand
            if(temp2.isAList)  // If this is an actual AList
                temp.add(temp2);  // Add without flattening
            else
                for(AListEntry y : temp2.array)  // Else print individual contents
                    temp.add(y);
        }
        return temp;
    } // Expands all Sequences in the ArrayList and returns a copy of the result
    
    public AList flatten() {
        AList temp = new AList();
        for (AListEntry x : array) {  // Iterate through all current AListEntrys
            AList temp2 = x.flatten();  // Recursively flatten
            for(AListEntry y : temp2.array)  // Always flatten everything
                temp.add(y);
        }
        return temp;
    } // Flattens all ALists in the ArrayList and returns a copy of the result
    
    @Override
	  public String toString() {
		    String temp = "[";
        boolean empty = true; // If empty, requires 2 spaces
        
        for (AListEntry x : array) {
            empty = false;
            temp += " ";
            temp += x.toString();
        } // Iterate through and print each; also set off empty
        
        if(empty) { temp += " ";} // Will add extra space if empty
        temp += " ]";
        return temp;
	  } // Prints to string
}