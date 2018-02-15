import java.util.*;

public class Integer implements AListEntry {
    int value;
    
    public Integer(int v) {
        value = v;
    } // Wrapper Constructor
    
    @Override
    public AList expand() {
        AList temp = new AList();
        temp.add(value);
        return temp;
    } // Returns self for expand
    
    @Override
    public AList flatten() {
        AList temp = new AList();
        temp.add(value);
        return temp;
    } // Returns self for flatten
    
    @Override
    public String toString() {
        return String.valueOf(value);
    } // toString for printing
} // Integer wrapper