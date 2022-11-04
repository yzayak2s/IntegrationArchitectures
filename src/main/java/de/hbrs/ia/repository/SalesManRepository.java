package de.hbrs.ia.repository;
import de.hbrs.ia.model.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SalesManRepository extends MongoRepository<SalesMan, String> {
    public SalesMan findSalesManById(int sid);
    public List<SalesMan> findAll();
    public List<SalesMan> findSalesManByFirstname(String firstname);

    // TODO: 04.11.22 CREATE Salesman implementation
    // TODO: 04.11.22 UPDATE Salesman implementation
    public void deleteSalesManById(int sid);


}