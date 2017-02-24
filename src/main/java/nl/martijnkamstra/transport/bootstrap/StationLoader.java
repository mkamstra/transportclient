package nl.martijnkamstra.transport.bootstrap;

import nl.martijnkamstra.transport.models.Station;
import nl.martijnkamstra.transport.repositories.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private StationRepository stationRepository;

    private Logger logger = LoggerFactory.getLogger(StationLoader.class);

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Station station = new Station();
        station.setName("Liverpool street");
        stationRepository.save(station);
        logger.info("Station " + station + " saved into H2 station respository");

        station = new Station();
        station.setName("Paddington street");
        stationRepository.save(station);
        logger.info("Station " + station + " saved into H2 station respository");

        station = new Station();
        station.setName("Oxford street");
        stationRepository.save(station);
        logger.info("Station " + station + " saved into H2 station respository");
    }
}
