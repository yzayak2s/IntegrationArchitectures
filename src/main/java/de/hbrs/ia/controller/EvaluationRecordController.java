package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationrecord")
public class EvaluationRecordController {

    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    /**
     * Get all Evaluations Records of a Salesman ordered By Year (newest -> oldest)
     * @param sid Salesman ID
     * @return List of all Evaluation records
     */
    @GetMapping("/read/all/{sid}")
    public List<EvaluationRecord> getAllEvaluationRecordsBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findEvaluationRecordsBySalesManIDOrderByYearDesc(sid);
    }

    /**
     * Get the newest evaluation record af a salesman
     * @param sid Salesman ID
     * @return Newest Evaluation Records
     */
    @GetMapping("/read/{sid}")
    public EvaluationRecord getNewestEvaluationRecordBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findTopEvaluationRecordBySalesManIDOrderByYearDesc(sid);
    }

    /**
     * Update an evaluation record by its ID
     * @param goalID Evaluation record ID
     * @param evaluationRecord the updated evaluation record
     * @return
     */
    @PutMapping(value = "/update/{goalID}")
    public EvaluationRecord updateEvaluationRecord(@PathVariable int goalID, @RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecord.setGoalID(goalID);
        return evaluationRecordRepository.save(evaluationRecord);
    }

    /**
     * Create a new evaluation record
     * @param evaluationRecord Evaluation Record to be created
     */
    @PostMapping(value = "/create")
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecordRepository.save(evaluationRecord);
    }

    /**
     * Delete an evaluation record by its ID
     * @param goalID Evaluation record ID
     */
    @DeleteMapping("/delete/{goalID}")
    public void deleteEvaluationRecord(@PathVariable int goalID) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalID(goalID);
    }

}
