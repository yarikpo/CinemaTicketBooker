package ukr.clamor1s.ticketBooker.views;

import java.util.List;

import ukr.clamor1s.ticketBooker.models.Room;

public class RoomView {

	public static String convertToJson(Room room) {
		return "{\n"
				+ String.format("\t\"roomName\": \"%s\",\n", room.getRoomName())
				+ String.format("\t\"roomSize\": \"%s\",\n", room.getRoomSize())
				+ String.format("\t\"filmExecuted\": \"%s\",\n", FilmView.convertToJson(room.getFilmExecuted()))
				+ String.format("\t\"places\": \"%s\"\n", PlaceView.convertArrayToJson(room.getPlaces()))
				+ "}";
	}
	
	public static String convertArrayToJson(List<Room> rooms) {
		String result = "{\n";
		for (int i = 0; i < rooms.size(); ++i) {
			result+= String.format("\t\"roomName\": \"%s\",\n", rooms.get(i).getRoomName());
			result+= String.format("\t\"filmExecuted\": \"%s\",\n", FilmView.convertToJson(rooms.get(i).getFilmExecuted()));
		}
		result+= "}";
		
		return result;
	}
	
}
