package de.hbrs.ia.control;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;

import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    public void addPerformanceRecord(EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public EvaluationRecord readEvaluationRecord(int sid );
    public List<EvaluationRecord> queryEvaluationRecords( int sid );
    public void updateSalesMan(int sid, SalesMan updatedSalesMan);
    public void updateEvaluationRecord(int goalID, EvaluationRecord updatedRecord);
    public void deleteSalesMan(int sid);
    public void deleteAllSalesMan();
    public void deleteEvaluationRecord(int goalID);
    public void deleteAllEvaluationRecords();

}
