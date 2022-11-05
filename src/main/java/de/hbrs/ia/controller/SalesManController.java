package de.hbrs.ia.controller;

import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repository.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/salesmen")
public class SalesManController {

    @Autowired
    private SalesManRepository salesManRepository;

    /**
     * Get a List of All salesman
     * @return List of all Salesman
     */
    @GetMapping("/read/all")
    public List<SalesMan> getAllSalesMan() {
        return salesManRepository.findAll();
    }

    /**
     * Search for all Salesman with the given first name
     * @param firstname First name of Salesman to search for
     * @return List of all Salesman with that first name
     */
    @GetMapping("/read/name/{firstname}")
    public List<SalesMan> getSalesManByFirstname(@PathVariable String firstname) {
        return salesManRepository.findSalesManByFirstname(firstname);
    }

    /**
     * Search for a salesman with the given ID
     * @param sid Salesman ID
     * @return Salesman the ID belongs to
     */
    @GetMapping("/read/id/{sid}")
    public SalesMan getSalesManById(@PathVariable int sid) {
            return salesManRepository.findSalesManById(sid);
    }

    /**
     * Create a new salesman
     * @param salesMan Salesman Object to be created
     */
    @PostMapping("/create/")
    public void addSalesMan(@RequestBody SalesMan salesMan) {
            salesManRepository.save(salesMan);
    }

    /**
     * Update a salesman with new data
     * @param sid Salesman ID
     * @param salesMan Updates salesman Object
     * @return The updated salesman object
     */
    @PutMapping ("/update/{sid}")
    public SalesMan updateSalesMan(@PathVariable int sid, @RequestBody SalesMan salesMan) {
        salesMan.setId(sid);
        return salesManRepository.save(salesMan);
    }

    /**
     * Delete a salesman by its ID
     * @param sid Salesman ID
     */
    @DeleteMapping("/delete/id/{sid}")
    public void deleteSalesMan(@PathVariable int sid) {
        salesManRepository.deleteSalesManById(sid);
    }


}
