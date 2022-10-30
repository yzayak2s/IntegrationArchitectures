package de.hbrs.ia.model.command;

import de.hbrs.ia.control.InputDialog;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.exception.ContainerException;

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
                    Container.getInstance().startOutputSalesMen(salesManList);
                    SalesMan salesMan = InputDialog.inputDialogRemoveSalesMan();
                    Container.getInstance().managePersonal.deleteSalesMan(salesMan.getId());
                    salesManList.remove(salesMan);
                    Container.getInstance().startOutputSalesMen(salesManList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // TODO: 30.10.22 Implementation following ...
            case "evaluationrecord" -> {

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
