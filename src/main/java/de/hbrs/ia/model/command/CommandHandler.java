package de.hbrs.ia.model.command;

import de.hbrs.ia.model.exception.ContainerException;

import java.text.ParseException;
import java.util.*;

/*
 * Invoker (according to Command Pattern)
 */
public class CommandHandler {

    public static Command commandHashMap(String[] parameterArray) {

        // Initialize the commands
        HashMap<String, Command> commandsMap = new HashMap();
        commandsMap.put("help", new HelpCommand());
        commandsMap.put("exit", new ExitCommand());
        commandsMap.put("create", new CreateCommand(parameterArray));

        return commandsMap.get(parameterArray[0]);
    }

    public static void startInput() throws ContainerException, ParseException {
        Stack<Command> stack = new Stack();
        String strInput = null;

        // Initialization of Input-View
        Scanner scanner = new Scanner(System.in);

        // Output of a text for greeting
        System.out.println("HighPerformance-Tool v1.0.3 by noukha2s, jkuste2s and yzayak2s");

        while ( true ) {
            // Print the prompt
            System.out.println("> ");

            // Next command
            strInput = scanner.nextLine();
            String[] splitted = strInput.split("\\s+"); // '\\s' skips the whitespaces

            Command command = commandHashMap(splitted);
            try {
                command.execute();
            } catch (NullPointerException e) {
                System.out.println(
                        "Unknown command. Please enter a valid command!\n" +
                        "Hint: For more help enter \"help\" to show a list of valid commands."
                );
            }

            if (splitted[0].equals("exit")){
                scanner.close();
                break;
            }
        }
    }
}
