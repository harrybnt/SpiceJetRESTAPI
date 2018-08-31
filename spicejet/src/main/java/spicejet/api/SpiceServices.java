package spicejet.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SpiceServices {

	public ArrayList<FlightRecords> flightDetailFetch(FlightInput fInput) throws IOException {

		String orgincity = fInput.getFromCity();
		String destinationcity = fInput.getToCity();
		String DateofJouney = fInput.getDateOfJourney();
		String Adults = fInput.getAdults_Number();
		ArrayList<FlightRecords> flight_List = new ArrayList<FlightRecords>();

		try {
			Document doc = (Document) Jsoup.connect("https://book.spicejet.com/search.aspx?mode=search")
					.data("EnablePost", "True").data("triptype", "OneWay").data("origincitycode", orgincity)
					.data("destinationcitycode", destinationcity).data("fromdate", DateofJouney).data("todate", "")
					.data("adultcount", Adults).data("childcount", "0").data("infantcount", "0")
					.data("indianarmed", "0").data("studentdiscount", "0").data("SeniorCitizenDiscount", "0")
					.data("unmr", "0").data("promocodetext", "").data("voucherdiscount", "0").data("currency", "INR")
					.post();

			// System.out.println(doc);

			Elements table = ((Element) doc).select("table#availabilityTable0");
			Elements rows = table.select("tr");

			for (int i = 3; i < rows.size() - 1; i++) {
				Element row = rows.get(i);
				Elements cols = row.select("td");
				String flight_number = cols.select(".special").text().toString();
				String flight_duration = cols.select(".travel-duration").text().toString();
				String departure_time = cols.select(".departure-time").text().toString();
				String arrival_time = cols.select(".showtable-cell").text().toString();
				String price = cols.select(".fareCol1").text().toString();
				FlightRecords fr = new FlightRecords();
				fr.setFlightNumer(flight_number);
				fr.setDepartureTime(departure_time);
				fr.setArrivalTime(arrival_time);
				fr.setFlightDuration(flight_duration);

				if (Integer.parseInt(Adults) > 1) {
					String temp = price.split(" ")[0];
					String result_temp = "";
					for (int j = 0; j < temp.length(); j++) {

						if (temp.charAt(j) == ',' || temp.charAt(j) == '.')
							continue;
						else {
							result_temp += temp.charAt(j);
						}

					}
					price = result_temp;
					System.out.println(price);
					double p = Double.parseDouble(price);
					p = p * Integer.parseInt(Adults) / 100;
					price = Double.toString(p) + " INR";

				}

				fr.setPrice(price);
				flight_List.add(fr);
			}

		} catch (Exception e) {
			System.out.print(e);

		}

		return flight_List;
	}
}
