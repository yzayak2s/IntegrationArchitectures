package de.hbrs.ia.view;

import de.hbrs.ia.model.EvaluationRecord;

import java.util.List;

public class EvaluationRecordView {

    public void dumpSalesMan(List<EvaluationRecord> evaluationRecordList) {
        for (EvaluationRecord evaluationRecord : evaluationRecordList) {
            System.out.println(evaluationRecord.toString());
        }
    }
}
