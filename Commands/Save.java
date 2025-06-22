package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import TableUtils.Cell.Type;

public class Save extends Command {
    @Override
    public void execute(String[] args) {
       if (gTable == null) {
        System.out.println("Table not open. Please use open <file_name>.");
        return;
    }
        try {
            var res = new StringBuilder();
            for (var row : gTable.table) {
                for (var elem : row) {
                    if (elem.getType() == Type.STR) {
                        String fixed = "\"" + elem.toString(true).replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
                        res.append(fixed);
                        if (elem != row.get(row.size() - 1)) {
                            res.append(',');
                        }
                        continue;
                    }
                    res.append(elem.toString(true));
                    if (elem != row.get(row.size() - 1)) {
                        res.append(',');
                    }
                }
                res.append('\n');
            }
            Files.write(Paths.get(gFileName), res.toString().getBytes());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + gFileName);            
        }
    }
}
