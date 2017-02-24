package nl.martijnkamstra.transport.services;

import nl.martijnkamstra.transport.models.TransportList;

public interface TransportService {
    TransportList getTransportList(double latitude, double longitude);
}
