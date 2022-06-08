package ukr.clamor1s.views;

import ukr.clamor1s.models.CinemaModel;

public class CinemaView {

	public static String convertToJson(CinemaModel cinema) {
		return "{\n"
				+ String.format("\t\"cinemaRooms\": \"%s\",\n", RoomView.convertArrayToJson(cinema.getCinemaRooms()))
				+ String.format("\t\"timeTable\": \"%s\"\n", "null")
				+ "}";
	}
	
}
