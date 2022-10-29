package de.hbrs.ia.model.command;

import de.hbrs.ia.model.exception.ContainerException;

import java.text.ParseException;

public class ReadCommand implements Command{
    private final String[] parameterArray;

    public ReadCommand(String[] parameterArray) {
        this.parameterArray = parameterArray;
    }

    @Override
    public void execute() throws ContainerException, ParseException {
        switch (parameterArray[1].toLowerCase()) {
            case "salesmen" -> {
                try {
                    // TODO: 29.10.22
                } catch (Exception error) {
                }
            }
            case "evaluationrecord" -> {

            }

            default -> System.out.println();
        }
    }

    @Override
    public void undo() {

    }
}
