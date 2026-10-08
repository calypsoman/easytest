import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, Integer> hmap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plaintext?");
        String msg1 = scanner.nextLine();
        System.out.println("Redact?");
        String msg2 = scanner.nextLine();
        System.out.println("Fibonacci?");
        int num = Integer.parseInt(scanner.nextLine());

        String result = Main.redact(msg1, msg2);
        System.out.println(result);
        System.out.println(Main.fib(num));
    }

    public static String redact(String text, String bad) {
        char[] digits = text.toCharArray();

        for (int i = 0; i < text.length() - bad.length(); i++) {
            if (text.substring(i, i + bad.length()).equals(bad)) {
                for (int j = i; j < i + bad.length(); j++) {
                    digits[j] = '*';
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (char x: digits) {
            output.append(x);
        }

        return output.toString();
    }

    public static int fib (int x) {
        if (x == 1) {
            return 1;
        }

        if (x == 0) {
            return 1;
        }

        if (hmap.get(x) != null) {
            return hmap.get(x);
        }

        hmap.put(x, Main.fib(x-1) + Main.fib(x-2));
        return hmap.get(x);
    }
}