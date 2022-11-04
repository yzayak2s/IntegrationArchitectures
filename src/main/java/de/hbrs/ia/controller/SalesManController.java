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

    @GetMapping
    public List<SalesMan> getAllsalesMan() {

        return salesManRepository.findAll();
    }

    @GetMapping("/firstname/{firstname}")
    public List<SalesMan> getSalesManByFirstname(@PathVariable String firstname) {

        try {
            return salesManRepository.findSalesManByFirstname(firstname);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salesManRepository.findSalesManByFirstname(firstname);
    }

    @GetMapping("/{sid}")
    public SalesMan getSalesManById(@PathVariable int sid) {

            return salesManRepository.findSalesManById(sid);

    }


    // TODO: 04.11.22 Validation if salesmanID already exists!
    @PostMapping
    public void addSalesMan(@RequestBody SalesMan salesMan) {
            salesManRepository.save(salesMan);
    }

    @PutMapping ("/update/{sid}")
    public SalesMan updateSalesMan(@PathVariable int sid, @RequestBody SalesMan salesMan) {
        salesMan.setId(sid);
        return salesManRepository.save(salesMan);
    }

    @DeleteMapping("/delete/{sid}")
    public void deleteSalesMan(@PathVariable int sid) {
        salesManRepository.deleteSalesManById(sid);
    }


}
