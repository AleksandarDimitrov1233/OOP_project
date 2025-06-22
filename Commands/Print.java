package Commands;

import TableUtils.Table;

public class Print extends Command {
    @Override
    public void execute(String[] args) {
         if (gTable == null) {
        System.out.println("Table not open. Please use open <file_name>.");
        return;
    }
        Table.prettyPrint(gTable.table);
    }
}
