package ukr.clamor1s.ticketBooker.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ukr.clamor1s.ticketBooker.models.Film;
import ukr.clamor1s.ticketBooker.views.FilmView;

@RestController
public class FilmController {

	@RequestMapping(value = "/cinema/{roomName}/film", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFilm(@PathVariable("roomName") String roomName) {
		
		Film film = new Film("Jango's Redemption", "Western", 7200);
		String result = FilmView.convertToJson(film);
		
		System.out.println(roomName);
		return result;
	}
	
}
