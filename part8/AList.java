import java.util.*; // For ArrayList

public class AList{
    ArrayList<Object> array = new ArrayList<Object>();
    
    public void add(Seq s) {
        array.add(s);
    } // Adds a Sequence to the ArrayList
    
    public void add(AList a) {
        array.add(a);
    } // Adds another AList to the ArrayList
    
    public void add(int i) {
        array.add(new Integer(i));
    } // Wraps Integer and adds to the ArrayList
    
    public AList expand() {
        AList temp = new AList();
        for (Object x : array) {  // Iterate through all current objects
            if(x instanceof For) {  // If it's a For, expand it
                For y = (For)x;  // Typecast and create an iterator
                ForIt iterator = y.createSeqIt();
                while(true) {
                    try { // Try moving to next
                        temp.add(iterator.next());
                    } catch(UsingIteratorPastEndException e) {  // If you go out of bounds
                        break;  // Break out of the while loop; you've already reached the end.
                    }
                }
            } else if(x instanceof Fib) {  // If it's a Fib, expand it
                Fib y = (Fib)x;  // Typecast and create an iterator
                FibIt iterator = y.createSeqIt();
                while(true) {
                    try { // Try moving to next
                        temp.add(iterator.next());
                    } catch(UsingIteratorPastEndException e) {  // If you go out of bounds
                        break;  // Break out of the while loop; you've already reached the end.
                    }
                }
            } else if(x instanceof Integer) {  // If it's an Integer, just add it.
                temp.add((Integer)x);
            } else { // It's an AList, recursively expand those too.
                AList y = (AList)x;
                y = y.expand();
                temp.add(y);
            }
        }
        return temp;
    } // Expands all Sequences in the ArrayList and returns a copy of the result
    
    public AList flatten() {
        AList temp = new AList();
        for (Object x : array) {  // Iterate through all current objects
            if(x instanceof AList) {  // If it's an AList, flatten it
                AList y = (AList)x;  // Typecast to avoid not applicable error
                y = y.flatten();  // Recurisvely flatten inner ALists
                for(Object z : y.array) {  // Then add them all to the result
                    if(z instanceof For)  // Typecasting to avoid not applicable error
                        temp.add((For)z);
                    else if (z instanceof Fib)
                        temp.add((Fib)z);
                    else if (z instanceof AList)
                        temp.add((AList)z);
                    else if (z instanceof Integer)
                        temp.add((Integer)z);
                }
            } else {  // We just add non-ALists
                if(x instanceof For)  // Typecasting to avoid not applicable error
                    temp.add((For)x);
                else if (x instanceof Fib)
                    temp.add((Fib)x);
                else if (x instanceof Integer)
                    temp.add((Integer)x);
            }
        }
        return temp;
    } // Flattens all ALists in the ArrayList and returns a copy of the result
    
    @Override
	  public String toString() {
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