import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var mode = "enc";
        String data = null;
        var key = Integer.MIN_VALUE;
        String algorithm = null;
        File outFile = null;
        
//         Tries to get needed inputs from main arguments
        for (var i = 0; i < args.length; i += 2)
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    File inFile = new File(args[i + 1]);
                    try (var scanner = new Scanner(inFile)) {
                        data = scanner.nextLine();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
                case "-out":
                    outFile = new File(args[i + 1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }

//         Gets the missed data from user input
        try (var scanner = new Scanner(System.in)) {

            if (data == null) {
                System.out.println("Data:");
                data = scanner.nextLine();
            }

            if (key == Integer.MIN_VALUE) {
                System.out.print("key: ");
                key = scanner.nextInt();
            }

            if (algorithm == null) {
                System.out.print("Algorithm: ");
                algorithm = scanner.next();
            }
        }

//         Creates a new instance of Context class in Strategy Pattern
        var cryptor = new Cryptor();
//         Specifies the algorithm to be used according to user input
        switch (algorithm) {
            case "shift":
                if (mode.equals("enc")) {
                    cryptor.setAlgorithm(new ShiftingEncryption());
                } else {
                    cryptor.setAlgorithm(new ShiftingDecryption());
                }
                break;
            case "unicode":
                if (mode.equals("enc")) {
                    cryptor.setAlgorithm(new UnicodeEncryption());
                } else {
                    cryptor.setAlgorithm(new UnicodeDecryption());
                }
                break;
        }
//         Executes the algorithm
        var crypted = cryptor.crypt(data, key);

//         Writes to console or the specified file
        if (outFile == null) {
            System.out.println(crypted);
        } else {
            try (var printWriter = new PrintWriter(outFile)) {
                printWriter.println(crypted);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
