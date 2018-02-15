import java.io.ObjectStreamException;
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

    AList expand() {
	      AList tempList = new AList();
	      for (Object x : array) {
	          if (x instanceof Integer)
	              tempList.add((Integer) x);
	          else if (x instanceof Seq) {
	              if (x instanceof For) {
	                  ForIt ri = new ForIt((For) x);
	                  int count = 0;
	                  int num = 10;
	                  while( ++count <= num && ri.hasNext() ) {
	                      try {
                              tempList.add(ri.next());
                          } catch (UsingIteratorPastEndException e) {
                              System.out.println("myprintb oops! caught UsingIteratorPastEndException");
                          }
                      }
                  }
                  else {
	                  FibIt fi = new FibIt((Fib) x);
                      int count = 0;
                      int num = 10;
                      while( ++count <= num && fi.hasNext() ) {
                          try {
                              tempList.add(fi.next());
                          } catch (UsingIteratorPastEndException e) {
                              System.out.println("myprintb oops! caught UsingIteratorPastEndException");
                          }
                      }
                  }
              }
	          else if (x instanceof AList)
	              tempList.add((AList) x);
          }
	      return tempList;
    }

    AList flatten() {
        AList tempList = new AList();

        return tempList;
    }
}