package calculator.app;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a mathematical operation: ");
        String input = sc.nextLine();
        try {
            System.out.println(Calculator.calc(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
