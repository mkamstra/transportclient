package nl.martijnkamstra.transport.controller;

import nl.martijnkamstra.transport.models.Station;
import nl.martijnkamstra.transport.models.TransportListRequest;
import nl.martijnkamstra.transport.repositories.StationRepository;
import nl.martijnkamstra.transport.services.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

@Controller
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private TransportService transportService;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Autowired
    private StationRepository stationRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    /**
     * The index, displaying a form where the user can enter his details in order to get a real time schedule for
     */
    public String index(Model model, @RequestHeader HttpHeaders httpHeaders, ServletRequest httpServletRequest) {
        model.addAttribute("message", this.message);
        model.addAttribute("transportListRequest", new TransportListRequest());
        model.addAttribute("stations", stationRepository.findAll()); // Needed to be able to select a station
        return "index";
    }

    @PostMapping("/gettransportlist")
    /**
     * This method is invoked when the request form on the index page is submitted. It will fetch a schedule from the
     * webservice providing these data and display it on a page (the result template is rendered)
     */
    public String transportListSubmit(Model model, @ModelAttribute TransportListRequest transportListRequest) {
        System.out.println("TransportListRequest: " + transportListRequest);
        //TODO: Add station details here
        model.addAttribute("transportList", transportService.getTransportList(transportListRequest.getLatitude(), transportListRequest.getLongitude()));
        return "result";
    }
}
