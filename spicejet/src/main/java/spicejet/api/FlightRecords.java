package spicejet.api;

public class FlightRecords {

	private String FlightNumer;
	private String DepartureTime;
	private String ArrivalTime;
	private String Price;
	private String Airline = "Spicejet";
	private String FlightDuration;

	public String getFlightDuration() {
		return FlightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		FlightDuration = flightDuration;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getFlightNumer() {
		return FlightNumer;
	}

	public void setFlightNumer(String flightNumer) {
		FlightNumer = flightNumer;
	}

}
