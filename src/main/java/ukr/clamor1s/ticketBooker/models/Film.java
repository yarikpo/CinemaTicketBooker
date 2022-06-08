package ukr.clamor1s.ticketBooker.models;

public class Film {
	
	private String name;
	private String genre;
	private int duration;
	
	public Film() {}
	
	public Film(String name, String genre, int duration) {
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
	
}
