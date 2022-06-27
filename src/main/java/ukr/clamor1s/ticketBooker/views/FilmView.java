package ukr.clamor1s.ticketBooker.views;

import java.util.List;

import ukr.clamor1s.ticketBooker.models.Film;

public class FilmView {

	public static String convertToJson(Film film) {
		return "{\n"
				+ String.format("\t\"id\": %d,\n", film.getId())
				+ String.format("\t\"name\": \"%s\",\n", film.getName())
				+ String.format("\t\"genre\": \"%s\",\n", film.getGenre())
				+ String.format("\t\"duration\": %d\n", film.getDuration())
				+ "}";
	}
	
	public static String convertArrayToJson(List<Film> films) {
		
		String result = "[";
		
		for (int i = 0; i < films.size(); ++i) {
			result+= convertToJson(films.get(i));
			if (i < films.size() - 1) result+= ",";
		}
		
		result+= "]";
		
		return result;
	}
	
}
