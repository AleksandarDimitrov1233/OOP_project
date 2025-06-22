package TableUtils;

import ExpressionEngine.ExpressionEngine;

public class Cell {
    public enum Type {
        INT, DECIMAL, STR, NONE, EXPR
    }

    private final Type type;
    private final Integer intValue;
    private final Float decimalValue;
    private final String strValue;
    private final String exprValue;

    private Cell(Type type,
            Integer intValue,
            Float decimalValue,
            String strValue,
            String exprValue) {
        this.type = type;
        this.intValue = intValue;
        this.decimalValue = decimalValue;
        this.strValue = strValue;
        this.exprValue = exprValue;
    }

    public static Cell ofInt(int v) {
        return new Cell(Type.INT, v, null, null, null);
    }

    public static Cell ofDecimal(Float v) {
        return new Cell(Type.DECIMAL, null, v, null, null);
    }

    public static Cell ofStr(String v) {
        return new Cell(Type.STR, null, null, v, null);
    }

    public static Cell ofExpr(String v) {
        return new Cell(Type.EXPR, null, null, null, v);
    }

    public static Cell none() {
        return new Cell(Type.NONE, null, null, null, null);
    }

    public boolean isInt() {
        return type == Type.INT;
    }

    public boolean isDecimal() {
        return type == Type.DECIMAL;
    }

    public boolean isStr() {
        return type == Type.STR;
    }

    public boolean isExpr() {
        return type == Type.EXPR;
    }

    public boolean isNone() {
        return type == Type.NONE;
    }

    public Type getType() {
        return type;
    }

    public String toString(Boolean serializing) {
        switch (type) {
            case INT:
                return intValue.toString();
            case DECIMAL:
                return decimalValue.toString();
            case STR:
                return strValue;
            case EXPR:
                if (serializing && exprValue.charAt(0) != '\'') {
                    String serializedExpr = "\'" + exprValue + "\'";
                    return serializedExpr;
                }
                return exprValue;
            default:
                return "";
        }
    }

    public String toStringOnPrint() {
        switch (type) {
            case INT:
                return intValue.toString();
            case DECIMAL:
                return decimalValue.toString();
            case STR:
                return strValue;
            case EXPR:
                String cleaned = exprValue.replace("'", "").replace("=", "").trim();
                Float result = ExpressionEngine.evaluate(cleaned);
                if (result == null) {
                    return "ERROR";
                } else {
                    return result.toString();
                }
            default:
                return "";
        }
    }

   public static Cell parse(String s, Boolean deserializing) {
        String clean = s.replace("\"", "");
        if (s == null || s.isEmpty() || s.replace("\"", "").isBlank() || clean.isBlank()) {
            return Cell.none();
        }
        if (s.charAt(0) == '\'' && s.charAt(1) == '=' || s.charAt(0) == '=' || clean.charAt(0) == '=') {
            if (clean.charAt(0) == '=') {
                return Cell.ofExpr('\'' + clean + '\'');
            }
            return Cell.ofExpr(s);
        }
        try {
            return Cell.ofInt(Integer.parseInt(s));
        } catch (NumberFormatException nfe) {
        }
        try {
            return Cell.ofDecimal(Float.parseFloat(s));
        } catch (NumberFormatException nfe) {
        }
        if (s.charAt(0) == '\"' && s.charAt(s.length() - 1) == '\"') {
            if (!deserializing) {
                return Cell.ofStr(s.substring(1, s.length() - 1));
            }
            return Cell.ofStr(s);
        }
        if (deserializing) {
            return Cell.ofStr(s);
        }
        System.out.println(s + " is an invalid data type");
        return null;
    }
}
