package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationrecord")
public class EvaluationRecordController {

    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    @Operation(
            summary = "Get all Evaluations Records of a Salesman ordered By Year (newest -> oldest)",
            responses = {
                    @ApiResponse(responseCode = "200",description = "List of evaluation records", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluationRecord.class))),
                    @ApiResponse(responseCode = "404", description = "No evaluation record was found", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/read/all/{sid}")
    public List<EvaluationRecord> getAllEvaluationRecordsBySalesManID(@PathVariable @Parameter(description = "salesman ID", required = true) int sid) {
        return evaluationRecordRepository.findEvaluationRecordsBySalesManIDOrderByYearDesc(sid);
    }

    @Operation(
            summary = "Get the newest evaluation record of a salesman",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Newest evaluation record", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluationRecord.class))),
                    @ApiResponse(responseCode = "404", description = "No evaluation record was found", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/read/{sid}")
    public EvaluationRecord getNewestEvaluationRecordBySalesManID(@PathVariable @Parameter(description = "salesman ID", required = true) int sid) {
        return evaluationRecordRepository.findTopEvaluationRecordBySalesManIDOrderByYearDesc(sid);
    }

    @Operation(
            summary = "Update an evaluation record by its ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Updated evaluation record", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluationRecord.class)))
            }
    )
    @PutMapping(value = "/update/{goalID}")
    public EvaluationRecord updateEvaluationRecord(@PathVariable @Parameter(description = "Evaluation Record ID") int goalID, @RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecord.setGoalID(goalID);
        return evaluationRecordRepository.save(evaluationRecord);
    }

    @Operation(
            summary = "Create a new evaluation record",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Created evaluation record", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluationRecord.class)))
            }
    )
    @PostMapping(value = "/create")
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecordRepository.save(evaluationRecord);
    }

    @Operation(
            summary = "Delete an evaluation record by its ID",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Deleted evaluation record")
            }
    )
    @DeleteMapping("/delete/{goalID}")
    public void deleteEvaluationRecord(@PathVariable @Parameter(description = "Evaluation record ID", required = true) int goalID) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalID(goalID);
    }

}
