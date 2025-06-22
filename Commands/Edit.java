package Commands;

import TableUtils.Cell;

public class Edit extends Command {
    @Override
    public void execute(String[] args) {
        if (gTable == null) {
        System.out.println("Table not open. Please use open <file_name>.");
        return;
    }
         if (args.length < 4) {
            System.out.println("Not enough arguments.");
            return;
        }
         if (args.length > 4) {
            System.out.println("Too many arguments.");
            return;
        }
        Cell temp = Cell.parse(args[3], false);
        if (temp == null) {
            return;
        }
                 
        try {
            Integer row = Integer.parseInt(args[1]);
            Integer col = Integer.parseInt(args[2]);
            try {
                gTable.table.get(row - 1).set(col - 1, temp);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out of bounds");
            }
        } catch (Exception e) {
            System.out.println("Invalid column or row");
        }
    }
}
