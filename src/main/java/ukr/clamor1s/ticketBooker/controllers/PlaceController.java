package ukr.clamor1s.ticketBooker.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ukr.clamor1s.ticketBooker.models.Place;
import ukr.clamor1s.ticketBooker.views.PlaceView;

@RestController
public class PlaceController {

	@RequestMapping(value = "/cinema/{roomName}/{placeNumber}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPlace(@PathVariable("roomName") String roomName,
							@PathVariable("placeNumber") int placeNumber) {
		
		Place place = new Place(4, 55L, false);
		String result = PlaceView.convertToJson(place);
		
		System.out.println(roomName);
		System.out.println(placeNumber);
		return result;
	}
	
}
