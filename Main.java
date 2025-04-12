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
            }
        }
    }
}
