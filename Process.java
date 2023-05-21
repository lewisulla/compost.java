// Process.java
// A class that represents a process running in Compost

import java.io.*;
public class Process implements Runnable {

    // The name of the process
    private String name;

    // The command to execute by the process
    private String command;

    // The runtime object to execute commands by the process
    private Runtime runtime;

    // The process object to represent the execution of commands by the process
    private java.lang.Process proc;

    // The input stream reader to read output from commands executed by the process
    private InputStreamReader isr;

    // The buffered reader to read output from commands executed by the process
    private BufferedReader br;

    // The output stream writer to write input to commands executed by the process
    private OutputStreamWriter osw;

    // The buffered writer to write input to commands executed by the process
    private BufferedWriter bw;

    // A flag to indicate whether the process is alive or not
    private boolean alive;

    // A constructor that initializes a new process with a given name and command
    public Process(String name, String command) throws Exception {

        this.name = name;
        this.command = command;
        runtime = Runtime.getRuntime();
        proc = runtime.exec(command);
        isr = new InputStreamReader(proc.getInputStream());
        br = new BufferedReader(isr);
        osw = new OutputStreamWriter(proc.getOutputStream());
        bw = new BufferedWriter(osw);
        alive = true;

    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        try {
            proc.destroy();
            alive = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (alive) {

                while (br.ready()) {

                    String line = br.readLine();
                    System.out.println(name + ": " + line);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override

    public String toString() {

        return "Process{" +

                "name='" + name + '\'' +

                ", command='" + command + '\'' +

                ", alive=" + alive +

                '}';

    }
}