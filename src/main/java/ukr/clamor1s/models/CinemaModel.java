package ukr.clamor1s.models;

import java.util.ArrayList;
import java.util.List;

public class CinemaModel {
	
	private List<Room> cinemaRooms = new ArrayList<>();
	private TimeTable timeTable;
	
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
