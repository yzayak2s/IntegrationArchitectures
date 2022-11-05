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

    @GetMapping("/read/all/{sid}")
    public List<EvaluationRecord> getAllEvaluationRecordsBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findEvaluationRecordsBySalesManID(sid);
    }

    @GetMapping("/read/{sid}")
    public EvaluationRecord getEvaluationRecordBySalesManID(@PathVariable int sid) {
        return evaluationRecordRepository.findEvaluationRecordBySalesManID(sid);
    }

    @PutMapping(value = "/update/{goalID}")
    public EvaluationRecord updateEvaluationRecord(@PathVariable int goalID, @RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecord.setGoalID(goalID);
        return evaluationRecordRepository.save(evaluationRecord);
    }

    @PostMapping(value = "/create")
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecordRepository.save(evaluationRecord);
    }

    @DeleteMapping("/delete/{goalID}")
    public void deleteEvaluationRecord(@PathVariable int goalID) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalID(goalID);
    }

}
