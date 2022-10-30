package de.hbrs.ia.control;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.command.Container;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputDialog {

    public static SalesMan inputDialogCreateSalesMan() throws Exception {

        int id = 0;
        String firstname;
        String lastname;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an ID: ");

        while (true) {
            try {
                id = scanner.nextInt();
                int finalId = id;
                SalesMan salesMan = Container.getInstance().getSalesManList().stream()
                        .filter((salMan) -> salMan.getId() == finalId)
                        .findAny()
                        .orElse(null);

                if (salesMan != null) {
                    if (Container.getInstance().containsSalesMan(salesMan)) {
                        System.out.println("ID already taken!\n");
                    }
                } else {
                    break;
                }
                System.out.print("Please enter another ID: ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid ID!\n");
            }
        }

        System.out.print("Firstname: ");
        firstname = scanner.next();
        System.out.print("Lastname: ");
        lastname = scanner.next();
        System.out.println();
        System.out.println("Salesman has been created!");

        return new SalesMan(firstname, lastname, id);
    }

    public static SalesMan inputDialogRemoveSalesMan() {

        SalesMan salesMan = null;
        int id = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease choose one by ID to be deleted: ");

        while (true) {

            try {
                id = scanner.nextInt();
                int finalId = id;
                salesMan = Container.getInstance().getSalesManList().stream()
                        .filter((salMan) -> salMan.getId() == finalId)
                        .findAny()
                        .orElse(null);
                if (salesMan != null) {
                    break;
                } else {
                    System.out.println("Salesman with ID \"" + id + "\" doesn't exist!");
                }
                System.out.print("\nPlease choose another one by ID to be deleted: ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid ID");
            }
        }
        System.out.println("\nSalesman wit \"" + id + "\" will be deleted!\n");

        return salesMan;
    }

    // TODO: 30.10.22 Implementation following...
    public static EvaluationRecord inputDialogCreateEvaluationRecord() throws Exception {

        int salesManID = 0;
        int goalID;
        String goalDescription;
        int targetValue;
        int actualValue;
        int year;


        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease enter an ID of a salesman: ");

        while (true) {
            try {
                salesManID = scanner.nextInt();
                int finalId = salesManID;
                SalesMan salesMan = Container.getInstance().getSalesManList().stream()
                        .filter((salMan) -> salMan.getId() == finalId)
                        .findAny()
                        .orElse(null);

                if (salesMan != null) {
                    if (Container.getInstance().containsSalesMan(salesMan)) {
                        break;
                    }
                } else {
                    System.out.println("Salesman with ID \"" + salesManID + "\" doesn't exist!");
                }
                System.out.print("Please enter another ID: ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid ID!\n");
            }
        }



        System.out.print("\nPlease enter an goal-ID: ");

        while (true) {
            try {
                goalID = scanner.nextInt();
                int finalgoalID = goalID;
                Container.getInstance().getEvaluationRecordListBySalesManID(finalgoalID);
                EvaluationRecord evaluationRecord = Container.getInstance().getEvaluationRecordList().stream()
                        .filter((evRec) -> evRec.getGoalID() == finalgoalID)
                        .findAny()
                        .orElse(null);

                if (evaluationRecord != null) {
                    if (Container.getInstance().containsEvaluationRecord(evaluationRecord)) {
                        System.out.print("GoalID already taken!\n");
                    }
                } else {
                    break;
                }
                System.out.print("Please enter another goalID: ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid goalID!\n");
            }
        }

        scanner.nextLine(); // throw away the \n not consumed by nextInt()
        System.out.print("Goal description: ");
        goalDescription = scanner.nextLine();
        System.out.print("Target value: ");
        targetValue = scanner.nextInt();
        System.out.print("Actual value: ");
        actualValue = scanner.nextInt();
        System.out.print("Year: ");
        year = scanner.nextInt();
        System.out.println();
        System.out.println("Evaluation record has been created!");

        return new EvaluationRecord(
                goalID,
                goalDescription,
                targetValue,
                actualValue,
                year,
                salesManID
                );
    }

    public static List<EvaluationRecord> inputDialogReadEvaluationRecordsBySalesManID() throws Exception {
        int salesManID = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease enter an ID of a salesman: ");

        while (true) {
            try {
                salesManID = scanner.nextInt();
                int finalId = salesManID;
                SalesMan salesMan = Container.getInstance().getSalesManList().stream()
                        .filter((salMan) -> salMan.getId() == finalId)
                        .findAny()
                        .orElse(null);

                if (salesMan != null) {
                    if (Container.getInstance().containsSalesMan(salesMan)) {
                        break;
                    }
                }
                System.out.println("Salesman with ID \"" + salesManID + "\" doesn't exist!");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid ID!\n");
            }
        }

        return Container.getInstance().getEvaluationRecordListBySalesManID(salesManID);
    }

    public static EvaluationRecord inputDialogRemoveEvaluationRecord() {

        EvaluationRecord evaluationRecord = null;
        int goalID = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease choose one by goal-ID of a evaluation record to be deleted: ");

        while (true) {

            try {
                goalID = scanner.nextInt();
                int finalID = goalID;
                evaluationRecord = Container.getInstance().getEvaluationRecordList().stream()
                        .filter((evRec) -> evRec.getGoalID() == finalID)
                        .findAny()
                        .orElse(null);

                if (evaluationRecord != null) {
                    if (Container.getInstance().containsEvaluationRecord(evaluationRecord)) {
                        break;
                    }
                }
                System.out.println("Evaluation record with goal-ID \"" + goalID + "\" doesn't exist!");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid goal-ID!\n");
            }
        }
        System.out.println("\nEvaluation record with \"" + goalID + "\" will be deleted!\n");

        return evaluationRecord;
    }

}
