package Commands;

public class Exit extends Command {
    @Override
    public void execute(String[] args) {
        System.exit(0);
    }
}
