package ukr.clamor1s.ticketBooker.models;

public class Film {
	
	private long id;
	private String name;
	private String genre;
	private int duration;
	
	public Film() {}
	
	public Film(long id, String name, String genre, int duration) {
		
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.duration = duration;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String getGenre() {
		
		return this.genre;
	}
	
	public int getDuration() {
		
		return this.duration;
	}
	
	public long getId() {
		
		return this.id;
	}
	
	public void setId(long id) {
		
		this.id = id;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setGenre(String genre) {
		
		this.genre = genre;
	}
	
	public void setDuration(int duration) {
		
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + " name: " + this.name + " genre: " + this.genre + " duration: " + this.duration;
	}
	
}
