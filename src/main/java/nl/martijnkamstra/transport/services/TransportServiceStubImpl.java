package nl.martijnkamstra.transport.services;

import nl.martijnkamstra.transport.models.TransportInfo;
import nl.martijnkamstra.transport.models.TransportList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransportServiceStubImpl implements TransportService {

    @Override
    public TransportList getTransportList(double latitude, double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/list?latitude=" + latitude + "&longitude=" + longitude;
        return restTemplate.getForObject(url, TransportList.class);
    }
}
