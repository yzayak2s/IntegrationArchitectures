package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationrecord")
public class EvaluationRecordController {

    // TODO: 04.11.22 Extend endpoint with create/delete/update/read 
    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    // TODO: 04.11.22 Better solution?!
    @GetMapping("/all/{sid}")
    public List<EvaluationRecord> getAllEvaluationRecordsBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findEvaluationRecordsBySalesManID(sid);
    }

    @GetMapping("/{sid}")
    public EvaluationRecord getEvaluationRecordBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findEvaluationRecordBySalesManID(sid);
    }

    @PutMapping(value = "/{goalID}")
    public EvaluationRecord updateEvaluationRecord(@PathVariable int goalID, @RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecord.setGoalID(goalID);
        return evaluationRecordRepository.save(evaluationRecord);
    }

    @PostMapping
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecordRepository.save(evaluationRecord);
    }

    @DeleteMapping("/{goalID}")
    public void deleteEvaluationRecord(@PathVariable int goalID) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalID(goalID);
    }

}
