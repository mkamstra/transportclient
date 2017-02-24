package nl.martijnkamstra.transport.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TransportListRequest {
    private double latitude;
    private double longitude;
    private LocalDateTime requestedtime;
    private String error = "";
    private Station station;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getRequestedtime() {
        return requestedtime;
    }

    public void setRequestedtime(String requestedtime) {
        try {
            this.requestedtime = LocalDateTime.parse(requestedtime, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException ex) {
            // Fall back option is to take the current time
            setError(getError() + " *** Requested time could not be parsed, using the current time instead; error was: " + ex);
            this.requestedtime = LocalDateTime.now();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(String station) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            int startOfJson = station.indexOf("{");
            station = station.substring(startOfJson);
            this.station = mapper.readValue(station, Station.class);
        } catch (IOException ex) {
            setError(getError() + " *** Requested station could not be parsed: " + ex);
            this.station = null;
        } catch (StringIndexOutOfBoundsException ex) {
            // Not really an error as this is to occur when None was selected
            this.station = null;
        }
    }

    @Override
    public String toString() {
        return "TransportListRequest{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", requestedtime=" + requestedtime +
                ", error='" + error + '\'' +
                ", station='" + station + '\'' +
                '}';
    }
}
