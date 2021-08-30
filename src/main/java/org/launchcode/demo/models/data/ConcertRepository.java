package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Integer> {
}
