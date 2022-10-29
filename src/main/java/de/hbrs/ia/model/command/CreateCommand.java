package de.hbrs.ia.model.command;

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
                    // TODO: 29.10.22 EingabeDialog with addSalesMan()-method
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "evaluationrecord" -> {
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
