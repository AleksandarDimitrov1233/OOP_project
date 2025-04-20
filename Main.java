import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Object>> spreadsheet = new ArrayList<ArrayList<Object>>;
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice!=7) {
            System.out.println("1: Enter an integer:");
            System.out.println("2: Enter a double number:");
            System.out.println("3: Enter a string:");
            System.out.println("4: Enter a formula:");
            System.out.println("5: Edit a number:");
            System.out.println("6: Print all data:");
            System.out.println("7: Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter an integer: ");
                    int intValue = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Object> intRow = new ArrayList<>();
                    intRow.add(intValue);
                    spreadsheet.add(intRow);
                    break;
                 case 2:
                    System.out.println("Enter a double number: ");
                    double doubleValue = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Object> doubleRow = new ArrayList<>();
                    doubleRow.add(doubleValue);
                    spreadsheet.add(doubleRow);
                    break;
                case 3:
                    System.out.println("Enter a string: ");
                    String stringValue = String.valueOf(scanner.nextInt());
                    scanner.nextLine();
                    ArrayList<Object> stringRow = new ArrayList<>();
                    stringRow.add(stringValue);
                    spreadsheet.add(stringRow);
                    break; 
                    case 4:
                        System.out.println("Enter a formula: ");
                        String formulaValue = scanner.nextLine();
                        ArrayList<Object> formulaRow = new ArrayList<>();
                        formulaRow.add(formulaValue);
                        spreadsheet.add(formulaRow);
                        break;
                        case 5:
                            System.out.println("Enter a number: ");
                            String numberValue = scanner.nextLine();
                            ArrayList<Object> numberRow = new ArrayList<>();
                            numberRow.add(numberValue);
                            spreadsheet.add(numberRow);
                            break;
                            case 6:
                                System.out.println("Edit a number: ");
                                
            }
        }
    }
}
