package ukr.clamor1s.ticketBooker.models;

public class Place {

	private long id;
	private int number;
	private long cost;
	private boolean taken;
	
	public Place() {}
	
	public Place(long id, int number, long cost, boolean taken) {
		this.id = id;
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
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
