package TableUtils;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<List<Cell>> table = null;

    public Table(String rawTableData) {
        try {
            this.table = parse(rawTableData);
            Integer maxLen = 0;
            for (List<Cell> row : table) {
                if (row.size() > maxLen) {
                    maxLen = row.size();
                }
            }
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i).size() < maxLen) {
                    while (table.get(i).size() != maxLen) {
                        table.get(i).add(Cell.parse("", true));
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<List<Cell>> parse(String text) {
        List<List<Cell>> table = new ArrayList<>();

        for (String row : text.split("\n")) {
            List<Cell> fields = new ArrayList<>();
            StringBuilder cell = new StringBuilder();
            boolean inQuotes = false;

            for (int i = 0; i < row.length(); i++) {
                char c = row.charAt(i);

                if (c == '\\' && inQuotes && i + 1 < row.length() && row.charAt(i + 1) == '"') {
                    cell.append('"');
                    i++; 
                } else if (c == '"') {
                    inQuotes = !inQuotes;
                } else if (c == ',' && !inQuotes) {
                    addField(fields, cell.toString());
                    cell.setLength(0);
                } else {
                    cell.append(c);
                }
            }
            addField(fields, cell.toString());

            for (Cell c : fields) {
                String f = c.toString();
                if (!f.startsWith("\"")
                        && f.matches(".*\\d+\\s+\\d+.*")) {
                    throw new IllegalArgumentException(
                            "Missing comma in row: \"" + row + "\"");
                }
            }

            table.add(fields);
        }

        return table;
    }

    private static void addField(List<Cell> fields, String raw) {
        fields.add(Cell.parse(raw.trim(), true));
    }

    public static void prettyPrint(List<List<Cell>> table) {
        if (table.isEmpty())
            return;

        int cols = table.stream().mapToInt(List::size).max().orElse(0);
        int[] colWidths = new int[cols];
        for (List<Cell> row : table) {
            for (int c = 0; c < row.size(); c++) {
                colWidths[c] = Math.max(colWidths[c], row.get(c).toString(false).length());
            }
        }

        Runnable printBorder = () -> {
            StringBuilder b = new StringBuilder("+");
            for (int w : colWidths) {
                b.append("-".repeat(w + 2)).append("+");
            }
            System.out.println(b);
        };

        printBorder.run();
        for (List<Cell> row : table) {
            StringBuilder line = new StringBuilder("│");
            for (int c = 0; c < cols; c++) {
                String cell = c < row.size() ? row.get(c).toStringOnPrint() : "";
                line.append(" ")
                        .append(cell)
                        .append(" ".repeat(colWidths[c] - cell.length()))
                        .append(" │");
            }
            System.out.println(line);
            printBorder.run();
        }
    }
}
