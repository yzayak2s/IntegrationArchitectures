package de.hbrs.ia.repository;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EvaluationRecordRepository  extends MongoRepository<EvaluationRecord, String> {
    public EvaluationRecord findEvaluationRecordByGoalID(int eid);
    public List<EvaluationRecord> findAll();
    public void deleteEvaluationRecordByGoalId(int eid);

}
