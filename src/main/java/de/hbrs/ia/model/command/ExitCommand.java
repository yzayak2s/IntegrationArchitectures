package de.hbrs.ia.model.command;

public class ExitCommand implements Command {

    @Override
    public void execute(){
        System.out.println(
                "The application will be terminated.\n" +
                "See you soon!"
        );

    }

    @Override
    public void undo() {

    }
}
