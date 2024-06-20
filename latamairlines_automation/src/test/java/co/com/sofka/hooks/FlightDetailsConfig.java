package co.com.sofka.hooks;

import co.com.sofka.models.FlightDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class FlightDetailsConfig {
    @DataTableType
    public FlightDetails mapToFlightDetails(Map<String, String> flightData) {
        return new FlightDetails(
                flightData.get("from"),
                flightData.get("to"),
                Integer.parseInt(flightData.get("daysAhead")),
                Integer.parseInt(flightData.get("nAdults")),
                Integer.parseInt(flightData.get("nChildren"))
        );
    }
}
