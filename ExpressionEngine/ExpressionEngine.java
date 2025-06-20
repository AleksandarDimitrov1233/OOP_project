package ExpressionEngine;
import Commands.Command;
import TableUtils.Cell;


public class ExpressionEngine {

    public static Float dereferenceCell(String cellPos) {
        if (cellPos.charAt(0) == 'R') {
            if (cellPos.charAt(2) == 'C') {
                try {
                    Integer rowPos = Integer.parseInt(String.valueOf(cellPos.charAt(1)));
                    try {
                        Integer colPos = Integer.parseInt(String.valueOf(cellPos.charAt(3)));
                        Cell contents = Command.gTable.table.get(rowPos - 1).get(colPos - 1);
                        switch (contents.getType()) {
                            case INT:
                                return Float.parseFloat(contents.toString(false));
                            case DECIMAL:
                                return Float.parseFloat(contents.toString(false));
                            case STR:
                                return 0f;
                            case NONE:
                                return 0f;
                            default:
                                return 0f;
                        }
                    } catch (Exception e) {
                        return 0f;
                    }
                } catch (Exception e) {
                    return 0f;
                }
            }
        }
        return 0f;
    }

    public static Float evaluate(String expression) {
        String[] splitStr = expression.split(" ");
        if (splitStr.length > 3) {
            System.out.println("Malformed expression");
            return null;
        }
        Float lhs = null;
        try {
            lhs = dereferenceCell(splitStr[0]);
        } catch (NumberFormatException e) {
            lhs = 0f;
        }
        Float rhs = null;
        try {
            rhs = dereferenceCell(splitStr[2]);
        } catch (NumberFormatException e) {
            rhs = 0f;
        }
        switch (splitStr[1]) {
            case "+":
                return lhs + rhs;
            case "-":
                return lhs - rhs;
            case "*":
                return lhs * rhs;
            case "/":
                if (rhs == 0) {
                    return null;
                }
                return lhs / rhs;
            case "^":
                return (float)Math.pow(lhs, rhs);
            default:
                return null;
        }
    }
}
