package de.hbrs.ia.repository;
import de.hbrs.ia.model.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SalesManRepository  extends MongoRepository<SalesMan, String> {
    public SalesMan findSalesManById(int sid);
    public List<SalesMan> findAll();
    public List<SalesMan> findSalesManByFirstname(String firstname);
    public void deleteSalesManById(int sid);


}