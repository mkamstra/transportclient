package nl.martijnkamstra.transport.repositories;

import nl.martijnkamstra.transport.models.Station;

import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
}
