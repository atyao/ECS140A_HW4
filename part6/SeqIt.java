// Gives the details for ForIt and FibIt
public interface SeqIt {
    int next() throws UsingIteratorPastEndException;
    boolean hasNext();
}