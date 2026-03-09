import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt text
    public static String encrypt(String text, int shift) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch + shift - 65) % 26 + 65);
                result += c;
            } 
            else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch + shift - 97) % 26 + 97);
                result += c;
            } 
            else {
                result += ch;
            }
        }

        return result;
    }

    // Method to decrypt text
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message:");
        String message = sc.nextLine();

        System.out.println("Enter shift value:");
        int shift = sc.nextInt();

        String encrypted = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted Message: " + decrypted);

        sc.close();
    }
}
