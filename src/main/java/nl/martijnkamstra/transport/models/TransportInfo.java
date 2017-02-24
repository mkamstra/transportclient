package nl.martijnkamstra.transport.models;

/**
 * A container for the models related to a single transport, i.e. for a single line at a single stop
 */
public class TransportInfo {
    private String line;
    private String destination;
    private String scheduled_departure_time;
    private String expected_departure_time;

    public TransportInfo() {}

    public TransportInfo(String line, String destination, String scheduled_departure_time, String expected_departure_time) {
        this.line = line;
        this.destination = destination;
        this.scheduled_departure_time = scheduled_departure_time;
        this.expected_departure_time = expected_departure_time;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getScheduled_departure_time() {
        return scheduled_departure_time;
    }

    public void setScheduled_departure_time(String scheduled_departure_time) {
        this.scheduled_departure_time = scheduled_departure_time;
    }

    public String getExpected_departure_time() {
        return expected_departure_time;
    }

    public void setExpected_departure_time(String expected_departure_time) {
        this.expected_departure_time = expected_departure_time;
    }

    @Override
    public String toString() {
        return "TransportInfo{" +
                "line='" + line + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduled_departure_time='" + scheduled_departure_time + '\'' +
                ", expected_departure_time='" + expected_departure_time + '\'' +
                '}';
    }
}
