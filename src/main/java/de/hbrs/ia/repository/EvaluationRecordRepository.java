package de.hbrs.ia.repository;

import de.hbrs.ia.model.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// TODO: 03.11.22 Implementation left
public interface EvaluationRecordRepository extends MongoRepository<EvaluationRecord, String> {
    public EvaluationRecord findTopEvaluationRecordBySalesManIDOrderByYearDesc(int salesManID);
    public EvaluationRecord findEvaluationRecordByGoalID(int goalID);
    public List<EvaluationRecord> findEvaluationRecordsBySalesManIDOrderByYearDesc(int salesManID);
    public void deleteEvaluationRecordByGoalID(int goalID);
    public void getEvaluationRecordByGoalID(int goalID);
}
