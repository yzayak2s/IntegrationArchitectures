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
    public List<SalesMan> getAllSalesMan() {
        return salesManRepository.findAll();
    }

    @GetMapping("/read/firstname/{firstname}")
    public List<SalesMan> getSalesManByFirstname(@PathVariable String firstname) {
        return salesManRepository.findSalesManByFirstname(firstname);
    }

    @GetMapping("/read/{sid}")
    public SalesMan getSalesManById(@PathVariable int sid) {
            return salesManRepository.findSalesManById(sid);
    }

    @PostMapping("/create/")
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
