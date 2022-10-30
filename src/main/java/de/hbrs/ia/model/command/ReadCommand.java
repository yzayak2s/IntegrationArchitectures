package de.hbrs.ia.model.command;

import de.hbrs.ia.control.InputDialog;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.exception.ContainerException;
import de.hbrs.ia.view.EvaluationRecordView;
import de.hbrs.ia.view.SalesManView;

import java.text.ParseException;
import java.util.List;

public class ReadCommand implements Command{
    private final String[] parameterArray;

    public ReadCommand(String[] parameterArray) {
        this.parameterArray = parameterArray;
    }

    @Override
    public void execute(){
        switch (parameterArray[1].toLowerCase()) {
            case "salesmen" -> {
                List<SalesMan> salesManList = Container.getInstance().getSalesManList();
                SalesManView salesManView = new SalesManView();
                salesManView.startOutputSalesMen(salesManList);
                System.out.println("\n");
            }
            case "evaluationrecords" -> {
                EvaluationRecordView evaluationRecordView = new EvaluationRecordView();

                try {
                    List<EvaluationRecord> evaluationRecordList = InputDialog.inputDialogReadEvaluationRecordsBySalesManID();
                    Container.getInstance().setEvaluationRecordList(evaluationRecordList);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                List<EvaluationRecord> evaluationRecordList = Container.getInstance().getEvaluationRecordList();
                evaluationRecordView.startOutputEvaluationRecords(evaluationRecordList);
                System.out.println("\n");
            }

            default -> System.out.println(
                    "Unknown Command!\n" +
                            "Available Commands:\n" +
                            "   read salesmen\n" +
                            "   read evaluationrecords"
            );
        }
    }

    @Override
    public void undo() {

    }
}
