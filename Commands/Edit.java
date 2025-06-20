package Commands;

import TableUtils.Cell;

public class Edit extends Command {
    @Override
    public void execute(String[] args) {
        Cell temp = Cell.parse(args[3]);
        if (temp == null) {
            return;
        }
         if (gTable == null) {
        System.out.println("Table not open");
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
