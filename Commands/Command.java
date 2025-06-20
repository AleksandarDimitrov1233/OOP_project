package Commands;

import TableUtils.Table;

public abstract class Command {
    public  static Table gTable = null;
    public  static String gFileName = null;
    public void execute(String[] args) {
    if (gTable == null) {
        System.out.println("Table not open");
        return;
    }
  }
}
