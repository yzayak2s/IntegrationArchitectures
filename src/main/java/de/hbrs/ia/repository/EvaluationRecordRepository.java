package de.hbrs.ia.repository;

import de.hbrs.ia.model.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

// TODO: 03.11.22 Implementation left
public interface EvaluationRecordRepository extends MongoRepository<EvaluationRecord, String> {
}
