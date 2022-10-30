package de.hbrs.ia.control;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.command.Container;

import java.util.InputMismatchException;
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
                    if (Container.getInstance().contains(salesMan)) {
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
        System.out.println("\nSalesman has been successfully deleted!\n");

        return salesMan;
    }

    // TODO: 30.10.22 Implementation following...
    public static EvaluationRecord inputDialogCreateEvaluationRecord() throws Exception {

        int id = 0;
        int goalID;
        String goalDescription;
        int targetValue;
        int actualValue;
        int year;
        int salesManID;


        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an ID of a salesman: ");

        while (true) {
            try {
                id = scanner.nextInt();
                int finalId = id;
                SalesMan salesMan = Container.getInstance().getSalesManList().stream()
                        .filter((salMan) -> salMan.getId() == finalId)
                        .findAny()
                        .orElse(null);

                if (salesMan != null) {
                    if (Container.getInstance().contains(salesMan)) {
                        break;
                    }
                } else {
                    System.out.println("Salesman with ID \"" + id + "\" doesn't exist!");
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

        return new EvaluationRecord(firstname, lastname, id);
    }

}
