// Compost.java
// A simple operating environment in Java

import java.io.*;
import java.util.*;

public class Compost {

    // A list of processes running in the environment
    private List<Process> processes;

    // A scanner for user input
    private Scanner scanner;

    // A constructor that initializes the environment
    public Compost() {
        processes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // A method that creates and runs a new process
    public void createProcess(String name, String command) {
        try {
            // Create a new process with the given name and command
            Process process = new Process(name, command);

            // Add the process to the list of processes
            processes.add(process);

            // Start the process in a new thread
            new Thread(process).start();

            // Print a message to indicate the process creation
            System.out.println("Created process " + name + " with command " + command);
        } catch (Exception e) {
            // Print an error message if something goes wrong
            System.out.println("Error creating process " + name + ": " + e.getMessage());
        }
    }

    // A method that kills a process by name
    public void killProcess(String name) {
        // Find the process with the given name in the list of processes
        for (Process process : processes) {
            if (process.getName().equals(name)) {
                // Kill the process and remove it from the list of processes
                process.kill();
                processes.remove(process);

                // Print a message to indicate the process termination
                System.out.println("Killed process " + name);

                // Return from the method
                return;
            }
        }

        // Print an error message if the process is not found
        System.out.println("No such process: " + name);
    }

    // A method that lists all the processes running in the environment
    public void listProcesses() {
        // Print a header for the list of processes
        System.out.println("Processes running in Compost:");

        // Loop through the list of processes and print their details
        for (Process process : processes) {
            System.out.println(process);
        }
    }

    // A method that handles user commands
    public void handleCommand(String command) {
        // Split the command into words by whitespace
        String[] words = command.split("\\s+");

        // Check if the command is empty or invalid
        if (words.length == 0 || words[0].isEmpty()) {
            System.out.println("Invalid command");
            return;
        }

        // Check if the command is to create a new process
        if (words[0].equals("create")) {
            // Check if the command has enough arguments
            if (words.length < 3) {
                System.out.println("Usage: create <name> <command>");
                return;
            }

            // Get the name and command arguments from the command
            String name = words[1];
            String cmd = words[2];

            // Create a new process with the given name and command
            createProcess(name, cmd);
        }

        // Check if the command is to kill a process
        else if (words[0].equals("kill")) {
            // Check if the command has enough arguments
            if (words.length < 2) {
                System.out.println("Usage: kill <name>");
                return;
            }

            // Get the name argument from the command
            String name = words[1];

            // Kill the process with the given name
            killProcess(name);
        }

        // Check if the command is to list all the processes
        else if (words[0].equals("list")) {
            // List all the processes running in the environment
            listProcesses();
        }

        // Check if the command is to exit the environment
        else if (words[0].equals("exit")) {
            // Print a farewell message and exit the program
            System.out.println("Exiting Compost. Goodbye!");
            System.exit(0);
        }

        // Otherwise, print an error message for an unknown command
        else {
            System.out.println("Unknown command: " + words[0]);
        }
    }

    // A method that runs the main loop of the environment
    public void run() {
        // Print a welcome message and prompt for user input
        System.out.println("Welcome to Compost, a simple operating environment in Java.");
        System.out.println("Type 'create <name> <command>' to create a new process.");
        System.out.println("Type 'kill <name>' to kill a process by name.");
        System.out.println("Type 'list' to list all the processes running in Compost.");
        System.out.println("Type 'exit' to exit Compost.");

        while (true) {
            // Prompt for user input and read a line of input from the scanner
            System.out.print("> ");
            String input = scanner.nextLine();

            // Handle the user input as a command
            handleCommand(input);
        }
    }

    public static void main(String[] args) {
        // Create a new instance of Compost and run it
        Compost compost = new Compost();
        compost.run();
    }
}
