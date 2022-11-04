package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: 03.11.22 Implementation is left
@RestController
@RequestMapping("/evaluationrecord")
public class EvaluationRecordController {

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

    @PostMapping
    public void createEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecordRepository.save(evaluationRecord);
    }

    @DeleteMapping("/{goalID}")
    public void deleteEvaluationRecord(@PathVariable int goalID) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalID(goalID);
    }

}
