package ukr.clamor1s.views;

import ukr.clamor1s.models.Session;

public class SessionView {

	public static String convertToJson(Session session) {
		return "{\n"
				+ String.format("\t\"film\": \"%s\",\n", FilmView.convertToJson(session.getFilm()))
				+ String.format("\t\"startTime\": \"%s\"\n", session.getStartTime().toString())
				+ "}";
	}
}
