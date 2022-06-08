package ukr.clamor1s.ticketBooker.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ukr.clamor1s.ticketBooker.models.CinemaModel;
import ukr.clamor1s.ticketBooker.models.Film;
import ukr.clamor1s.ticketBooker.models.Place;
import ukr.clamor1s.ticketBooker.models.Room;
import ukr.clamor1s.ticketBooker.views.CinemaView;

@RestController
public class CinemaController {

	@RequestMapping(value = "/cinema", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRooms() {
		
		CinemaModel cinema = new CinemaModel();
		
		Room room1 = new Room("Blue room", 13);
		room1.addPlace(new Place(1, 10L, false));
		room1.addPlace(new Place(2, 10L, false));
		room1.addPlace(new Place(3, 20L, true));
		room1.setFilmExecuted(new Film("Saw III", "Horror", 3600));
		cinema.addRoom(room1);
		
		Room room2 = new Room("Red room", 26);
		room2.addPlace(new Place(1, 10L, false));
		room2.addPlace(new Place(2, 10L, false));
		room2.addPlace(new Place(3, 20L, true));
		room2.addPlace(new Place(4, 40L, true));
		room2.setFilmExecuted(new Film("Jango's Redemption", "Western", 7200));
		cinema.addRoom(room2);
		
		String result = CinemaView.convertToJson(cinema);
		
//		if (cinema == null) return "{}";
		
//		System.out.println(result);
		
		return result;
	}
	
}
