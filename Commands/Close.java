package Commands;

public class Close extends Command {
    @Override
    public void execute(String[] args) {
        gTable = null;
        gFileName = null;
    }
}
   

