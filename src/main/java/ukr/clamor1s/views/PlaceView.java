package ukr.clamor1s.views;

import java.util.List;

import ukr.clamor1s.models.Place;

public class PlaceView {

	public static String convertToJson(Place place) {
		return "{\n"
				+ String.format("\t\"number\": \"%s\",\n", place.getNumber())
				+ String.format("\t\"taken\": \"%s\",\n", place.getTaken())
				+ String.format("\t\"cost\": \"%s\"\n", place.getCost())
				+ "}";
	}
	
	public static String convertArrayToJson(List<Place> places) {
		String result = "{\n";
		for (int i = 0; i < places.size(); ++i) {
			result+= String.format("\t\"%s\": \"%s\",\n", places.get(i).getNumber(), convertToJson(places.get(i)));
		}
		result+= "}";
		
		return result;
	}
	
}
