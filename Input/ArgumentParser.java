package Input;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser {
    public static List<String> parseArguments(String input, Boolean escapedQuotes) {
        List<String> args = new ArrayList<>();
        StringBuilder currentArg = new StringBuilder();
        boolean inQuote = false;

        for (char c : input.toCharArray()) {
            if (c == '"') {
              if (inQuote) {
                inQuote = false;
                if (escapedQuotes) {
                    currentArg.append(c);
                }
            } else {
                inQuote = true;
                if (escapedQuotes) {
                    currentArg.append(c);
                }
             }
            } else if (c == ' ' && !inQuote) {
                if (currentArg.length() > 0) {
                    args.add(currentArg.toString());
                    currentArg.setLength(0);
                }
            } else {
                currentArg.append(c);
            }
        }

        if (currentArg.length() > 0) {
            args.add(currentArg.toString());
        }

        return args;
    }
}
