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

    public void startOutputSalesMen(List<SalesMan> salesManList) {
        if (salesManList.size() == 0 ) {
            System.out.println("There are no salesmen yet!");
        } else {
            String format = "|%1$-20s|%2$-20s|%3$-20s|%n";
            System.out.format(format, "ID", "Firstname", "Lastname");
            System.out.format(format, "====================", "====================", "====================");
            for (SalesMan salesMan : salesManList) {
                System.out.format(
                        format,
                        salesMan.getId(),
                        salesMan.getFirstname(),
                        salesMan.getLastname()
                );
            }
        }
    }

    public void startOutputEvaluationRecords(List<EvaluationRecord> evaluationRecordList) {
        if (evaluationRecordList.size() == 0) {
            System.out.println("There are no evaluation records yet!");
        } else {
            String format = "|%1$-20s|%2$-20s|%3$-30s|%4$-20s|%5$-20s||%6$-20s|%n";
            System.out.format(format, "goalID", "goalDescription", "targetValue", "actualValue", "year", "salesManID");
            System.out.format(format, "====================", "====================", "==============================", "====================", "====================", "====================");
            for (EvaluationRecord evaluationRecord : evaluationRecordList) {
                System.out.format(
                        format,
                        evaluationRecord.getGoalID(),
                        evaluationRecord.getGoalDescription(),
                        evaluationRecord.getTargetValue(),
                        evaluationRecord.getActualValue(),
                        evaluationRecord.getYear(),
                        evaluationRecord.getSalesManID()
                );
            }
        }
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

    public void setSalesManList(List<SalesMan> salesManList) {
        this.salesManList = salesManList;
    }

    public void setEvaluationRecordList(List<EvaluationRecord> evaluationRecordList) {
        this.evaluationRecordList = evaluationRecordList;
    }

    public boolean contains(SalesMan salesMan) {
        int ID = salesMan.getId();
        for (SalesMan salMan : salesManList) {
            if (salMan.getId() == ID) {
                return true;
            }
        }
        return false;
    }

    public void addSalesMan (SalesMan salesMan) throws ContainerException {
        if (contains(salesMan)) {
            ContainerException exception = new ContainerException("ID already belongs to a salesman!");
            throw exception;
        }
        managePersonal.createSalesMan(salesMan);
        salesManList.add(salesMan);
    }
}
