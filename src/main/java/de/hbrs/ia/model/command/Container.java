package de.hbrs.ia.model.command;

import de.hbrs.ia.control.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.exception.ContainerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to maintain salesmen and evaluationrecords
 */
public class Container {

    // Internal ArrayList for storing the objects of type salesMan and evaluationRecord
    private List<SalesMan> salesManList = null;
    private List<EvaluationRecord> evaluationRecordList = null;

    // Static class-variable to store the reference to the 'single' container object
    private static Container instance = new Container();

    // TODO: 29.10.22 Provide here a database connection (see class ManagePersonalImpl)
    ManagePersonalImpl managePersonal = null;

    /**
     * Returns a signleton back.
     * @return
     */
    public static Container getInstance() {
        return instance;
    }

    private Container() {
        managePersonal = new ManagePersonalImpl();
        salesManList = managePersonal.querySalesMan("", "");
        evaluationRecordList = new ArrayList<>();
    }

    /**
     * Determination of the number of internal salesman objects.
     * @return
     */
    public int sizeSalesMen() {
        return salesManList.size();
    }

    /**
     * Determination of the number of internal evaluation-record objects
     * @return
     */
    public int sizeEvaluationRecords() {
        return evaluationRecordList.size();
    }

    public List<SalesMan> getSalesManList() {
        return this.salesManList;
    }

    public List<EvaluationRecord> getEvaluationRecordList() {
        return this.evaluationRecordList;
    }

    public List<EvaluationRecord> getEvaluationRecordListBySalesManID(int salesManID) {
        this.evaluationRecordList = managePersonal.queryEvaluationRecords(salesManID);
        return this.evaluationRecordList;
    }

    public void setSalesManList(List<SalesMan> salesManList) {
        this.salesManList = salesManList;
    }

    public void setEvaluationRecordList(List<EvaluationRecord> evaluationRecordList) {
        this.evaluationRecordList = evaluationRecordList;
    }

    public boolean containsSalesMan(SalesMan salesMan) {
        int ID = salesMan.getId();
        for (SalesMan salMan : salesManList) {
            if (salMan.getId() == ID) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEvaluationRecord(EvaluationRecord evaluationRecord) {
        int goalID = evaluationRecord.getGoalID();
        for (EvaluationRecord evRecord : evaluationRecordList) {
            if (evRecord.getGoalID() == goalID) {
                return true;
            }
        }
        return false;
    }

    public void addSalesMan (SalesMan salesMan) throws ContainerException {
        if (containsSalesMan(salesMan)) {
            ContainerException exception = new ContainerException("ID already belongs to a salesman!");
            throw exception;
        }
        managePersonal.createSalesMan(salesMan);
        salesManList.add(salesMan);
    }

    public void addEvaluationRecord(EvaluationRecord evaluationRecord, int salesManID) throws ContainerException {
        if (containsEvaluationRecord(evaluationRecord)) {
            ContainerException exception = new ContainerException("GoalID already belongs to an evaluation record!");
            throw exception;
        }
        managePersonal.addPerformanceRecord(evaluationRecord, salesManID);
        evaluationRecordList.add(evaluationRecord);
    }
}
