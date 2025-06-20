package Commands;

public class Exit extends Command {
    @Override
    public void execute(String[] args) {
        if (gTable == null) {
        System.out.println("Table not open");
        return;
    }
        System.exit(0);
    }
}
