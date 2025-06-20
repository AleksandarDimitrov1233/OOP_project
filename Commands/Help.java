package Commands;

public class Help extends Command {
    @Override
    public void execute(String[] args) {
        if (gTable == null) {
        System.out.println("Table not open");
        return;
    }
        System.out.println("open <file_name>: Opens the specified file. Replace <file_name> with the name of the file you want to open.");
        System.out.println("print: Prints the table.");
        System.out.println("edit <row> <column> <new_value>: Modifies a cell's contents.");
        System.out.println("close: Closes the currently open table.");
        System.out.println("save: Saves the changes made to the currently open table.");
        System.out.println("save_as <file_name>: Saves the currently open table with a new name.");
        System.out.println("help: Displays this help page.");
        System.out.println("exit: Exits the application.");
    }
}
