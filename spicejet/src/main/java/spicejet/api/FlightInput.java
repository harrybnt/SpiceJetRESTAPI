package spicejet.api;

public class FlightInput {

	private String FromCity;
	private String ToCity;
	private String DateOfJourney;
	private String Adults_Number;

	public String getAdults_Number() {
		return Adults_Number;
	}

	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}

	public void setToCity(String toCity) {
		ToCity = toCity;
	}

	public void setDateOfJourney(String dateOfJourney) {
		DateOfJourney = dateOfJourney;
	}

	public void setAdults_Number(String adults_Number) {
		Adults_Number = adults_Number;
	}

	public String getFromCity() {
		return FromCity;
	}

	public String getToCity() {
		return ToCity;
	}

	public String getDateOfJourney() {
		return DateOfJourney;
	}
}
