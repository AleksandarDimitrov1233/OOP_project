import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
           ArrayList <Object> spreadsheet = new ArrayList <Object>();
           Scanner scanner = new Scanner(System.in);

        int size;
        System.out.println("How many values do you want to add?");
        size = scanner.nextInt();
        System.out.println("1: Enter an integer:");
        System.out.println("2: Enter a double number:");
        System.out.println("3: Enter a string:");
        System.out.println("4: Enter a formula:");
        System.out.println("5: Edit a number:");
        System.out.println("6: Print all data:");

    }
}
