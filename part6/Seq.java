// the Seq base class

public abstract class Seq {
	private static int counter = 0;
	public abstract int upperBound();
	public abstract SeqIt createSeqIt();
	public static int getCount(){
		return counter;
	};
	public Seq(){
		counter++; 
	}
}

