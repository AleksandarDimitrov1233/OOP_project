package Commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import TableUtils.Cell.Type;

public class SaveAs extends Command {
    @Override
    public void execute(String[] args) {
         if (gTable == null) {
        System.out.println("Table not open. Please use open <file_name>.")                                          
        return;
    }
        try {
            var res = new StringBuilder();
            for (var row : gTable.table) {
                for (var elem : row) {
                    if (elem.getType() == Type.STR) {
                        String fixed = "\"" + elem.toString(true).replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
                        res.append(fixed);
                        continue;
                    }
                    res.append(elem.toString(true));
                    if (elem != row.get(row.size() - 1)) {
                        res.append(',');
                    }
                }
                res.append('\n');
            }
            File file = new File(args[1]);
            if (file.exists()) {
                System.out.println("File already exists.");
            }
            FileWriter fw = new FileWriter(file);
            fw.write(res.toString());
            Files.write(Paths.get(args[1]), res.toString().getBytes());
            fw.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + args[1]);
        }
    }
}
