package ukr.clamor1s.ticketBooker.models;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private long id;
	private String roomName;
	private int roomSize;
	private Film filmExecuted;
	private List<Place> places = new ArrayList<>();
	
	public Room() {}
	
	public Room(long id, String roomName, int roomSize) {
		this.id = id;
		this.roomName = roomName;
		this.roomSize = roomSize;
	}
	
	public void addPlace(Place place) {
		places.add(place);
	}
	
	public void setFilmExecuted(Film film) {
		this.filmExecuted = film;
	}
	
	public String getRoomName() {
		return this.roomName;
	}
	
	public int getRoomSize() {
		return this.roomSize;
	}
	
	public Film getFilmExecuted() {
		return this.filmExecuted;
	}
	
	public List<Place> getPlaces() {
		return new ArrayList<>(this.places);
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
