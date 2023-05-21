# compost.java
# Compost
Compost is a simple operating environment in Java that allows users to create, kill, and list processes that execute commands. Compost consists of two classes: Compost and Process.

Compost class
The Compost class represents the main environment that handles user input and output. It has the following fields:

processes: A list of processes running in the environment
scanner: A scanner for user input
It has the following methods:

Compost(): A constructor that initializes the environment
createProcess(String name, String command): A method that creates and runs a new process with the given name and command
killProcess(String name): A method that kills a process by name
listProcesses(): A method that lists all the processes running in the environment
handleCommand(String command): A method that handles user commands
run(): A method that runs the main loop of the environment
main(String[] args): The main method that creates and runs an instance of Compost
Process class
The Process class represents a process running in Compost that executes a command. It implements the Runnable interface to run in a separate thread. It has the following fields:

name: The name of the process
command: The command to execute by the process
runtime: The runtime object to execute commands by the process
proc: The process object to represent the execution of commands by the process
isr: The input stream reader to read output from commands executed by the process
br: The buffered reader to read output from commands executed by the process
osw: The output stream writer to write input to commands executed by the process
bw: The buffered writer to write input to commands executed by the process
alive: A flag to indicate whether the process is alive or not
It has the following methods:

Process(String name, String command): A constructor that initializes a new process with a given name and command
getName(): A getter method for the name field
getCommand(): A getter method for the command field
isAlive(): A getter method for the alive field
kill(): A method that kills the process and sets the alive flag to false
run(): A method that runs the process and reads and prints output from commands executed by the process
toString(): A method that returns a string representation of the process
User commands
The user can interact with Compost by typing commands in the console. The available commands are:

create <name> <command>: Creates a new process with the given name and command. For example, create hello echo Hello World will create a process named hello that executes the echo command with Hello World as an argument.
kill <name>: Kills a process by name. For example, kill hello will kill the process named hello if it exists.
list: Lists all the processes running in Compost. For example, list will print something like this:
> Processes running in Compost:
Process{name='hello', command='echo Hello World', alive=true}
Process{name='date', command='date', alive=true}
>
Copy
exit: Exits Compost. For example, exit will print a farewell message and terminate the program.
# Linux Examples
Here are some examples of how to use Compost:

To run Compost, compile and run the Compost.java file. You should see something like this:
Welcome to Compost, a simple operating environment in Java.
Type 'create <name> <command>' to create a new process.
Type 'kill <name>' to kill a process by name.
Type 'list' to list all the processes running in Compost.
Type 'exit' to exit Compost.
>
Copy
To create a new process that prints the current date and time every second, type create date watch date. You should see something like this:
> create date watch date
Created process date with command watch date
date: Sun May 21 15:47:37 GMT+01:00 2023
date: Sun May 21 15:47:38 GMT+01:00 2023
date: Sun May 21 15:47:39 GMT+01:00 2023
>
Copy
To create another process that prints a random number every second, type create random watch shuf -i 1-100 -n 1. You should see something like this:
> create random watch shuf -i 1-100 -n 1
Created process random with command watch shuf -i 1-100 -n 1
random: 42
random: 17
random: 76
>
Copy
To list all the processes running in Compost, type list. You should see something like this:
> list
Processes running in Compost:
Process{name='date', command='watch date', alive=true}
Process{name='random', command='watch shuf -i 1-100 -n 1', alive=true}
>
Copy
To kill the process that prints the current date and time, type kill date. You should see something like this:
> kill date
Killed process date
>
Copy
To exit Compost, type exit. You should see something like this:
> exit
Exiting Compost. Goodbye!
>
# windows examples
To create a new process that prints the current date and time every second, type create date cmd /c "for /l %x in (0,0,0) do @echo %date% %time%". You should see something like this:
> create date cmd /c "for /l %x in (0,0,0) do @echo %date% %time%"
Created process date with command cmd /c "for /l %x in (0,0,0) do @echo %date% %time%"
date: Sun 05/21/2023 15:47:37.00
date: Sun 05/21/2023 15:47:38.00
date: Sun 05/21/2023 15:47:39.00
>
Copy
To create another process that prints a random number every second, type create random cmd /c "for /l %x in (0,0,0) do @set /a num=%random% %% 100 + 1 & echo %num%". You should see something like this:
> create random cmd /c "for /l %x in (0,0,0) do @set /a num=%random% %% 100 + 1 & echo %num%"
Created process random with command cmd /c "for /l %x in (0,0,0) do @set /a num=%random% %% 100 + 1 & echo %num%"
random: 42
random: 17
random: 76
>
Copy
To list all the processes running in Compost, type list. You should see something like this:
> list
Processes running in Compost:
Process{name='date', command='cmd /c "for /l %x in (0,0,0) do @echo %date% %time%"', alive=true}
Process{name='random', command='cmd /c "for /l %x in (0,0,0) do @set /a num=%random% %% 100 + 1 & echo %num%"', alive=true}
>
Copy
To kill the process that prints the current date and time, type kill date. You should see something like this:
> kill date
Killed process date
>
Copy
To exit Compost, type exit. You should see something like this:
> exit
Exiting Compost. Goodbye!
>
