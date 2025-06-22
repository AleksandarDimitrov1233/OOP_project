import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import Commands.Command;
import Commands.Edit;
import Commands.Exit;
import Commands.Close;
import Commands.Help;
import Commands.Open;
import Commands.Print;
import Commands.Save;
import Commands.SaveAs;
import Input.ArgumentParser;

public class App {
    public static void main(String[] args) {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commands.put("open", (new Open()));
        commands.put("print", (new Print()));
        commands.put("edit", (new Edit()));
        commands.put("close", (new Close()));
        commands.put("save", (new Save()));
        commands.put("save_as", (new SaveAs()));
        commands.put("help", (new Help()));
        commands.put("exit", (new Exit()));
        Scanner s = new Scanner(System.in);
        while (true) {
            new Help().execute(null);
            System.out.print("Your choice: ");
            String input = s.nextLine();
            List<String> split = ArgumentParser.parseArguments(input, false);
            Command action = commands.get(split.get(0));
            if (action == null) {
                System.out.println("Command not found");
                continue;
            }
            try {
                String[] arguments = split.toArray(new String[0]);
                 if (arguments[0].equals("edit")) {
                    List<String> splitEscaped = ArgumentParser.parseArguments(input, true);
                    String[] argumentsEscaped = splitEscaped.toArray(new String[0]);
                    action.execute(argumentsEscaped);
                    continue;
                }
                action.execute(arguments);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
