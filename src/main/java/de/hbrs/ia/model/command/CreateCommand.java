package de.hbrs.ia.model.command;

import de.hbrs.ia.control.InputDialog;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.exception.ContainerException;

import java.text.ParseException;

public class CreateCommand  implements Command{
    private final String[] parameterArray;

    public CreateCommand(String[] parameterArray) {
        this.parameterArray = parameterArray;
    }

    @Override
    public void execute() throws ContainerException, ParseException {
        switch (this.parameterArray[1].toLowerCase()) {
            case "salesman" -> {
                try {
                    Container.getInstance().addSalesMan(InputDialog.inputDialogCreateSalesMan());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "evaluationrecord" -> {
                try {
                    EvaluationRecord evaluationRecord = InputDialog.inputDialogCreateEvaluationRecord();
                    Container.getInstance().addEvaluationRecord(evaluationRecord, evaluationRecord.getSalesManID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO: 29.10.22 See above
            }
            default -> System.out.println(
                    "Unknown Command!\n" +
                    "Available Commands:\n" +
                    "   create salesman\n" +
                    "   create evaluationrecord"
            );
        }
    }

    @Override
    public void undo() {

    }
}
