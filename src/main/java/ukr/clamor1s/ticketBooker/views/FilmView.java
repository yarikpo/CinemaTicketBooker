package ukr.clamor1s.ticketBooker.views;

import ukr.clamor1s.ticketBooker.models.Film;

public class FilmView {

	public static String convertToJson(Film film) {
		return "{\n"
				+ String.format("\t\"name\": \"%s\",\n", film.getName())
				+ String.format("\t\"genre\": \"%s\",\n", film.getGenre())
				+ String.format("\t\"duration\": %d\n", film.getDuration())
				+ "}";
	}
	
}
