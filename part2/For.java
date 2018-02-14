public class For extends Seq{
	protected int first1;
	protected int last1;
	protected int step1;
	public For(int first, int last, int step){
		first1 = first;
		last1 = last;
		step1 = step;
		toString();
	}
	public int upperBound(){
		if (step1>0)
			return last1;
		else 
			return first1;  
	}

	@Override
	public String toString(){
		String tempFirst = String.valueOf(first1);
		String tempLast = String.valueOf(last1);
		String valueOf =String.valueOf(step1);
		return "{ " + tempFirst + " to " + tempLast + " by " + valueOf + " }";
	}
}	
	