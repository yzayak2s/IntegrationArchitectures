package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repository.EvaluationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationRecordController {

    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    @GetMapping(value = "/evaluationRecord")
    public List<EvaluationRecord> getAllevaluationrecord() {

        return evaluationRecordRepository.findAll();
    }



    @GetMapping("/evaluationRecord/eid}")
    EvaluationRecord getEvaluationRecordByGoalID(@PathVariable int eid) {

        return evaluationRecordRepository.findEvaluationRecordByGoalID(eid);

    }


    @PostMapping(value = "/evaluationrecord",  consumes = {"application/xml","application/json"})
    public EvaluationRecord addEvaluationRecord(@RequestBody EvaluationRecord evaluationRecord) {
        return evaluationRecordRepository.save(evaluationRecord);
    }

    @PutMapping(value = "/evaluationRecord/update/{eid}")
    public EvaluationRecord updateEvaluationRecord(@PathVariable int eid, @RequestBody EvaluationRecord evaluationRecord) {
        evaluationRecord.setGoalID(eid);
        return evaluationRecordRepository.save(evaluationRecord);
    }

    @DeleteMapping(value = "/evaluationrecord/delete/{eid}")
    public void deleteEvaluationRecord(@PathVariable int eid) {
        evaluationRecordRepository.deleteEvaluationRecordByGoalId(eid);
    }


}
