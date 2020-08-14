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
        key = key % ('z' - 'a' + 1);
        for (var i = 0; i < string.length(); i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] += (chars[i] + key <= 'z') ? key : ('a' + key - 'z' - 1);
            }
        }
        return String.valueOf(chars);
    }
}
