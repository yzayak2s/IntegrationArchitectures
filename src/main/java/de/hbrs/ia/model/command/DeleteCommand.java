package de.hbrs.ia.model.command;

import de.hbrs.ia.control.InputDialog;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.exception.ContainerException;
import de.hbrs.ia.view.EvaluationRecordView;
import de.hbrs.ia.view.SalesManView;

import java.text.ParseException;
import java.util.List;

public class DeleteCommand implements Command {
    private final String[] parameterArray;
    
    public DeleteCommand(String[] parameterArray) {
        this.parameterArray = parameterArray;
    }

    @Override
    public void execute() throws ContainerException, ParseException {
        switch (this.parameterArray[1].toLowerCase()) {
            case "salesman" -> {
                try {
                    List<SalesMan> salesManList = Container.getInstance().getSalesManList();
                    SalesManView salesManView = new SalesManView();
                    salesManView.startOutputSalesMen(salesManList);
                    SalesMan salesMan = InputDialog.inputDialogRemoveSalesMan();
                    Container.getInstance().managePersonal.deleteSalesMan(salesMan.getId());
                    salesManList.remove(salesMan);
                    System.out.println("Deletion was successfully!\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // TODO: 30.10.22 Implementation following ...
            case "evaluationrecord" -> {
                try {
                    List<EvaluationRecord> evaluationRecordList = Container.getInstance().getEvaluationRecordList();
                    EvaluationRecordView evaluationRecordView = new EvaluationRecordView();
                    evaluationRecordView.startOutputEvaluationRecords(evaluationRecordList);
                    EvaluationRecord evaluationRecord = InputDialog.inputDialogRemoveEvaluationRecord();
                    Container.getInstance().managePersonal.deleteEvaluationRecord(evaluationRecord.getGoalID());
                    evaluationRecordList.remove(evaluationRecord);
                    System.out.println("Deletion was successfully!\n");


                } catch (Exception e) {}

            }
            default -> System.out.println(
                    "Unknown Command!\n" +
                            "Available Commands:\n" +
                            "   delete salesman <ID>\n" +
                            "   delete evaluationrecord <ID>"
            );
        }
    }

    @Override
    public void undo() {

    }
}
