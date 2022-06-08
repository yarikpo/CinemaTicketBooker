package ukr.clamor1s.ticketBooker.models;

public class Place {

	private int number;
	private long cost;
	private boolean taken;
	
	public Place() {}
	
	public Place(int number, long cost, boolean taken) {
		this.number = number;
		this.cost = cost;
		this.taken = taken;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public long getCost() {
		return this.cost;
	}
	
	public boolean getTaken() {
		return this.taken;
	}
	
}
