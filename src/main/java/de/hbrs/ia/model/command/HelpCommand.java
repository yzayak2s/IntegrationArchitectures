package de.hbrs.ia.model.command;

public class HelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println(
                "Following commands are available:\n" +
                "   create salesMen                 Create salesMan\n" +
                "   create evaluationRecord         Create EvaluationRecord\n" +
                "   read salesMen                   Shows all salesMen\n" +
                "   read evaluationRecord           Shows all EvaluationRecords\n" +
                "   delete <salesMan-ID>            Delete salesMen by ID\n" +
                "   delete <evaluationRecord-ID>    Shows all EvaluationRecords"
        );
    }

    @Override
    public void undo() {

    }
}
