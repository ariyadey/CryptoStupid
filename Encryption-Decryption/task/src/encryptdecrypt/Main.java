package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        System.out.println(getEncrypted("we found a treasure!"));
    }

    private static String getEncrypted(String string) {
        final var chars = string.toCharArray();
        final var encrypted = new char[string.length()];
        for (var i = 0; i < string.length(); i++) {
            //todo store bounds to reuse
            if (chars[i] >= 97 && chars[i] <= 122) {
                encrypted[i] = (char) (97 + 122 - chars[i]);
            } else if (chars[i] >= 65 && chars[i] <= 90) {
                encrypted[i] = (char) (65 + 90 - chars[i]);
            } else {
                encrypted[i] = chars[i];
            }
        }
        return String.valueOf(encrypted);
    }
}
