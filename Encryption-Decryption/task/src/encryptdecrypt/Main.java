package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var input = scanner.nextLine();
        final var key = scanner.nextInt();
        System.out.println(getEncrypted(input, key));
    }

    private static String getEncrypted(String string, int key) {
        final var chars = string.toCharArray();
        final var encrypted = new char[string.length()];
        for (var i = 0; i < string.length(); i++) {

        }
        return String.valueOf(encrypted);
    }
}
