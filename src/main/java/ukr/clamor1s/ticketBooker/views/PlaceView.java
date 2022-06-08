package ukr.clamor1s.ticketBooker.views;

import java.util.List;

import ukr.clamor1s.ticketBooker.models.Place;

public class PlaceView {

	public static String convertToJson(Place place) {
		return "{\n"
				+ String.format("\t\"number\": %d,\n", place.getNumber())
				+ String.format("\t\"taken\": %b,\n", place.getTaken())
				+ String.format("\t\"cost\": %d\n", place.getCost())
				+ "}";
	}
	
	public static String convertArrayToJson(List<Place> places) {
		String result = "[\n";
		for (int i = 0; i < places.size(); ++i) {
//			result+= "\t{\n";
			result+= convertToJson(places.get(i));
			if (i != places.size() - 1) result+= ",";
//			if (i < places.size() - 1) result+= String.format("\t\"%s\": %s,\n", places.get(i).getNumber(), convertToJson(places.get(i)));
//			if (i == places.size() - 1) result+= String.format("\t\"%s\": %s\n", places.get(i).getNumber(), convertToJson(places.get(i)));
//			result+= "\t}\n";
		}
		result+= "\t]";
		
		return result;
	}
	
}
