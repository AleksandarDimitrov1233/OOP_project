package Commands;

public class Exit extends Command {
    @Override
    public void execute(String[] args) {
        if (gTable == null) {
        System.out.println("Table not open. Please use open <file_name>.");
        return;
    }
        System.exit(0);
    }
}
