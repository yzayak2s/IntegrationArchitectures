package de.hbrs.ia.controller;

import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repository.SalesManRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/salesmen")
public class SalesManController {

    @Autowired
    private SalesManRepository salesManRepository;

    @Operation(
            summary = "Get all salesman",
            responses = {
                    @ApiResponse(responseCode = "200",description = "List of Salesman", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SalesMan.class))),
                    @ApiResponse(responseCode = "404", description = "No salesman was found", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/read/all")
    public List<SalesMan> getAllSalesMan() {
        return salesManRepository.findAll();
    }

    @Operation(
            summary = "Search for all Salesman with the given first name",
            responses = {
                    @ApiResponse(responseCode = "200",description = "List of Salesman", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SalesMan.class))),
                    @ApiResponse(responseCode = "404", description = "No matching salesman was found", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/read/name/{firstname}")
    public List<SalesMan> getSalesManByFirstname(@PathVariable @Parameter(description = "The first name to be fetched", required = true) String firstname) {
        return salesManRepository.findSalesManByFirstname(firstname);
    }

    @Operation(
            summary = "Search for a salesman with the given ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Salesman", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SalesMan.class))),
                    @ApiResponse(responseCode = "404", description = "No matching salesman was found", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/read/id/{sid}")
    public SalesMan getSalesManById(@PathVariable @Parameter(description = "Salesman ID",required = true) int sid) {
            return salesManRepository.findSalesManById(sid);
    }

    @Operation(
            summary = "Create a new salesman",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Salesman was created")
            }
    )
    @PostMapping("/create/")
    public void addSalesMan(@RequestBody @Parameter(description = "Salesman object to be created",required = true) SalesMan salesMan) {
            salesManRepository.save(salesMan);
    }

    @Operation(
            summary = "Update a salesman with new data",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Updated salesman Object")
            }
    )
    @PutMapping ("/update/{sid}")
    public SalesMan updateSalesMan(@PathVariable @Parameter(description = "Salesman ID", required = true) int sid, @RequestBody SalesMan salesMan) {
        salesMan.setId(sid);
        return salesManRepository.save(salesMan);
    }

    @Operation(
            summary = "Delete a salesman by its ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Deleted salesman Object")
            }
    )
    @DeleteMapping("/delete/id/{sid}")
    public void deleteSalesMan(@PathVariable @Parameter(description = "Salesman ID", required = true) int sid) {
        salesManRepository.deleteSalesManById(sid);
    }


}
