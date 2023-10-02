import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toLowerCase();
    }

}
