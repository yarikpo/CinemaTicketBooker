package ukr.clamor1s.ticketBooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ukr.clamor1s.ticketBooker.dao.FilmDao;
import ukr.clamor1s.ticketBooker.models.Film;
import ukr.clamor1s.ticketBooker.views.FilmView;

@RestController
public class FilmController {
	
	@Autowired
	private FilmDao filmDao;

	@RequestMapping(value = "/cinema/{roomName}/film", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFilm(@PathVariable("roomName") String roomName) {
		
		Film film = new Film(1, "Jango's Redemption", "Western", 7200);
		String result = FilmView.convertToJson(film);
		
		System.out.println(roomName);
		return result;
	}
	
	@RequestMapping(value = "/cinema/films/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFilmById(@PathVariable("id") long id) {
		
		if (filmDao == null) return "{\"message\": \"FilmDao Not Found!\"}";
		
		if (filmDao.get(id).isEmpty()) return "{\"message\": \"Not Found!\"}";
		
		return FilmView.convertToJson(filmDao.get(id).get());
	}
	
	@RequestMapping(value = "/cinema/films", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllFilms() {
		
		if (filmDao == null) return "{\"message\": \"FilmDao Not Found!\"}";
		
		if (filmDao.getAll() == null) return "{\"message\": \"Not Found!\"}";
		
		return FilmView.convertArrayToJson(filmDao.getAll());
	}
	
	@RequestMapping(value = "/cinema/films", method = RequestMethod.POST)
	public void postFilm(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "genre", required = false) String genre,
			@RequestParam(value = "duration", required = false) Integer duration) {
		
		if (filmDao == null) return;
		
		Film film = new Film();
		film.setName(name);
		film.setGenre(genre);
		film.setDuration((int)duration);
		
		try {
			filmDao.save(film);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/cinema/films/{id}", method = RequestMethod.DELETE)
	public void deleteFilmById(@PathVariable("id") long id) {
		
		if (filmDao == null) return;
		
		filmDao.delete(id);
	}
	
	
	
	@RequestMapping(value = "/cinema/films/{id}", method = RequestMethod.POST) // Needs to be patch or put request method
	public void changeFilmById(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "genre", required = false) String genre,
			@RequestParam(value = "duration", required = false) Integer duration,
			@PathVariable("id") long id) {
		
		if (filmDao == null) return;
		
		Film film = new Film();
		film.setId(id);
		if (name != null) film.setName(name);
		if (genre != null) film.setGenre(genre);
		if (duration != null) film.setDuration((int)duration);
		
		filmDao.update(film);
	}
	
}


















