package de.hbrs.ia.model.command;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.exception.ContainerException;

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
                Container.getInstance().startOutputSalesMen(salesManList);
                System.out.println("\n");
            }
            // TODO: 29.10.22 extend this case with another parameter as salesMan-ID  
            case "evaluationrecords" -> {
                List<EvaluationRecord> evaluationRecordList = Container.getInstance().getEvaluationRecordList();
                Container.getInstance().startOutputEvaluationRecords(evaluationRecordList);
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
