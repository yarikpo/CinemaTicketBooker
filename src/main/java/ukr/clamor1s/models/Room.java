package ukr.clamor1s.models;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private String roomName;
	private int roomSize;
	private Film filmExecuted;
	private List<Place> places;
	
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
	
}
