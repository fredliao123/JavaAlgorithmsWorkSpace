public class Date implements Comparable<Date>{

	private final int year;
	private final int month;
	private final int day;
	
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public int compareTo(Date that) {
		// TODO Auto-generated method stub
		if(this.year > that.year) return +1;
		if(this.year < that.year) return -1;
		//.....
		return 0;
	}
	
}