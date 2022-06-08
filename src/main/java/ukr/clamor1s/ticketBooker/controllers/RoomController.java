package ukr.clamor1s.ticketBooker.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ukr.clamor1s.ticketBooker.models.Film;
import ukr.clamor1s.ticketBooker.models.Place;
import ukr.clamor1s.ticketBooker.models.Room;
import ukr.clamor1s.ticketBooker.views.RoomView;

@RestController
public class RoomController {

	@RequestMapping(value = "/cinema/{roomName}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRoom(@PathVariable String roomName) {
		
		Room room1 = new Room("Blue room", 13);
		room1.addPlace(new Place(1, 10L, false));
		room1.addPlace(new Place(2, 10L, false));
		room1.addPlace(new Place(3, 20L, true));
		room1.setFilmExecuted(new Film("Saw III", "Horror", 3600));
		
		String result = RoomView.convertToJson(room1);
		
		System.out.println(roomName);
//		System.out.println(result);
		
		return result;
	}
	
}
