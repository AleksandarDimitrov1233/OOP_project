package Commands;

import TableUtils.Table;

public class Print extends Command {
    @Override
    public void execute(String[] args) {
         if (gTable == null) {
        System.out.println("Table not open");
        return;
    }
        Table.prettyPrint(gTable.table);
    }
}
