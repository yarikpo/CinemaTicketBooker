package ukr.clamor1s.ticketBooker.models;

import java.util.ArrayList;
import java.util.List;

public class CinemaModel {
	
	private List<Room> cinemaRooms = new ArrayList<>();
	private TimeTable timeTable;
	
	public CinemaModel() {}
	
	
	public void addRoom(Room room) {
		this.cinemaRooms.add(room);
	}
	
	public TimeTable getTimeTable() {
		return this.timeTable;
	}
	
	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}
	
	public List<Room> getCinemaRooms() {
		return new ArrayList<Room>(this.cinemaRooms);
	}
}
