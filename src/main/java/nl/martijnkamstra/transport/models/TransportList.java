package nl.martijnkamstra.transport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class represents the JSON that is received from the transport REST API. It contains a list of transport options
 * with real-time departure times for different lines on the selected station. For each requested location a station
 * name together with a list of transport info models is returned. These transport info models objects contain the line
 * name (or number), the destination, and both the scheduled and expected departure times.
 */
@JsonIgnoreProperties
public class TransportList {
    private String station;
    private TransportInfo transportInfo;

    public TransportList() {}

    public TransportList(String station, TransportInfo transportInfo) {
        this.station = station;
        this.transportInfo = transportInfo;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public TransportInfo getTransportInfo() {
        return transportInfo;
    }

    public void setTransportInfo(TransportInfo transportInfo) {
        this.transportInfo = transportInfo;
    }

    @Override
    public String toString() {
        return "TransportList{" +
                "station='" + station + '\'' +
                ", transportInfo=" + transportInfo +
                '}';
    }


}
