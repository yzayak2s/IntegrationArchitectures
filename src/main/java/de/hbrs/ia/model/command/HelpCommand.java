package de.hbrs.ia.model.command;

public class HelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println(
                "Following commands are available:\n" +
                "   create salesMan               ->  Create salesMan\n" +
                "   create evaluationRecord       ->  Create EvaluationRecord\n" +
                "   read salesMen                 ->  Shows all salesMen\n" +
                "   read evaluationRecord         ->  Shows all EvaluationRecords\n" +
                "   delete <salesMan-ID>          ->  Delete salesMan by ID\n" +
                "   delete <evaluationRecord-ID>  ->  Delete evaluationRecord by ID"
        );
    }

    @Override
    public void undo() {

    }
}
