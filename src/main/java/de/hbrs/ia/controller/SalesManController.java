package de.hbrs.ia.controller;

import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repository.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class SalesManController {

    @Autowired
    private SalesManRepository salesManRepository;

    @GetMapping(value = "/salesman")
    public List<SalesMan> getAllsalesMan() {

        return salesManRepository.findAll();
    }

    @GetMapping("/salesman/firstname/{firstname}")
    List<SalesMan> getSalesManByFirstname(@PathVariable String firstname) {

        try {
            return salesManRepository.findSalesManByFirstname(firstname);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salesManRepository.findSalesManByFirstname(firstname);
    }

    @GetMapping("/salesman/{sid}")
    SalesMan getSalesManById(@PathVariable int sid) {

            return salesManRepository.findSalesManById(sid);

    }


    @PostMapping(value = "/salesman",  consumes = {"application/xml","application/json"})
    public SalesMan addSalesMan(@RequestBody SalesMan salesMan) {
            return salesManRepository.save(salesMan);
    }

    @PutMapping (value = "/salesman/update/{sid}")
    public SalesMan updateMovie(@PathVariable int sid, @RequestBody SalesMan salesMan) {
        salesMan.setId(sid);
        return salesManRepository.save(salesMan);
    }

    @DeleteMapping(value = "/salesman/delete/{sid}")
    public void deleteMovie(@PathVariable int sid) {
        salesManRepository.deleteSalesManById(sid);
    }


}
